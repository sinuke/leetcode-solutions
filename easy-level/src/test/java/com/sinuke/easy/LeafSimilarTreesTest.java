package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LeafSimilarTreesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void leafSimilar(TreeNode root1, TreeNode root2, boolean expected) {
        var solution = new LeafSimilarTrees();
        assertEquals(expected, solution.leafSimilar(root1, root2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{3,5,1,6,2,9,8,null,null,7,4}), buildTree(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8}), true),
                Arguments.of(buildTree(new Integer[]{1,2,3}), buildTree(new Integer[]{1,3,2}), false)
        );
    }

}
