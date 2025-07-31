package com.sinuke.easy;

import java.util.Arrays;

public class BuyTwoChocolates {

    public int buyChoco(int[] prices, int money) {
        int minf = Math.min(prices[0], prices[1]);
        int mins = Math.max(prices[0], prices[1]);

        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < minf) {
                mins = minf;
                minf = prices[i];
            } else if (prices[i] < mins) mins = prices[i];
        }

        int diff = money - minf - mins;
        return diff >= 0 ? diff : money;
    }

    public int buyChoco2(int[] prices, int money) {
        Arrays.sort(prices);
        int diff = money - prices[0] - prices[1];
        return diff >= 0 ? diff : money;
    }

}
