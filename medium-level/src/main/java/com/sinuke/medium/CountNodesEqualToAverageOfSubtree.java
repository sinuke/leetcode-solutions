package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;

public class CountNodesEqualToAverageOfSubtree {

    // 15.09.2025 - 1 ms

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

    // 10.09.2026 - 1 ms
    public int averageOfSubtree2(TreeNode root) {
        var result = new SingleValue();
        walk(root, result);
        return result.val;
    }

    private Tuple2 walk(TreeNode node, SingleValue result) {
        if (node == null) return new Tuple2(0, 0);

        var left = walk(node.left, result);
        var right = walk(node.right, result);

        var res = new Tuple2(node.val + left.a + right.a, left.b + right.b + 1);
        if (node.val == res.a / res.b) result.val++;

        return res;
    }

    private static class SingleValue {
        int val;
    }

    private record Tuple2(int a, int b) {}

}
