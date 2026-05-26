package com.sinuke.medium;

class StringCompression {

    public int compress(char[] chars) {
        int l = 0, cnt = 1;
        char prev = chars[0];

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) cnt++;
            else {
                if (cnt > 1) {
                    int j = 0;
                    char[] d = String.valueOf(cnt).toCharArray();
                    while (j < d.length) chars[++l] = d[j++];
                    cnt = 1;
                }
                chars[++l] = chars[i];
            }
            prev = chars[i];
        }

        if (cnt > 1) {
            int j = 0;
            char[] d = String.valueOf(cnt).toCharArray();
            while (j < d.length) chars[++l] = d[j++];
        }

        return l + 1;
    }

}
