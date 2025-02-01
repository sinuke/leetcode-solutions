package com.sinuke.easy;

import java.util.ArrayList;
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
            List<String> result = new ArrayList<>();

            while (ptr < values.length && values[ptr] != null) {
                result.add(values[ptr]);
                ptr++;
            }

            return result;
        }

    }

}
