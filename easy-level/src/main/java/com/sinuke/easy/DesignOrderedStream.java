package com.sinuke.easy;

import java.util.Arrays;
import java.util.List;

public class DesignOrderedStream {

    public static class OrderedStream {

        private final String[] values;
        private int ptr;

        public OrderedStream(int n) {
            values = new String[n];
            ptr = 0;
        }

        public List<String> insert(int idKey, String value) {
            values[idKey - 1] = value;
            return values[ptr] == null ? List.of() : getValues();
        }

        private List<String> getValues() {
            int start = ptr;
            for (int i = start; i < values.length; i++) {
                if (values[i] == null || (values[i] != null && i == values.length - 1)) {
                    ptr = i == values.length - 1 ? i + 1 : i;
                    return Arrays.asList(Arrays.copyOfRange(values, start, ptr));
                }
            }

            return List.of();
        }

    }

}
