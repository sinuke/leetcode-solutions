package com.sinuke.medium;

public class DesignBrowserHistory {

    public static class BrowserHistory {

        private HistoryNode current;

        public BrowserHistory(String homepage) {
            current = new HistoryNode(homepage);
        }

        public void visit(String url) {
            if (current.next != null) current.next.prev = null;

            var node = new HistoryNode(url);
            node.prev = current;
            current.next = node;
            current = node;
        }

        public String back(int steps) {
            while (steps > 0 && current.prev != null) {
                current = current.prev;
                steps--;
            }
            return current.url;
        }

        public String forward(int steps) {
            while (steps > 0 && current.next != null) {
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
