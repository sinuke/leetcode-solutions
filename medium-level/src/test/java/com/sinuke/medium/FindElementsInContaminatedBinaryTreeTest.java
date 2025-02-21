package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindElementsInContaminatedBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findElementsTest(String[] operations, Object[][] values, Object[] expected) {
        FindElementsInContaminatedBinaryTree.FindElements solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "FindElements": {
                    solution = new FindElementsInContaminatedBinaryTree.FindElements(createRoot(values[i]));
                    actual[i] = null;
                    break;
                }

                case "find": {
                    actual[i] = solution.find((int) values[i][0]);
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
                        new Object[][] {{-1, null, -1}, {1}, {2}},
                        new Object[] {null, false, true}
                ),
                Arguments.of(
                        new String[] {"FindElements","find","find","find"},
                        new Object[][] {{-1,-1,-1,-1,-1}, {1}, {3}, {5}},
                        new Object[] {null, true, true, false}
                ),
                Arguments.of(
                        new String[] {"FindElements","find","find","find","find"},
                        new Object[][] {{-1,null,-1,-1,null,-1}, {2}, {3}, {4}, {5}},
                        new Object[] {null,true,false,false,true}
                )
        );
    }

    private FindElementsInContaminatedBinaryTree.TreeNode createRoot(Object[] values) {
        var root = createTreeNode(values, 0);
        createTree(root, values, 1);
        return root;
    }

    private void createTree(FindElementsInContaminatedBinaryTree.TreeNode parent, Object[] values, int i) {
        if (i >= values.length || parent == null) return;

        parent.left = createTreeNode(values, i);
        parent.right = createTreeNode(values, i + 1);

        createTree(parent.left, values, i + 2);
        createTree(parent.right, values, i + 4);
    }

    private FindElementsInContaminatedBinaryTree.TreeNode createTreeNode(Object[] values, int i) {
        if (i < values.length && values[i] != null) return new FindElementsInContaminatedBinaryTree.TreeNode((int) values[i]);
        return null;
    }

}
