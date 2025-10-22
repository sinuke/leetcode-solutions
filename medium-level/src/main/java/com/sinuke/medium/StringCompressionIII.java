package com.sinuke.medium;

public class StringCompressionIII {

    public String compressedString(String word) {
        if (word.isEmpty()) return word;

        var sb = new StringBuilder();
        char prev = word.charAt(0);
        int counter = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == prev) {
                counter++;
                if (counter == 10) {
                    sb.append(counter - 1).append(prev);
                    counter = 1;
                }
            } else {
                sb.append(counter).append(prev);
                prev = word.charAt(i);
                counter = 1;
            }
        }

        return sb.append(counter).append(prev).toString();
    }

}
