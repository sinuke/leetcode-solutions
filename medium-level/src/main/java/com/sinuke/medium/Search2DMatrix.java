package com.sinuke.medium;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int i = mid / n, j = mid % n;
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) end = mid - 1;
            else start = mid + 1;
        }

        return false;
    }

}
