package com.sinuke.easy;

class CheckIfStringsCanBeMadeEqualWithOperationsI {

    public boolean canBeEqual(String s1, String s2) {
        return check(s1, s2) ? true : check(s2, s1);
    }

    private boolean check(String s1, String s2) {
        if (s1.equals(s2)) return true;
        else {
            char[] c1 = s1.toCharArray();
            char c = c1[0];
            c1[0] = c1[2];
            c1[2] = c;

            if (String.valueOf(c1).equals(s2)) return true;

            c = c1[1];
            c1[1] = c1[3];
            c1[3] = c;

            if (String.valueOf(c1).equals(s2)) return true;

            c = c1[0];
            c1[0] = c1[2];
            c1[2] = c;

            if (String.valueOf(c1).equals(s2)) return true;

            return false;
        }
    }

}
