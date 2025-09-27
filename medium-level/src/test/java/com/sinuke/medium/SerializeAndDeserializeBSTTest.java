package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SerializeAndDeserializeBSTTest {

    @ParameterizedTest
    @MethodSource("testData")
    void serializeAndDeserializeBST(TreeNode root, TreeNode expected) {
        var ser = new SerializeAndDeserializeBST.Codec();
        var deser = new SerializeAndDeserializeBST.Codec();

        var encoded = ser.serialize(root);

        assertArrayEquals(toArray(expected), toArray(deser.deserialize(encoded)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{2,1,3}), buildTree(new Integer[]{2,1,3})),
                Arguments.of(buildTree(new Integer[]{}), buildTree(new Integer[]{})),
                Arguments.of(buildTree(new Integer[]{1,null,2}), buildTree(new Integer[]{1,null,2})),
                Arguments.of(buildTree(new Integer[]{5,3,6,2,4,null,null,1}), buildTree(new Integer[]{5,3,6,2,4,null,null,1}))
        );
    }

}
