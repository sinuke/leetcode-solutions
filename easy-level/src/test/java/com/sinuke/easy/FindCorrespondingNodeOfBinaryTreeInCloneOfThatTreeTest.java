package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertSame;

class FindCorrespondingNodeOfBinaryTreeInCloneOfThatTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target, final TreeNode expected) {
        var solution = new FindCorrespondingNodeOfBinaryTreeInCloneOfThatTree();
        assertSame(expected, solution.getTargetCopy(original, cloned, target));
    }

    private static Stream<Arguments> testData() {
        // test case #1
        var t1on6 = new TreeNode(6);
        var t1on19 = new TreeNode(19);
        var t1on3 = new TreeNode(3, t1on6, t1on19);
        var t1on4 = new TreeNode(4);
        var t1on7 = new TreeNode(7, t1on4, t1on3);

        var t1cn6 = new TreeNode(6);
        var t1cn19 = new TreeNode(19);
        var t1cn3 = new TreeNode(3, t1cn6, t1cn19);
        var t1cn4 = new TreeNode(4);
        var t1cn7 = new TreeNode(7, t1cn4, t1cn3);

        // test case #2
        var t2on7 = new TreeNode(7);
        var t2cn7 = new TreeNode(7);

        // test case #3
        var t3on1 = new TreeNode(1);
        var t3on2 = new TreeNode(2, null, t3on1);
        var t3on3 = new TreeNode(3, null, t3on2);
        var t3on4 = new TreeNode(4, null, t3on3);
        var t3on5 = new TreeNode(5, null, t3on4);
        var t3on6 = new TreeNode(6, null, t3on5);
        var t3on8 = new TreeNode(8, null, t3on6);

        var t3cn1 = new TreeNode(1);
        var t3cn2 = new TreeNode(2, null, t3cn1);
        var t3cn3 = new TreeNode(3, null, t3cn2);
        var t3cn4 = new TreeNode(4, null, t3cn3);
        var t3cn5 = new TreeNode(5, null, t3cn4);
        var t3cn6 = new TreeNode(6, null, t3cn5);
        var t3cn8 = new TreeNode(8, null, t3cn6);

        return Stream.of(
                Arguments.of(t1on7, t1cn7, t1on3, t1cn3),
                Arguments.of(t2on7, t2cn7, t2on7, t2cn7),
                Arguments.of(t3on8, t3cn8, t3on4, t3cn4)
        );
    }
}
