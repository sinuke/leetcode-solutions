package com.sinuke.easy;

public class FinalPricesWithSpecialDiscountInShop {

    public int[] finalPrices(int[] prices) {
        int[] answers = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int discont = 0;

            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    discont = prices[j];
                    break;
                }
            }

            answers[i] = prices[i] - discont;
        }

        return answers;
    }

}
