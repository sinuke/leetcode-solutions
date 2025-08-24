package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PathSumIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void pathSum(TreeNode root, int targetSum, List<List<Integer>> expected) {
        var solution = new PathSumII();

        var actual = solution.pathSum(root, targetSum);

        var expectedSet = new HashSet<Set<Integer>>();
        expected.forEach(n -> expectedSet.add(new HashSet<>(n)));

        assertEquals(expected.size(), actual.size());
        actual.forEach(a -> assertTrue(expectedSet.contains(new HashSet<>(a))));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,5,1}), 22, List.of(List.of(5,4,11,2), List.of(5,8,4,5))),
                Arguments.of(buildTree(new Integer[] {1,2,3}), 5, List.of()),
                Arguments.of(buildTree(new Integer[] {1,2}), 0, List.of())
        );
    }

}
