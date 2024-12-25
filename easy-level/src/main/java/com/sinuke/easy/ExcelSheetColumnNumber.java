package com.sinuke.easy;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length() - 1; i++) {
            result = (result + columnTitle.charAt(i) - 64) * 26;
        }
        result += columnTitle.charAt(columnTitle.length() - 1) - 64;

        return result;
    }

}
