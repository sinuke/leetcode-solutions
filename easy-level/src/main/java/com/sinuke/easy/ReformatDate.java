package com.sinuke.easy;

import java.util.Map;

public class ReformatDate {

    private final Map<String, String> months = Map.ofEntries(
            Map.entry("Jan", "01"),
            Map.entry("Feb", "02"),
            Map.entry("Mar", "03"),
            Map.entry("Apr", "04"),
            Map.entry("May", "05"),
            Map.entry("Jun", "06"),
            Map.entry("Jul", "07"),
            Map.entry("Aug", "08"),
            Map.entry("Sep", "09"),
            Map.entry("Oct", "10"),
            Map.entry("Nov", "11"),
            Map.entry("Dec", "12")
    );

    public String reformatDate(String date) {
        int i = date.charAt(4) == ' ' ? 4 : 3;
        var sb = new StringBuilder(date.substring(i + 5)).append("-");
        sb.append(months.get(date.substring(i + 1, i + 4))).append("-");
        sb.append(i - 2 == 1 ? "0" : "").append(date, 0, i - 2);
        return sb.toString();
    }

}
