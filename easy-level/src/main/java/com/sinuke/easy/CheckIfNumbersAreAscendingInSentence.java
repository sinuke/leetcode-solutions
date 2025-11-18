package com.sinuke.easy;

public class CheckIfNumbersAreAscendingInSentence {

    public boolean areNumbersAscending(String s) {
        int[] nums = new int[200];
        int j = 0;
        var sb = new StringBuilder(3);
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (!sb.isEmpty()) {
                    nums[j] = Integer.parseInt(sb.toString());
                    if (j > 0 && nums[j] <= nums[j - 1]) return false;
                    j++;
                }
                sb.setLength(0);
            } else if (Character.isDigit(c)) sb.append(c);
        }

        return sb.isEmpty() || Integer.parseInt(sb.toString()) > nums[j - 1];
    }

    public boolean areNumbersAscending2(String s) {
         String[] tokens = s.split(" ");
         int[] nums = new int[tokens.length];
         int i = 0;
         for (String token : tokens) {
             if (Character.isDigit(token.charAt(0))) {
                 nums[i] = Integer.parseInt(token);
                 if (i > 0 && nums[i] <= nums[i - 1]) return false;
                 i++;
             }
         }
         return true;
    }

}
