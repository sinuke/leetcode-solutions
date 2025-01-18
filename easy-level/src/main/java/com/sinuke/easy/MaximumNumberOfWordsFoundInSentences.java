package com.sinuke.easy;

public class MaximumNumberOfWordsFoundInSentences {

    // 2 ms
    public int mostWordsFound(String[] sentences) {
        int max = 0;

        for (var sentence : sentences) {
            int tmp = 0;

            for (char c : sentence.toCharArray()) {
                if (c == ' ') tmp++;
            }

            if (tmp > max) max = tmp;
        }

        return max + 1;
    }

    // 3 ms
    public int mostWordsFound2(String[] sentences) {
        int max = 0;

        for (var sentence : sentences) {
            var words = sentence.split(" ");
            if (words.length > max) max = words.length;
        }

        return max;
    }

}
