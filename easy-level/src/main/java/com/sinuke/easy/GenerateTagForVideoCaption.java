package com.sinuke.easy;

public class GenerateTagForVideoCaption {

    // 2 ms
    public String generateTag(String caption) {
        var sb = new StringBuilder("#");
        boolean up = false;
        int i = 0;

        while (i < caption.length()) {
            char c = caption.charAt(i);
            if (c == ' ') up = sb.charAt(sb.length() - 1) != '#';
            else {
                sb.append(up ? Character.toUpperCase(c) : Character.toLowerCase(c));
                up = false;
            }
            i++;
        }

        String result = sb.toString();
        return result.length() > 100 ? result.substring(0, 100) : result;
    }

    // 5 ms
    public String generateTag2(String caption) {
        var sb = new StringBuilder("#");

        var words = caption.split(" ");
        for (var word : words) {
            word = word.trim();
            if (!word.isEmpty()) {
                if (sb.charAt(sb.length() - 1) == '#') sb.append(word.toLowerCase());
                else {
                    char[] w = word.toLowerCase().toCharArray();
                    w[0] = Character.toUpperCase(w[0]);
                    sb.append(w);
                }
            }
        }
        String result = sb.toString();
        return result.length() > 100 ? result.substring(0, 100) : result;
    }

}
