package com.sinuke.medium;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, volume = 0;

        while (left < right) {
            int current = Math.min(height[left], height[right]) * (right - left);
            volume = Math.max(volume, current);
            if (height[left] <= height[right]) left++;
            else right--;
        }

        return volume;
    }

}
