package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getParenthesis("", 0, 0, n, result);
        return result;
    }

    private void getParenthesis(String str, int opened, int closed, int n, List<String> result) {
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }

        if (opened < n) getParenthesis(str + "(", opened + 1, closed, n, result);
        if (closed < opened) getParenthesis(str + ")", opened, closed + 1, n, result);
    }

}
