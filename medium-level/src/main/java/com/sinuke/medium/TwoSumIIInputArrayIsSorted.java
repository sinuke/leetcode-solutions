package com.sinuke.medium;

class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int j = find(numbers, i, numbers.length - 1, target, numbers[i]);
            if (j != -1) return new int[] {i + 1, j + 1};
        }
        return new int[] {-1, -1};
    }

    private int find(int[] numbers, int left, int right, int target, int first) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (first + numbers[right] == target) return right;

            if (first + numbers[mid] == target) return mid;
            else if (first + numbers[mid] > target) right = mid;
            else left = mid + 1;
        }

        return -1;
    }

}
