package com.sinuke.easy;

public class FindTheDistanceValueBetweenTwoArrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int answer = 0;
        for (int i = 0; i < arr1.length; i++) {
            int cnt = 0;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    cnt++;
                    break;
                }
            }

            answer += (cnt == 0) ? 1 : 0;
        }

        return answer;
    }

}
