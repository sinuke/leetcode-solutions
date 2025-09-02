package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestStringStartingFromLeafTest {

    @ParameterizedTest
    @MethodSource("testData")
    void smallestFromLeaf(TreeNode root, String expected) {
        var solution = new SmallestStringStartingFromLeaf();
        assertEquals(expected, solution.smallestFromLeaf(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{0,1,2,3,4,3,4}), "dba"),
                Arguments.of(buildTree(new Integer[]{25,1,3,1,3,0,2}), "adz"),
                Arguments.of(buildTree(new Integer[]{2,2,1,null,1,0,null,0}), "abc"),
                Arguments.of(buildTree(new Integer[]{3,9,20,null,null,15,7}), "hud")
        );
    }

}