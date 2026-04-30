package com.sinuke.easy;

public class CrawlerLogFolder {

    public int minOperations(String[] logs) {
        int cnt = 0;
        for (String log : logs) {
            switch (log) {
                case "../" -> cnt -= (cnt == 0) ? 0 : 1;
                case "./" -> {}
                default -> cnt++;
            }
        }
        return cnt;
    }

}
