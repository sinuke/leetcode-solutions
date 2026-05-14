package com.sinuke.easy;

public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0, ic = 0, jc = 0;
        char ip = name.charAt(i);
        while (i < name.length() || j < typed.length()) {
            if (i < name.length() && name.charAt(i) == ip) {
                ic++;
                i++;
            } else if (j < typed.length() && typed.charAt(j) == ip) {
                jc++;
                j++;
            } else if (jc > 0 && ic > 0 && jc >= ic) {
                ic = 0;
                jc = 0;
                ip = i < name.length() ? name.charAt(i) : ip;
            } else return false;
        }
        return name.charAt(name.length() - 1) == typed.charAt(typed.length() - 1) && jc >= ic;
    }

}
