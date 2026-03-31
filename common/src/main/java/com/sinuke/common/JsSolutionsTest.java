package com.sinuke.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinuke.common.model.BaseTestData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;
import tools.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Testcontainers
public abstract class JsSolutionsTest extends AbstractTestCase<JsSolutionsTest.JsTestData> {

    private static final String NODE_IMAGE = "node:lts-alpine";
    private static final String RUNNER_CONTAINER_PATH = "/app/runner.js";
    private static final String TEST_CONTAINER_DIR = "/tmp/js-test";

    private GenericContainer<?> container;
    private Map<String, JsTestData> testDataMap;

    @Override
    public void beforeAll() throws Exception {
        container = new GenericContainer<>(NODE_IMAGE)
                .withCommand("sh", "-c", "while :; do sleep 1; done");
        container.start();

        container.execInContainer("mkdir", "-p", "/app");
        container.copyFileToContainer(
                MountableFile.forClasspathResource("runner.js"),
                RUNNER_CONTAINER_PATH
        );

        testDataMap = findTestData(
                "js/",
                p -> p.toString().endsWith(".js"),
                JsTestData.class
        );
    }

    @Override
    public void afterAll() throws Exception {
        if (container != null) container.stop();
    }

    @Override
    public void beforeEach() {
    }

    @Override
    public Map<String, JsTestData> getTestData() {
        return testDataMap;
    }

    @Override
    public void assertTestCase(JsTestData testData, String solutionFile) throws Exception {
        var solutionPath = Paths.get(solutionFile);
        var testDir = solutionPath.getParent().resolve("test");

        container.execInContainer("mkdir", "-p", TEST_CONTAINER_DIR);

        container.copyFileToContainer(
                MountableFile.forHostPath(solutionPath),
                TEST_CONTAINER_DIR + "/solution.js"
        );
        container.copyFileToContainer(
                MountableFile.forHostPath(testDir.resolve("test-data.json")),
                TEST_CONTAINER_DIR + "/test-data.json"
        );

        var result = container.execInContainer(
                "node", RUNNER_CONTAINER_PATH,
                TEST_CONTAINER_DIR + "/test-data.json",
                TEST_CONTAINER_DIR + "/solution.js"
        );

        if (!result.getStderr().isBlank()) {
            fail("Node.js runner error:\n" + result.getStderr());
        }

        var mapper = new ObjectMapper();
        var actual = mapper.readTree(result.getStdout().trim());
        var expected = mapper.readTree(
                Files.readString(testDir.resolve(testData.getExpected()), StandardCharsets.UTF_8)
        );

        assertEquals(expected, actual, "Check that result equals to expected one");
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class JsTestData extends BaseTestData {

        @JsonProperty("expected")
        private String expected;

    }

}
