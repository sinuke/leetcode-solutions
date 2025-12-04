package com.sinuke.easy;

public class FurthestPointFromOrigin {

    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, o = 0;
        for (char c : moves.toCharArray()) {
            l += c == 'L' ? 1 : 0;
            r += c == 'R' ? 1 : 0;
            o += c == '_' ? 1 : 0;
        }

        if (l > r) l += o;
        else r += o;

        return Math.abs(l - r);
    }

}
