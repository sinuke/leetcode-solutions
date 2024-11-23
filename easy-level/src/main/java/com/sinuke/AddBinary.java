package com.sinuke;

public class AddBinary {

    public String addBinary(String a, String b) {
        char[] result = new char[Math.max(a.length(), b.length()) + 1];
        int resultIndex = result.length - 1;
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int buff = 0;
        int aInt;
        int bInt;

        while (aIndex >= 0 || bIndex >= 0) {
            aInt = aIndex >= 0 ? a.charAt(aIndex) - '0' : 0;
            bInt = bIndex >= 0 ? b.charAt(bIndex) - '0' : 0;

            int sum = aInt + bInt + buff;
            if (sum == 2) {
                sum = 0;
                buff = 1;
            } else if (sum == 3) {
                sum = 1;
                buff = 1;
            } else buff = 0;

            result[resultIndex] = (char) (sum + '0');

            aIndex--;
            bIndex--;
            resultIndex--;
        }

        if (buff == 1) result[resultIndex] = '1';

        return String.valueOf(result, buff == 1 ? 0 : 1, buff == 1 ? result.length - resultIndex : result.length - resultIndex - 1);
    }

}
