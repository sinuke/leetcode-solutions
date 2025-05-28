package com.sinuke.easy;

public class FindTheKeyOfTheNumbers {

    public int generateKey(int num1, int num2, int num3) {
        int result = 0;

        for (int i = 4; i > 0; i--) {
            int d1 = num1 % 10, d2 = num2 % 10, d3 = num3 % 10, d = (int) Math.pow(10, 4 - i);

            if (d1 <= d2 && d1 <= d3) result += d * d1;
            else if (d2 <= d1 && d2 <= d3) result += d * d2;
            else result += d * d3;

            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }

        return result;
    }

}
