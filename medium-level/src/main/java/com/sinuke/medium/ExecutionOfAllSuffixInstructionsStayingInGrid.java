package com.sinuke.medium;

public class ExecutionOfAllSuffixInstructionsStayingInGrid {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] result = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            int[] pos = startPos.clone();

            for (int j = i; j < s.length(); j++) {
                if (move(n, pos, s.charAt(j))) count++;
                else break;
            }

            result[i] = count;
        }
        return result;
    }

    private boolean move(int n, int[] pos, char action) {
        if (action == 'U' && pos[0] > 0) {
            pos[0]--;
            return true;
        } else if (action == 'R' && pos[1] < n - 1) {
            pos[1]++;
            return true;
        } else if (action == 'D' && pos[0] < n - 1) {
            pos[0]++;
            return true;
        } else if (action == 'L' && pos[1] > 0) {
            pos[1]--;
            return true;
        }

        return false;
    }

}
