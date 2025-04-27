package com.sinuke.easy;

public class SumOfAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0, length = 1;
        while (length <= arr.length) {
            for (int i = 0; i < arr.length - length + 1; i++) {
                int sum = 0;
                for (int j = i; j < i + length; j++) {
                    sum += arr[j];
                }
                result += sum;
            }
            length += 2;
        }

        return result;
    }

}
