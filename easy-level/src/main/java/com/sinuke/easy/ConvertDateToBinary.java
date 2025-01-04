package com.sinuke.easy;

public class ConvertDateToBinary {

    public String convertDateToBinary(String date) {
        var dates = date.split("-");

        for (int i = 0; i < dates.length; i++) {
            dates[i] = Integer.toBinaryString(Integer.parseInt(dates[i]));
        }

        return String.join("-", dates);
    }

}
