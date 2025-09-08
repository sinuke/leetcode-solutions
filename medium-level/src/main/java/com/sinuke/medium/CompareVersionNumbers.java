package com.sinuke.medium;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        int v1left = 0, v2left = 0, i1 = 0, i2 = 0, v1 = 0, v2 = 0;

        while (i1 < version1.length() || i2 < version2.length()) {

            if (i1 < version1.length()) {
                v1left = i1;
                while (i1 < version1.length() && version1.charAt(i1) != '.') i1++;
                v1 = Integer.parseInt(version1.substring(v1left, i1++));
            } else v1 = 0;

            if (i2 < version2.length()) {
                v2left = i2;
                while (i2 < version2.length() && version2.charAt(i2) != '.') i2++;
                v2 = Integer.parseInt(version2.substring(v2left, i2++));
            } else v2 = 0;

            if (v1 > v2) return 1;
            else if (v2 > v1) return -1;
        }

        return 0;
    }

}
