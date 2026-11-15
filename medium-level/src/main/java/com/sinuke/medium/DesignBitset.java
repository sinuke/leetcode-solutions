package com.sinuke.medium;

public class DesignBitset {

    public static class Bitset {

        private final byte[] bits;
        private boolean flipped;
        private int zeroes = 0;

        public Bitset(int size) {
            this.bits = new byte[size];
            this.flipped = false;
            this.zeroes = size;
        }

        public void fix(int idx) {
            if ((bits[idx] == 0 && !flipped) || (bits[idx] == 1 && flipped)) zeroes -= 1;
            bits[idx] = (byte) (flipped ? 0 : 1);
        }

        public void unfix(int idx) {
            if ((bits[idx] == 1 && !flipped) || (bits[idx] == 0 && flipped)) zeroes++;
            bits[idx] = (byte) (flipped ? 1 : 0);
        }

        public void flip() {
            flipped = !flipped;
            zeroes = bits.length - zeroes;
        }

        public boolean all() {
            return zeroes == 0;
        }

        public boolean one() {
            return zeroes != bits.length;
        }

        public int count() {
            return bits.length - zeroes;
        }

        public String toString() {
            var sb = new StringBuilder();
            for (byte bit : bits) sb.append(flipped ? bit ^ 1 : bit);
            return sb.toString();
        }

    }

}
