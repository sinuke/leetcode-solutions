package com.sinuke.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinuke.common.model.BaseTestData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.Transferable;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
public abstract class ShellSolutionsTest extends AbstractTestCase<ShellSolutionsTest.ShellTestData> {

    private GenericContainer<?> container;
    private Map<String, ShellTestData> testDataMap;

    @Override
    public void beforeAll() throws Exception {
        testDataMap = findTestData(
                "shell/", 
                p -> p.toString().endsWith(".sh"),
                ShellTestData.class
        );    
    }

    @Override
    public void afterAll() {
        if (container != null) container.stop();
    }

    @Override
    public void beforeEach() {
        
    }

    @Override
    public Map<String, ShellTestData> getTestData() {
        return testDataMap;
    }

    @Override
    public void assertTestCase(ShellTestData testData, String solutionFile) throws Exception {
        var solutionFilePath = Paths.get(solutionFile);

        container = new GenericContainer<>("alpine:latest")
                .withCommand("sh", "-c", "while :; do sleep 1; done")
                .withWorkingDirectory(testData.workingDir)
                .withCopyToContainer(
                        MountableFile.forHostPath(solutionFilePath.getParent().resolve("test/" + testData.getInput())),
                        testData.workingDir + "/" + testData.getInput()
                )
                .withCopyToContainer(
                        Transferable.of(Files.readString(solutionFilePath, StandardCharsets.UTF_8)),
                        testData.workingDir + "/solution.sh"
                );
        container.start();

        container.execInContainer("chmod", "+x", "solution.sh");
        var results = container.execInContainer("sh", "-c", "./solution.sh");

        assertNotNull(results.getStdout(), "Checks if solution produced results");

        var expected = Files.readString(
                solutionFilePath.getParent().resolve("test/" + testData.resultsFile),
                StandardCharsets.UTF_8
        ).trim();
        var actual = results.getStdout().trim();

        assertEquals(expected, actual, "Checks if result equals to expected one");    
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ShellTestData extends BaseTestData {

        @JsonProperty("input-data")
        private String input;
        @JsonProperty("working-dir")
        private String workingDir;
        @JsonProperty("results-file")
        private String resultsFile;

    }

}
