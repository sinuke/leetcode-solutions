package com.sinuke.medium;

public class DesignSpreadsheet {

    public static class Spreadsheet {

        private final int[][] ss;

        public Spreadsheet(int rows) {
            ss = new int[rows][26];
        }

        public void setCell(String cell, int value) {
            int c = cell.charAt(0) - 'A';
            int r = Integer.parseInt(cell.substring(1)) - 1;
            ss[r][c] = value;
        }

        public void resetCell(String cell) {
            setCell(cell, 0);
        }

        public int getValue(String formula) {
            int p = formula.indexOf("+");
            int sum = 0;

            if (Character.isLetter(formula.charAt(1))) {
                int c = formula.charAt(1) - 'A';
                int r = Integer.parseInt(formula.substring(2, p)) - 1;
                sum += ss[r][c];
            } else sum += Integer.parseInt(formula.substring(1, p));

            if (Character.isLetter(formula.charAt(p + 1))) {
                int c = formula.charAt(p + 1) - 'A';
                int r = Integer.parseInt(formula.substring(p + 2)) - 1;
                sum += ss[r][c];
            } else sum += Integer.parseInt(formula.substring(p + 1));

            return sum;
        }
    }

}
