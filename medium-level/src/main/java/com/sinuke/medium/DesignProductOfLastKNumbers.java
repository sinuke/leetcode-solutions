package com.sinuke.medium;

public class DesignProductOfLastKNumbers {

    public static class ProductOfNumbers {

        private final int[] p;
        private int lzero;
        private int i;

        public ProductOfNumbers() {
            p = new int[40001];
            i = -1;
            lzero = -1;
        }

        public void add(int num) {
            i++;
            int n = num;
            if (n == 0) {
                lzero = Math.max(lzero, i);
                n = 1;
            }

            if (i == 0) p[i] = n;
            else p[i] = (num == 0) ? n : p[i - 1] * n;
        }

        public int getProduct(int k) {
            int m = 1;
            if ((lzero != -1) && ((i + 1 == k && i < lzero) || (i - k < lzero))) m = 0;

            if (i + 1 == k) return p[i] * m;
            else {
                int d = p[i - k];
                return (p[i] / d) * m;
            }
        }
    }

}
