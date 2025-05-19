package com.sinuke.easy;

public class TypeOfTriangle {

    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];

        if (isTriangle(a, b, c)) {
            if (a == b && a == c) return "equilateral";
            else if (a == b || a == c || b == c) return "isosceles";
            else return "scalene";
        }

        return "none";
    }

    private boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

}
