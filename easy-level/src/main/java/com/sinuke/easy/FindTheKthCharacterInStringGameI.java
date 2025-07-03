package com.sinuke.easy;

public class FindTheKthCharacterInStringGameI {

    public char kthCharacter(int k) {
        var sb = new StringBuilder("a");
        while (sb.length() < k) {
            var tmp = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                tmp.append(sb.charAt(i) == 'z' ? 'a' : (char) (sb.charAt(i) + 1));
            }
            sb.append(tmp);
        }
        return sb.charAt(k - 1);
    }

}
