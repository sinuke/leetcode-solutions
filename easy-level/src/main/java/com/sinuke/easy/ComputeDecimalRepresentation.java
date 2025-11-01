package com.sinuke.easy;

import java.util.Stack;

public class ComputeDecimalRepresentation {

    public int[] decimalRepresentation(int n) {
        Stack<Integer> stack = new Stack<>();
        int k = 1;
        while (n > 0) {
            int d = n % 10;
            if (d != 0) stack.push(d * k);
            n /= 10;
            k *= 10;
        }

        k = 0;
        int[] result = new int[stack.size()];
        while (!stack.isEmpty()) result[k++] = stack.pop();

        return result;
    }

}
