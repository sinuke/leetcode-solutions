package com.sinuke.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignAuctionSystem {

    public static class AuctionSystem {

        private final Map<Integer, Map<Integer, Bid>> users;
        private final Map<Integer, TreeSet<Bid>> items;

        public AuctionSystem() {
            this.users = new HashMap<>();
            this.items = new HashMap<>();
        }

        public void addBid(int userId, int itemId, int bidAmount) {
            users.putIfAbsent(userId, new HashMap<>());

            Bid bid = new Bid(itemId, userId, bidAmount);
            if (users.get(userId).containsKey(itemId)) {
                bid = users.get(userId).get(itemId);
                items.get(itemId).remove(bid);
                bid.bid = bidAmount;
            } else users.get(userId).put(itemId, bid);

            items.putIfAbsent(itemId, new TreeSet<>(Comparator.<Bid>comparingInt(b -> b.bid).thenComparing(b -> b.user)));
            items.get(itemId).add(bid);
        }

        public void updateBid(int userId, int itemId, int newAmount) {
            var bid = users.get(userId).get(itemId);
            items.get(itemId).remove(bid);

            bid.bid = newAmount;

            items.get(itemId).add(bid);
        }

        public void removeBid(int userId, int itemId) {
            var bid = users.get(userId).get(itemId);
            users.get(userId).remove(itemId);
            items.get(itemId).remove(bid);
        }

        public int getHighestBidder(int itemId) {
            return items.containsKey(itemId) && !items.get(itemId).isEmpty() ? items.get(itemId).last().user : -1;
        }

        private static class Bid {
            int item;
            int user;
            int bid;

            public Bid(int item, int user, int bid) {
                this.item = item;
                this.user = user;
                this.bid = bid;
            }
        }

    }

}
