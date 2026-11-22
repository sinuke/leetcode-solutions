package com.sinuke.medium;

public class DesignFindConsecutiveIntegersFromDataStream {

    public static class DataStream {

        private final int v;
        private final int k;
        private int last;
        private int count;

        public DataStream(int value, int k) {
            this.v = value;
            this.k = k;
            this.count = 0;
            this.last = -1;
        }

        public boolean consec(int num) {
            boolean res = false;

            if (count < k) count++;

            if (num != v) last = 0;
            else if (last != -1) last++;

            if (count == k && (last == -1 || last == k)) {
                res = true;
                last = -1;
            }

            return res;
        }
    }

}
