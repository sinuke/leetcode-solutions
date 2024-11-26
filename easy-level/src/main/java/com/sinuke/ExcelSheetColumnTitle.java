package com.sinuke;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        var result = new StringBuilder();
        
        while (columnNumber > 0) {
            int n = (columnNumber) % 26;
            result.append(getChat(n));
            columnNumber = (columnNumber - 1) / 26;
        }
        
        return result.reverse().toString();
    }
    
    private char getChat(int n) {
        if (n == 0) return 'Z';
        return (char) ('A' + n - 1);
    }
    
}