package com.sinuke.easy;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] cash = new int[21];
        for (int bill : bills) {
            cash[bill]++;
            if (bill == 10) {
                if (cash[5] > 0) cash[5]--;
                else return false;
            } else if (bill == 20) {
                if (cash[10] > 0 && cash[5] > 0) {
                    cash[10]--;
                    cash[5]--;
                } else if (cash[10] == 0 && cash[5] >= 3) cash[5] -= 3;
                else return false;
            }
        }
        return true;
    }

}
