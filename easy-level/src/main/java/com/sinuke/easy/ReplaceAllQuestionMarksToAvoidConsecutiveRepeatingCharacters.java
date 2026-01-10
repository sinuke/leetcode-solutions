package com.sinuke.easy;

public class ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters {

    public String modifyString(String s) {
        var sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '?') {
                for (int j = 0; j < 26; j++) {
                    char nc = (char) (j + 'a');
                    if (i > 0 && i < s.length() - 1) {
                        if (nc != sb.charAt(i - 1) && nc != s.charAt(i + 1)) {
                            sb.append(nc);
                            break;
                        }
                    } else if (i == 0 && i < s.length() - 1) {
                        if (nc != s.charAt(i + 1)) {
                            sb.append(nc);
                            break;
                        }
                    } else if (i > 0 && i == s.length() - 1) {
                        if (nc != sb.charAt(i - 1)) {
                            sb.append(nc);
                            break;
                        }
                    } else if (i == 0 && i == s.length() - 1) {
                        sb.append(nc);
                        break;
                    }
                }
            } else sb.append(c);
        }
        return sb.toString();
    }

}
