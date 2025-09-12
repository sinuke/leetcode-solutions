package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;

public class FindCorrespondingNodeOfBinaryTreeInCloneOfThatTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        var answer = new Result();
        walk(original, cloned, target, answer);
        return answer.answer;
    }

    private void walk(TreeNode originalNode, TreeNode clonedNode, TreeNode target, Result answer) {
        if (originalNode == null || clonedNode == null || answer.answer != null) return;

        if (originalNode == target) {
            answer.answer = clonedNode;
            return;
        }

        walk(originalNode.left, clonedNode.left, target, answer);
        walk(originalNode.right, clonedNode.right, target, answer);
    }

    private static class Result {
        TreeNode answer;
    }

}
