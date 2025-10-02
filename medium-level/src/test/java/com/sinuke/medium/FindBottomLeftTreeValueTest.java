package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindBottomLeftTreeValueTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findBottomLeftValue(TreeNode root, int expected) {
        var solution = new FindBottomLeftTreeValue();
        assertEquals(expected, solution.findBottomLeftValue(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {2,1,3}), 1),
                Arguments.of(buildTree(new Integer[] {1,2,3,4,null,5,6,null,null,7}), 7)
        );
    }

}
