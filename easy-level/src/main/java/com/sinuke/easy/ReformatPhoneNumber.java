package com.sinuke.easy;

public class ReformatPhoneNumber {

    public String reformatNumber(String number) {
        number = number.replaceAll("[ \\-]", "");
        var sb = new StringBuilder();
        int start = 0, end = number.length() <= 4 ? 2 : 3;
        while (end <= number.length()) {
            sb.append(number, start, end).append("-");
            start = end;
            if (number.length() - start <= 4) {
                if (start + 3 == number.length()) end = start + 3;
                else end = start + 2;
            } else end = start + 3;
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}
