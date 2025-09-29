package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteNodesAndReturnForestTest {

    @ParameterizedTest
    @MethodSource("testData")
    void delNodes(TreeNode root, int[] to_delete, List<TreeNode> expected) {
        var solution = new DeleteNodesAndReturnForest();
        List<TreeNode> actual = solution.delNodes(root, to_delete);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(toArray(expected.get(i)), toArray(actual.get(i)));
        }
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,2,3,4,5,6,7}), new int[] {3, 5}, List.of(buildTree(new Integer[] {1,2,null,4}), buildTree(new Integer[]{6}),  buildTree(new Integer[]{7}))),
                Arguments.of(buildTree(new Integer[]{1,2,4,null,3}), new int[] {3}, List.of(buildTree(new Integer[] {1,2,4})))
        );
    }

}
