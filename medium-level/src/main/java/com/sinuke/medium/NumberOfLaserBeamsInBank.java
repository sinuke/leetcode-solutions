package com.sinuke.medium;

public class NumberOfLaserBeamsInBank {

    public int numberOfBeams(String[] bank) {
        int result = 0, prev = 0;
        for (String row : bank) {
            int count = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') count++;
            }
            if (count > 0) {
                result += prev * count;
                prev = count;
            }
        }

        return result;
    }

}
