package com.sinuke.easy;

public class WeightedWordMapping {

    public String mapWordWeights(String[] words, int[] weights) {
        var sb = new StringBuilder();
        for (var word : words) {
            int w = 0;
            for (char c : word.toCharArray()) w += weights[c - 'a'];
            sb.append((char) (Math.abs(25 - w % 26) + 'a'));
        }
        return sb.toString();
    }

}
