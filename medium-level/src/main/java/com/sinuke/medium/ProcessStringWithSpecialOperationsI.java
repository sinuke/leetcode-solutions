package com.sinuke.medium;

public class ProcessStringWithSpecialOperationsI {

    public String processStr(String s) {
        var sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!sb.isEmpty()) sb.setLength(sb.length() - 1);
            } else if (c == '#') sb.append(sb);
            else if (c == '%') sb.reverse();
            else sb.append(c);
        }
        return sb.toString();
    }

}
