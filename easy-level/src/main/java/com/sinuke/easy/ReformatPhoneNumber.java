package com.sinuke.easy;

public class ReformatPhoneNumber {

    public String reformatNumber(String number) {
        var numbers = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) numbers.append(c);
        }

        var sb = new StringBuilder();
        int start = 0, end = numbers.length() <= 4 ? 2 : 3;
        while (end <= numbers.length()) {
            sb.append(numbers, start, end).append("-");
            start = end;
            if (numbers.length() - start <= 4) {
                if (start + 3 == numbers.length()) end = start + 3;
                else end = start + 2;
            } else end = start + 3;
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}
