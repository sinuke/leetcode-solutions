package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimplifyPathTest {

    @ParameterizedTest
    @MethodSource("testData")
    void simplifyPath(String path, String expected) {
        var solution = new SimplifyPath();
        assertEquals(expected, solution.simplifyPath(path));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("/home/", "/home"),
                Arguments.of("/home//foo/", "/home/foo"),
                Arguments.of("/home/user/Documents/../Pictures", "/home/user/Pictures"),
                Arguments.of("/../", "/"),
                Arguments.of("/.../a/../b/c/../d/./", "/.../b/d"),
                Arguments.of("/a/./b/../../c/", "/c"),
                Arguments.of("/a/..", "/"),
                Arguments.of("/a/...", "/a/...")
        );
    }

}
