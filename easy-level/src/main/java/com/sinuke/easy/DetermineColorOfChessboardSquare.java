package com.sinuke.easy;

public class DetermineColorOfChessboardSquare {

    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a') + (coordinates.charAt(1) - '0')) % 2 == 0;
    }

}
