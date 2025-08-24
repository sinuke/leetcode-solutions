package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTiltTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findTilt(TreeNode root, int expected) {
        var solution = new BinaryTreeTilt();
        assertEquals(expected, solution.findTilt(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,2,3}), 1),
                Arguments.of(buildTree(new Integer[]{4,2,9,3,5,null,7}), 15),
                Arguments.of(buildTree(new Integer[]{21,7,14,1,1,2,2,3,3}), 9)
        );
    }

}
