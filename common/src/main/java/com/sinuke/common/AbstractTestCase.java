package com.sinuke.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinuke.common.model.BaseTestData;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractTestCase<T extends BaseTestData> {

    public abstract String getTitle();
    public abstract void beforeAll() throws Exception;
    public abstract void afterAll() throws Exception;
    public abstract void beforeEach();
    public abstract void assertTestCase(T testData, String solutionFile) throws Exception;
    public abstract Map<String, T> getTestData();

    @BeforeAll
    protected final void initialize() throws Exception {
        beforeAll();
    }

    @AfterAll
    protected final void tearDown() throws Exception {
        afterAll();
    }

    @BeforeEach
    protected final void beforeEachInit() {
        beforeEach();
    }

    @ParameterizedTest(name = "{0} - {index}: {1}")
    @MethodSource("testData")
    void solutionTest(String title, T testData, String solutionFile) throws Exception {
        assertNotNull(testData, "Checks if test data is available");
        assumeTrue(testData.isEnabled(), "Checks if test is enabled");

        assertTestCase(testData, solutionFile);
    }

    public Map<String, T> findTestData(String rootDir, Predicate<Path> filter, Class<T> type) throws IOException {
        Map<String, T> map = new HashMap<>();
        var mapper = new ObjectMapper();

        try (Stream<Path> walk = Files.walk(Paths.get(rootDir))) {
            walk
                    .filter(Files::isRegularFile)
                    .filter(filter)
                    .forEach(p -> {
                        var testDataFile = p.getParent().resolve("test/test-data.json");
                        if (Files.exists(testDataFile)) map.put(p.toString(), parseTestDate(mapper, testDataFile.toFile(), type));
                        else map.put(p.toString(), null);
                    });
        }

        return map;
    }

    @SneakyThrows
    private T parseTestDate(ObjectMapper mapper, File file, Class<T> type) {
        return mapper.readValue(file, type);
    }

    private Stream<Arguments> testData() {
        return getTestData().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(BaseTestData::getNumber)))
                .map(entry -> Arguments.of(getTitle(), entry.getValue(), entry.getKey()));
    }

}
