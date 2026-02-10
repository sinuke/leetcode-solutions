package com.sinuke.easy;

public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int countA = s.charAt(0) == 'A' ? 1 : 0, maxConsL = 0, consL = s.charAt(0) == 'L' ? 1 : 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
                if (countA == 2) return false;
            } else if (s.charAt(i) == 'L') {
                if (s.charAt(i - 1) == 'L') consL++;
                else consL = 1;
            }

            maxConsL = Math.max(maxConsL, consL);
            if (maxConsL >= 3) return false;
        }
        return true;
    }

}
