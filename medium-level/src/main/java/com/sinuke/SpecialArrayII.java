package com.sinuke;

public class SpecialArrayII {

    /*
        It is not good solution:
        - 2500 ms
        - 5.39%
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[][] specials = new int[nums.length][2];

        boolean lastSpecial = false;
        int start = 0;
        int spectialsLastPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean special = isSpecial(nums[i], nums[i + 1]);
            if (special && !lastSpecial) {
                start = i;
            } else if (!special && lastSpecial) {
                specials[spectialsLastPos][0] = start;
                specials[spectialsLastPos][1] = i;
                spectialsLastPos++;
            }
            lastSpecial = special;
        }

        if (lastSpecial) {
            specials[spectialsLastPos][0] = start;
            specials[spectialsLastPos][1] = nums.length - 1;
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            boolean temp = queries[i][0] == queries[i][1];
            int j = 0;
            while (j <= spectialsLastPos && !temp) {
                int[] special = specials[j];
                if (queries[i][0] >= special[0] && queries[i][1] <= special[1]) temp = true;
                j++;
            }
            result[i] = temp;
        }

        return result;
    }

    /*
        Solution from LeetCode
     */
    public boolean[] isArraySpecialFromLeetCode(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n]; // Prefix array to count special pairs
        boolean[] result = new boolean[queries.length]; // Result array

        // Step 1: Build the prefix array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            if (!isSpecial(nums[i - 1], nums[i])) prefix[i]++;
        }

        // Step 2: Process each query
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // Calculate the number of special pairs in the range
            int specialCount = prefix[right] - (left > 0 ? prefix[left] : 0);

            // If no special pairs, the result is true; otherwise, false
            result[i] = (specialCount == 0);
        }

        return result;
    }

    private boolean isSpecial(int num1, int num2) {
        return (num1 % 2 == 0 && num2 % 2 != 0) || (num1 % 2 != 0 && num2 % 2 == 0);
    }

}
