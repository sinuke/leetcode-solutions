package com.sinuke.medium;

public class SubrectangleQueriesSolution {

    public static class SubrectangleQueries {

        private final int[][] rectangle;

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int r = row1; r <= row2; r++) {
                for (int c = col1; c <= col2; c++) rectangle[r][c] = newValue;
            }
        }

        public int getValue(int row, int col) {
            return rectangle[row][col];
        }
    }

}
