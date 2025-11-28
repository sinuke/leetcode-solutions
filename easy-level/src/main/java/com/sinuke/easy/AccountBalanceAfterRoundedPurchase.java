package com.sinuke.easy;

public class AccountBalanceAfterRoundedPurchase {

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int d = purchaseAmount % 10;
        if (d >= 0 && d < 5) purchaseAmount -= d;
        else purchaseAmount += (10 - d);
        return 100 - purchaseAmount;
    }

}
