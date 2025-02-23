package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class CellsInRangeOnExcelSheet {

    public List<String> cellsInRange(String s) {
        char startColumn = s.charAt(0);
        char endColumn = s.charAt(3);
        int startRow = s.charAt(1) - '0';
        int endRow = s.charAt(4) - '0';

        List<String> result = new ArrayList<>();
        for (char column = startColumn; column <= endColumn; column++) {
            for (int row = startRow; row <= endRow; row++) result.add(column + "" + row);
        }

        return result;
    }

}
