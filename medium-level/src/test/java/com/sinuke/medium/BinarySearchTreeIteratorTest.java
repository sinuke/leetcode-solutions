package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BinarySearchTreeIteratorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void BinarySearchTreeIteratorTest(String[] operations, TreeNode root, Object[] expected) {
        BinarySearchTreeIterator.BSTIterator solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "BSTIterator": {
                    solution = new BinarySearchTreeIterator.BSTIterator(root);
                    actual[i] = null;
                    break;
                }

                case "hasNext": {
                    actual[i] = solution.hasNext();
                    break;
                }

                case "next": {
                    actual[i] = solution.next();
                    break;
                }

                default: throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"},
                        buildTree(new Integer[] {7, 3, 15, null, null, 9, 20}),
                        new Object[] {null, 3, 7, true, 9, true, 15, true, 20, false}
                )
        );
    }

}