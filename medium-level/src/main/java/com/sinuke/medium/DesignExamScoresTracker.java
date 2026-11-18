package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;

public class DesignExamScoresTracker {

    public static class ExamTracker {

        private final List<Exam> lst;

        public ExamTracker() {
            this.lst = new ArrayList<>(100_000);
        }

        public void record(int time, int score) {
            long prev = lst.isEmpty() ? 0 : lst.getLast().total;
            lst.add(new Exam(time, score, prev + score));
        }

        public long totalScore(int startTime, int endTime) {
            int l = 0, r = lst.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (lst.get(m).time >= startTime) r = m;
                else l = m + 1;
            }

            int startIndex = l == lst.size() ? -1 : l;

            l = 0;
            r = lst.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (lst.get(m).time > endTime) r = m;
                else l = m + 1;
            }

            int endIndex = l == 0 ? -1 : l - 1;

            return startIndex <= endIndex ? lst.get(endIndex).total - (startIndex == 0 ? 0 : lst.get(startIndex - 1).total) : 0;
        }

        private record Exam(int time, int score, long total) {}
    }

}
