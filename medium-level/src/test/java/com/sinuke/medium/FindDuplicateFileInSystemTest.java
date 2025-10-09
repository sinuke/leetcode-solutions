package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindDuplicateFileInSystemTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findDuplicate(String[] paths, List<List<String>> expected) {
        var solution = new FindDuplicateFileInSystem();
        var actual = solution.findDuplicate(paths);

        assertEquals(expected.size(), actual.size());

        Set<Set<String>> expectedSet = new HashSet<>();
        Set<Set<String>> actualSet = new HashSet<>();

        for (int i = 0; i < actual.size(); i++) {
            expectedSet.add(new HashSet<>(expected.get(i)));
            actualSet.add(new HashSet<>(actual.get(i)));
        }

        assertEquals(expectedSet, actualSet);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"}, List.of(List.of("root/a/2.txt","root/c/d/4.txt","root/4.txt"), List.of("root/a/1.txt","root/c/3.txt"))),
                Arguments.of(new String[] {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"}, List.of(List.of("root/a/2.txt","root/c/d/4.txt"), List.of("root/a/1.txt","root/c/3.txt"))),
                Arguments.of(new String[] {"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"}, List.of())
        );
    }

}
