package com.sinuke.easy;

public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') y--;
            else if (moves.charAt(i) == 'D') y++;
            else if (moves.charAt(i) == 'L') x--;
            else if (moves.charAt(i) == 'R') x++;
        }

        return x == 0 && y == 0;
    }

    // from LeetCode
    public boolean judgeCircle2(String moves) {
        int []check = new int[128];

        for (char c : moves.toCharArray()) {
            check[c]++;
        }

        return check['R'] == check['L'] && check['U'] == check['D'];
    }

}
