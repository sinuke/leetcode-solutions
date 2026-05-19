package com.sinuke.medium;

import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill {

    // 3 ms
    public long dividePlayers2(int[] skill) {
        int[] arr = new int[1001];
        int sum = 0;
        for (int s : skill) {
            arr[s]++;
            sum += s;
        }
        int t = 2 * sum / skill.length;
        if (t * skill.length != 2 * sum) return -1;

        long result = 0;
        int cnt = 0;
        for (int j : skill) {
            if (arr[j] > 0 && t - j <= 1000 && arr[t - j] > 0) {
                result += (long) j * (t - j);
                arr[j]--;
                arr[t - j]--;
            } else cnt++;
        }

        return cnt <= skill.length / 2 ? result : -1;
    }

    // 22 ms
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int t = skill[0] + skill[skill.length - 1], sum = t, cnt = 0;
        long result = (long) skill[0] * skill[skill.length - 1];
        for (int i = 1; i < skill.length / 2; i++) {
            if (t == skill[i] + skill[skill.length - i - 1]) result += (long) skill[i] * skill[skill.length - i - 1];
            else cnt++;
            sum += skill[i] + skill[skill.length - i - 1];
        }

        return t * skill.length != 2 * sum || cnt > 0 ? - 1 : result;
    }

}
