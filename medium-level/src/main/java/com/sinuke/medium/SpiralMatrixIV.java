package com.sinuke.medium;

import com.sinuke.common.data.ListNode;

public class SpiralMatrixIV {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int c = 0, r = 0, cd = 0, rd = 0, count = 0;
        int[][] mat = new int[m][n];
        while (count < m * n) {
            mat[r][c] = head == null ? -1 : head.val;
            head = head == null ? null : head.next;
            count++;

            if (r == rd && c < n - cd - 1) c++;
            else if (c == n - cd - 1 && r < m - rd - 1) r++;
            else if (c > cd && r == m - rd - 1 && r > rd) c--;
            else if (c == cd && r > rd) {
                r--;
                if (r == rd) {
                    rd++;
                    cd++;
                    c = cd;
                    r = rd;
                }
            }
        }
        return mat;
    }

}
