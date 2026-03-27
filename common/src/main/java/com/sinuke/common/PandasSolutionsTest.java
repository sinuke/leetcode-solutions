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
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Testcontainers
public abstract class PandasSolutionsTest extends AbstractTestCase<PandasSolutionsTest.PandasTestData> {

    private static final String PYTHON_IMAGE = "python:3.12-slim";
    private static final String RUNNER_CONTAINER_PATH = "/app/runner.py";
    private static final String TEST_CONTAINER_DIR = "/tmp/pandas-test";

    private GenericContainer<?> container;
    private Map<String, PandasTestData> testDataMap;

    @Override
    public void beforeAll() throws Exception {
        container = new GenericContainer<>(PYTHON_IMAGE)
                .withCommand("sh", "-c", "while :; do sleep 1; done");
        container.start();

        container.execInContainer("pip", "install", "pandas", "--quiet", "--no-input");

        container.execInContainer("mkdir", "-p", "/app");
        container.copyFileToContainer(
                MountableFile.forClasspathResource("runner.py"),
                RUNNER_CONTAINER_PATH
        );

        testDataMap = findTestData(
                "pandas/",
                p -> p.toString().endsWith(".py"),
                PandasTestData.class
        );
    }

    @Override
    public void afterAll() throws Exception {
        if (container != null) container.stop();
    }

    @Override
    public void beforeEach() {
        // nothing to do
    }

    @Override
    public Map<String, PandasTestData> getTestData() {
        return testDataMap;
    }

    @Override
    public void assertTestCase(PandasTestData testData, String solutionFile) throws Exception {
        var solutionPath = Paths.get(solutionFile);
        var testDir = solutionPath.getParent().resolve("test");

        container.execInContainer("mkdir", "-p", TEST_CONTAINER_DIR);

        container.copyFileToContainer(
                MountableFile.forHostPath(solutionPath),
                TEST_CONTAINER_DIR + "/solution.py"
        );
        container.copyFileToContainer(
                MountableFile.forHostPath(testDir.resolve("test-data.json")),
                TEST_CONTAINER_DIR + "/test-data.json"
        );
        for (var input : testData.getInputs()) {
            container.copyFileToContainer(
                    MountableFile.forHostPath(testDir.resolve(input.getFile())),
                    TEST_CONTAINER_DIR + "/" + input.getFile()
            );
        }

        var result = container.execInContainer(
                "python3", RUNNER_CONTAINER_PATH,
                TEST_CONTAINER_DIR + "/test-data.json",
                TEST_CONTAINER_DIR + "/solution.py"
        );

        if (!result.getStderr().isBlank()) {
            fail("Python runner error:\n" + result.getStderr());
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
    public static class PandasTestData extends BaseTestData {

        @JsonProperty("function")
        private String function;

        @JsonProperty("inputs")
        private List<InputSpec> inputs;

        @JsonProperty("expected")
        private String expected;

        @Getter
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class InputSpec {
            @JsonProperty("name")
            private String name;
            @JsonProperty("type")
            private String type;
            @JsonProperty("file")
            private String file;
        }

    }

}
