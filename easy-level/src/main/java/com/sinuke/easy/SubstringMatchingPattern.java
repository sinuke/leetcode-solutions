package com.sinuke.easy;

public class SubstringMatchingPattern {

    public boolean hasMatch(String s, String p) {
        if (p.length() == 1) return true;

        int starIndex = p.indexOf('*');
        if (starIndex == 0) return s.contains(p.substring(1));
        else if (starIndex == p.length() - 1) return s.contains(p.substring(0, p.length() - 1));
        else {
            String pl = p.substring(0, starIndex);
            String pr = p.substring(starIndex + 1);

            int l = s.indexOf(pl);
            if (l == -1) return false;
            int r = s.lastIndexOf(pr);
            if (r == -1) return false;

            return l + pl.length() <= r;
        }
    }

}
