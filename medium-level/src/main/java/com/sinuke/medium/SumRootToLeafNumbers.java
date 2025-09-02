package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        Num sum = new Num(0);
        getNumber(root, new Num(0), sum);
        return sum.num;
    }

    private void getNumber(TreeNode node, Num num, Num sum) {
        if (node == null) return;
        num.num = num.num * 10 + node.val;

        if (node.left == null && node.right == null) sum.num += num.num;
        else {
            getNumber(node.left, new Num(num.num), sum);
            getNumber(node.right, new Num(num.num), sum);
        }
    }

    private static class Num {
        int num;

        Num(int num) {
            this.num = num;
        }
    }

}
