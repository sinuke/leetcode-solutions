package com.sinuke.hard;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SerializeAndDeserializeBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void serializeAndDeserializeBST(TreeNode root, TreeNode expected) {
        var ser = new SerializeAndDeserializeBinaryTree.Codec();
        var deser = new SerializeAndDeserializeBinaryTree.Codec();

        var encoded = ser.serialize(root);

        assertArrayEquals(toArray(expected), toArray(deser.deserialize(encoded)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,2,3,null,null,4,5}), buildTree(new Integer[]{1,2,3,null,null,4,5})),
                Arguments.of(buildTree(new Integer[]{1,2,3,null,null,4,5,6,7}), buildTree(new Integer[]{1,2,3,null,null,4,5,6,7})),
                Arguments.of(buildTree(new Integer[]{}), buildTree(new Integer[]{})),
                Arguments.of(buildTree(new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2}), buildTree(new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2}))
        );
    }

}
