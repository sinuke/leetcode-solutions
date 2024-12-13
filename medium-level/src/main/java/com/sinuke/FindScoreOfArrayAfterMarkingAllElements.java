package com.sinuke;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindScoreOfArrayAfterMarkingAllElements {

    public long findScore(int[] nums) {
        Comparator<Node> comparator = Comparator.comparing(node -> node.val);
        comparator = comparator.thenComparing(node -> node.index);
        
        var pq = new PriorityQueue<>(comparator);
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Node(nums[i], i));
        }

        long score = 0;

        while (!pq.isEmpty()) {
            var node = pq.poll();
            if (nums[node.index] == 0) {
                continue;
            }
            
            score += node.val;
            if (node.index > 0 && nums[node.index - 1] != 0) nums[node.index - 1] = 0;
            if (node.index < nums.length - 1 && nums[node.index + 1] != 0) nums[node.index + 1] = 0;
        }

        return score;
    }
    
    public long findScoreFromLeetCode(int[] nums) {
        int[][] matrix = new int[nums.length][2];
        int[] marked = new int[nums.length];
        long score = 0;

        for (int i = 0; i < nums.length; i++) {
            matrix[i][0] = nums[i];
            matrix[i][1] = i;
        }

        Arrays.sort(matrix, Comparator.comparingInt(a -> a[0]));

        for (int[] node : matrix) {
            int value = node[0];
            int index = node[1];

            if (marked[index] == 0) {
                score += value;
                marked[index] = 1;

                if (index > 0) marked[index - 1] = 1;
                if (index < nums.length - 1) marked[index + 1] = 1;
            }
        }
        
        return score;
    }
    
    private static class Node {
        int val;
        int index;
        
        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
}
