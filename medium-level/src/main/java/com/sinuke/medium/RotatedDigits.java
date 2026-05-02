package com.sinuke.medium;

public class RotatedDigits {

    // 4 ms
    public int rotatedDigits(int n) {
        int count = 0;
        byte[] dp = new byte[n + 1];

        for (int num = 1; num <= n; num++) {
            int d = num % 10;
            int nn = num / 10;

            if (nn == 0) {
                if (d == 1 || d == 8) dp[d] = 1;
                else if (d == 2 || d == 5 || d == 6 || d == 9) {
                    dp[d] = 2;
                    count++;
                }
            } else {
                if (dp[nn] == 2 && (d == 0 || d == 1 || d == 2 || d == 5 || d == 6 || d == 8 || d == 9)) {
                    dp[num] = 2;
                    count++;
                } else if (dp[nn] == 1 && (d == 2 || d == 5 || d == 6 || d == 9)) {
                    dp[num] = 2;
                    count++;
                } else if (dp[nn] == 1 && (d == 0 || d == 1 || d == 8)) dp[num] = 1;
            }
        }

        return count;
    }

    // 12 ms
    public int rotatedDigits2(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            char[] num = String.valueOf(i).toCharArray();
            boolean isGood = true;
            for (int j = 0; j < num.length && isGood; j++) {
                if (num[j] == '3' || num[j] == '4' || num[j] == '7') isGood = false;
                else if (num[j] == '2') num[j] = '5';
                else if (num[j] == '5') num[j] = '2';
                else if (num[j] == '6') num[j] = '9';
                else if (num[j] == '9') num[j] = '6';
            }
            if (isGood && !String.valueOf(i).equals(new String(num))) count++;
        }
        return count;
    }

}
