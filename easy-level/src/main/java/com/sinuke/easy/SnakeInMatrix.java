package com.sinuke.easy;

import java.util.List;

public class SnakeInMatrix {

    public int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0, column = 0;

        for (var command : commands) {
            if ("RIGHT".equals(command)) column++;
            else if ("DOWN".equals(command)) row++;
            else if ("UP".equals(command)) row--;
            else if ("LEFT".equals(command)) column--;
        }

        return row * n + column;
    }

}
