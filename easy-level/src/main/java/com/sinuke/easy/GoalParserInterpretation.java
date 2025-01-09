package com.sinuke.easy;

public class GoalParserInterpretation {

    public String interpret(String command) {
        var sb = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == 'G') sb.append('G');
            else if (command.charAt(i) == '(' && i < command.length() - 1) {
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i++;
                } else {
                    sb.append("al");
                    i += 3;
                }
            }

            i++;
        }
        return sb.toString();
    }

}
