package com.sinuke.easy;

public class BestTimeBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int buy = prices[0];
        int sell = prices[1];
        int profit = sell - buy;

        for (int i = 1; i < prices.length - 1; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
                sell = prices[i + 1];
            }
            if (sell < prices[i + 1]) sell = prices[i + 1];
            if (sell - buy > profit) profit = sell - buy;
        }

        return Math.max(profit, 0);
    }

    public int maxProfitOptimized(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }

}
