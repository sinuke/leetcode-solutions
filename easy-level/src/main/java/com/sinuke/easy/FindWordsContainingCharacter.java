package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>(words.length);

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) result.add(i);
        }

        return result;
    }

}
