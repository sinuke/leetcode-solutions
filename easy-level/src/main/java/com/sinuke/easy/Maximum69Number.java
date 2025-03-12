package com.sinuke.easy;

public class Maximum69Number {

    public int maximum69Number (int num) {
        var str = String.valueOf(num).replaceFirst("6", "9");
        return Integer.parseInt(str);
    }

}
