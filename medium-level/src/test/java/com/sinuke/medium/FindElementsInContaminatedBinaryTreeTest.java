package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindElementsInContaminatedBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findElementsTest(String[] operations, Integer[][] values, Boolean[] expected) {
        FindElementsInContaminatedBinaryTree.FindElements solution = null;
        Boolean[] actual = new Boolean[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "FindElements": {
                    solution = new FindElementsInContaminatedBinaryTree.FindElements(buildTree(values[i]));
                    actual[i] = null;
                    break;
                }

                case "find": {
                    actual[i] = solution.find(values[i][0]);
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
                        new String[] {"FindElements", "find", "find"},
                        new Integer[][] {{-1, null, -1}, {1}, {2}},
                        new Boolean[] {null, false, true}
                ),
                Arguments.of(
                        new String[] {"FindElements","find","find","find"},
                        new Integer[][] {{-1,-1,-1,-1,-1}, {1}, {3}, {5}},
                        new Boolean[] {null, true, true, false}
                ),
                Arguments.of(
                        new String[] {"FindElements","find","find","find","find"},
                        new Integer[][] {{-1,null,-1,-1,null,-1}, {2}, {3}, {4}, {5}},
                        new Boolean[] {null,true,false,false,true}
                )
        );
    }

    public static FindElementsInContaminatedBinaryTree.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        return buildTree(array, 0);
    }

    private static FindElementsInContaminatedBinaryTree.TreeNode buildTree(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) return null;

        var node = new FindElementsInContaminatedBinaryTree.TreeNode(array[index]);
        node.left = buildTree(array, 2 * index + 1);
        node.right = buildTree(array, 2 * index + 2);

        return node;
    }

}
