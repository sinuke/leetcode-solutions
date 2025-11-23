package com.sinuke.easy;

public class CheckIfAllAsAppearsBeforeAllBs {

    public boolean checkString(String s) {
        boolean isB = false;
        for (char c : s.toCharArray()) {
            if (c == 'b') isB = true;
            else if (c == 'a' && isB) return false;
        }
        return true;
    }

}
