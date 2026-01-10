package com.sinuke.easy;

public class PassThePillow {

    // 1 ms - 18%
    public int passThePillow(int n, int time) {
        int direction = 1, i = 1;

        while (time > 0) {
            if (i == n) direction = -1;
            else if (i == 1) direction = 1;

            i += direction;
            time--;
        }

        return i;
    }

    // 0 ms - 100%
    public int passThePillow2(int n, int time) {
        if (time < n) return time + 1;
        else if (time % (n - 1) == 0) return (time / (n - 1)) % 2 == 0 ? 1 : n;
        else return (time / (n - 1)) % 2 == 0 ? 1 + time % (n - 1): n - time % (n - 1);
    }

}
