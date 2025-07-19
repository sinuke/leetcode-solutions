package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveSubFoldersFromTheFilesystemTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeSubfolders(String[] folder, List<String> expected) {
        var solution = new RemoveSubFoldersFromTheFilesystem();
        assertEquals(expected, solution.removeSubfolders(folder));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"/a","/a/b","/c/d","/c/d/e","/c/f"}, List.of("/a","/c/d","/c/f")),
                Arguments.of(new String[] {"/a","/a/b/c","/a/b/d"}, List.of("/a")),
                Arguments.of(new String[] {"/a/b/c","/a/b/ca","/a/b/d"}, List.of("/a/b/c","/a/b/ca","/a/b/d"))
        );
    }

}
