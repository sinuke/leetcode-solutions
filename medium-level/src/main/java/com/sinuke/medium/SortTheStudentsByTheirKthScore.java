package com.sinuke.medium;

import java.util.Arrays;
import java.util.Comparator;

public class SortTheStudentsByTheirKthScore {

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, Comparator.<int[]>comparingInt(s -> s[k]).reversed());
        return score;
    }

}
