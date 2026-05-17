package com.sinuke.medium;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        Value answer = new Value();
        answer.val = false;
        walk(arr, start, answer);
        return answer.val;
    }

    private void walk(int[] arr, int i, Value answer) {
        if (i < 0 || i >= arr.length || arr[i] < 0) return;

        if (arr[i] == 0) {
            answer.val = true;
            return;
        }

        int n = arr[i];
        arr[i] = -1;

        walk(arr, i + n, answer);
        walk(arr, i - n, answer);
    }

    private static class Value {
        boolean val;
    }

}
