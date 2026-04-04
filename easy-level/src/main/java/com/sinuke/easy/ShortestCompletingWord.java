package com.sinuke.easy;

public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] freq = new int[26];
        int letters = 0;
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                int i = Character.toLowerCase(c) - 'a';
                freq[i]++;
                if (freq[i] == 1) letters++;
            }
        }

        String answer = null;
        for (String word : words) {
            if (isCompleting(freq, letters, word)) {
                if (answer == null || word.length() < answer.length()) answer = word;
            }
        }
        return answer;
    }

    private boolean isCompleting(int[] letters, int count, String word) {
        int[] f = new int[26];
        System.arraycopy(letters, 0, f, 0, 26);
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            f[i]--;
            if (f[i] == 0) count--;
        }
        return count == 0;
    }

}
