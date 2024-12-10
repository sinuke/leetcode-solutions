package com.sinuke.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinuke.common.model.BaseTestData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.Transferable;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class ShellSolutionsTest {

    private GenericContainer<?> container;
    private Map<String, ShellTestData> testDataMap;

    @BeforeAll
    protected final void setUp() throws Exception {
        testDataMap = scanDirectory(Paths.get("shell/"));
    }

    @AfterEach
    protected final void tearDown() {
        if (container != null) container.stop();
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("testData")
    void testShell(ShellTestData shellTestData, String shellFile) throws Exception {
        assertNotNull(shellTestData, "Checks if test data is available");
        assumeTrue(shellTestData.isEnabled(), "Checks if test is enabled");

        var shellFilePath = Paths.get(shellFile);

        container = new GenericContainer<>("alpine:latest")
                .withCommand("sh", "-c", "while :; do sleep 1; done")
                .withWorkingDirectory(shellTestData.workingDir)
                .withCopyToContainer(
                        MountableFile.forHostPath(shellFilePath.getParent().resolve("test/" + shellTestData.getInput())),
                        shellTestData.workingDir + "/" + shellTestData.getInput()
                )
                .withCopyToContainer(
                        Transferable.of(Files.readString(shellFilePath, StandardCharsets.UTF_8)),
                        shellTestData.workingDir + "/solution.sh"
                );
        container.start();

        container.execInContainer("chmod", "+x", "solution.sh");
        var results = container.execInContainer("sh", "-c", "./solution.sh");

        assertNotNull(results.getStdout(), "Checks if solution produced results");

        var expected = Files.readString(
                shellFilePath.getParent().resolve("test/" + shellTestData.resultsFile),
                StandardCharsets.UTF_8
        ).trim();
        var actual = results.getStdout().trim();

        assertEquals(expected, actual, "Checks if result equals to expected one");
    }

    private Stream<Arguments> testData() {
        return testDataMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(BaseTestData::getNumber)))
                .map(entry -> Arguments.of(entry.getValue(), entry.getKey()));
    }

    private Map<String, ShellTestData> scanDirectory(Path rootDir) throws IOException {
        Map<String, ShellTestData> map = new HashMap<>();
        var mapper = new ObjectMapper();

        try (Stream<Path> walk = Files.walk(rootDir)) {
            walk
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".sh"))
                    .forEach(p -> {
                        var testDataFile = p.getParent().resolve("test/test-data.json");
                        if (Files.exists(testDataFile)) map.put(p.toString(), parseTestDataFromFile(mapper, testDataFile.toFile()));
                        else map.put(p.toString(), null);
                    });
        }

        return map;
    }

    @SneakyThrows
    private ShellTestData parseTestDataFromFile(ObjectMapper mapper, File file) {
        return mapper.readValue(file, ShellTestData.class);
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
