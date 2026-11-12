package com.sinuke.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DesignSQL {

    public static class SQL {

        private final Map<String, Table> tables = new HashMap<>();

        public SQL(List<String> names, List<Integer> columns) {
            for (int i = 0; i < names.size(); i++) {
                tables.put(names.get(i), new Table(names.get(i), columns.get(i)));
            }
        }

        public boolean ins(String name, List<String> row) {
            if (!tables.containsKey(name)) return false;

            var table = tables.get(name);

            if (table.columns != row.size()) return false;

            var r = new Row(table.getId(), row);
            table.rows.add(r);
            table.index.put(r.id, r);

            return true;
        }

        public void rmv(String name, int rowId) {
            if (tables.containsKey(name)) {
                var table = tables.get(name);
                if (table.index.containsKey(rowId)) {
                    var row = table.index.get(rowId);
                    table.index.remove(rowId);
                    table.rows.remove(row);
                }
            }
        }

        public String sel(String name, int rowId, int columnId) {
            if (!tables.containsKey(name)) return "<null>";

            var table = tables.get(name);

            if (!table.index.containsKey(rowId)) return "<null>";

            var row = table.index.get(rowId);

            if (columnId < 0 || columnId > row.values.size()) return "<null>";
            else if (columnId == 0) return String.valueOf(row.id);
            else return row.values.get(columnId - 1);
        }

        public List<String> exp(String name) {
            if (!tables.containsKey(name)) return List.of();
            var table = tables.get(name);
            List<String> result = new ArrayList<>(table.rows.size());
            for (var row : table.rows) {
                var sb = new StringBuilder();
                sb.append(row.id).append(',');
                for (var value : row.values) sb.append(value).append(',');
                sb.setLength(sb.length() - 1);
                result.add(sb.toString());
            }
            return result;
        }

        private static class Table {
            private int counter = 0;

            String name;
            int columns;

            Map<Integer, Row> index;
            List<Row> rows;

            public Table(String name, int columns) {
                this.name = name;
                this.columns = columns;
                this.index = new HashMap<>();
                this.rows = new LinkedList<>();
            }

            public int getId() {
                counter++;
                return counter;
            }
        }

        private static class Row {
            int id;
            List<String> values;

            public Row(int id, List<String> values) {
                this.id = id;
                this.values = values;
            }
        }
    }

}
