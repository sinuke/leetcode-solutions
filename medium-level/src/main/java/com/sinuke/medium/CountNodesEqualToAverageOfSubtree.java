package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

public class CountNodesEqualToAverageOfSubtree {

    public int averageOfSubtree(TreeNode root) {
        var result = new Value();
        walk(root, result);
        return result.val;
    }

    private Average walk(TreeNode node, Value result) {
        var average = new Average();
        if (node == null) return average;

        average.add(walk(node.left, result));
        average.add(walk(node.right, result));

        average.sum += node.val;
        average.count++;

        if (node.val == average.average()) result.val++;

        return average;
    }

    private static class Average {
        int sum;
        int count;

        int average() {
            return sum / count;
        };

        void add(Average other) {
            sum += other.sum;
            count += other.count;
        }
    }

    private static class Value {
        int val;
    }

}
