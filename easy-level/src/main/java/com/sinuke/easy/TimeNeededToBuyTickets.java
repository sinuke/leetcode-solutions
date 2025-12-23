package com.sinuke.easy;

public class TimeNeededToBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int aim = tickets[k], time = 0;
        for (int i = 0; i < tickets.length; i++) {
            time += i <= k ? Math.min(tickets[i], aim) : Math.min(tickets[i], aim - 1);
        }
        return time;
    }

    public int timeRequiredToBuy2(int[] tickets, int k) {
         int time = 0;
         while (tickets[k] > 0) {
             for (int i = 0; i < tickets.length; i++) {
                 if (tickets[i] > 0) {
                     time++;
                     tickets[i]--;
                     if (i == k && tickets[i] == 0) break;
                 }
             }
         }
         return time;
    }

}
