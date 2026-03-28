package com.sinuke.easy;

public class CanPlaceFlowers {
    
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, zeros = 0;
        while (n > 0 && i < flowerbed.length) {
            if (flowerbed[i] == 0) {
                zeros++;
                if ((flowerbed.length == 1) || (i == 1 && zeros == 2) || (i == flowerbed.length - 1 && zeros == 2) || zeros == 3) {
                    n--;
                    zeros = 1;
                }
            } else zeros = 0;
            i++;
        }
        return n == 0;
    }

}
