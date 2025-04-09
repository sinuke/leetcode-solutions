package com.sinuke.easy;

public class BaseballGame {

    public int calPoints(String[] operations) {
        int[] nums = new int[operations.length];

        int index = 0;
        for (String operation : operations) {
            switch (operation) {
                case "C" -> {
                    nums[index--] = 0;
                }
                case "D" -> {
                    nums[index] = 2 * nums[index - 1];
                    index++;
                }
                case "+" -> {
                    nums[index] = nums[index - 2] + nums[index - 1];
                    index++;
                }
                case null, default -> nums[index++] = Integer.parseInt(operation);
            }
        }

        int sum = 0;
        for (int i = 0; i < index; i++) sum += nums[i];
        return sum;
    }

}
