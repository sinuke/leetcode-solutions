package com.sinuke.easy;

public class NumberOfSeniorCitizens {

    public int countSeniors(String[] details) {
        int count = 0;

        for (var detail : details) {
            int age = (detail.charAt(11) - '0') * 10 + (detail.charAt(12) - '0');
            if (age > 60) count++;
        }

        return count;
    }

}
