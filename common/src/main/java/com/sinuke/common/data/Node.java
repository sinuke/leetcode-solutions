package com.sinuke.common.data;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public static Node buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        Deque<Node> queue = new LinkedList<>();
        var root = new Node(array[0], new ArrayList<>());
        queue.add(root);

        for (int i = 1; i < array.length; i++) {
            if (array[i] != null)  {
                var node = new Node(array[i], new ArrayList<>());
                if (!queue.isEmpty()) queue.peekFirst().children.add(node);
                queue.offer(node);

                if (i + 1 < array.length && array[i + 1] == null) queue.pollFirst();
            } else if (i + 1 < array.length && array[i + 1] == null) queue.pollFirst();
        }

        return root;
    }

}
