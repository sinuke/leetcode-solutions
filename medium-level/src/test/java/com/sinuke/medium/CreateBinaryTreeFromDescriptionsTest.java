package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CreateBinaryTreeFromDescriptionsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void createBinaryTree(int[][] descriptions, TreeNode expected) {
        assertArrayEquals(toArray(expected), toArray(new CreateBinaryTreeFromDescriptions().createBinaryTree(descriptions)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}},
                        buildTree(new Integer[]{50, 20, 80, 15, 17, 19})
                ),
                Arguments.of(
                        new int[][]{{1, 2, 1}, {2, 3, 0}, {3, 4, 1}},
                        buildTree(new Integer[]{1, 2, null, null, 3, 4})
                )
        );
    }

}
