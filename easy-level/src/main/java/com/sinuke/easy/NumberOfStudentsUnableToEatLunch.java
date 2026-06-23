package com.sinuke.easy;

public class NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        int s = 0, c = 0;
        for (int student : students) {
            if (student == 0) c++;
            else s++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0 && c > 0) c--;
            else if (sandwich == 0 && c == 0) break;
            else if (sandwich == 1 && s > 0) s--;
            else if (sandwich == 1 && s == 0) break;
        }

        return c + s;
    }

}
