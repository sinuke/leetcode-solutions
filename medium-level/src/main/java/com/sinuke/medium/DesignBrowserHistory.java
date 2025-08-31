package com.sinuke.medium;

public class DesignBrowserHistory {

    public static class BrowserHistory {

        private HistoryNode home;
        private HistoryNode current;

        public BrowserHistory(String homepage) {
            home = new HistoryNode(homepage);
            current = home;
        }

        public void visit(String url) {
            if (current.next != null) current.next.prev = null;

            var node = new HistoryNode(url);
            node.prev = current;
            current.next = node;
            current = node;
        }

        public String back(int steps) {
            while (steps > 0) {
                if (current.prev == null) break;
                current = current.prev;
                steps--;
            }
            return current.url;
        }

        public String forward(int steps) {
            while (steps > 0) {
                if (current.next == null) break;
                current = current.next;
                steps--;
            }
            return current.url;
        }

        private static class HistoryNode {
            String url;
            HistoryNode next;
            HistoryNode prev;

            HistoryNode(String url) {
                this.url = url;
            }
        }

    }

}
