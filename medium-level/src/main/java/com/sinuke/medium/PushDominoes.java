package com.sinuke.medium;

class PushDominoes {

    public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        char prev = d[0];
        int l = -1, r = -1, i = 0;

        while (i < d.length) {
            if (d[i] == 'L') {
                if (prev == 'R' && r != -1) {
                    while (r < i) d[r++] = 'R';
                    r = -1;
                } else if (prev == '.') l = i;
            }else if (d[i] == '.' && prev == 'R') {
                if (r == -1) r = i - 1;
                else {
                    while (r < i) d[r++] = 'R';
                    r--;
                }
            }

            if (l != -1 && r != -1) {
                boolean notFall = (l - r) % 2 != 0;
                while (r < l) {
                    if (notFall && l - r == 2) break;
                    else {
                        d[r++] = 'R';
                        d[l--] = 'L';
                    }
                }
                l = -1;
                r = -1;
            } else if (r == -1 && l != -1) {
                l--;
                while (l >= 0 && d[l] == '.') d[l--] = 'L';
                l = -1;
            }

            prev = d[i];
            i++;
        }

        if (r != -1) {
            while (r < d.length && (d[r] == '.' || d[r] == 'R')) d[r++] = 'R';
        }

        return new String(d);
    }

}
