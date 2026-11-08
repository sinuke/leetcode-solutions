package com.sinuke.medium;

import java.util.*;

public class DesignTwitter {

    public static class Twitter {

        private int tweets = 0;
        private final Map<Integer, User> users;

        public Twitter() {
            this.users = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            users.putIfAbsent(userId, new User(userId));
            users.get(userId).tweets.add(new Tweet(++tweets, tweetId));
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> tweets = new PriorityQueue<>(users.get(userId).tweets);
            for (int id : users.get(userId).follows) tweets.addAll(users.get(id).tweets);

            List<Integer> result = new ArrayList<>(10);
            while (result.size() < 10 && !tweets.isEmpty()) {
                result.add(tweets.poll().id);
            }
            return result;
        }

        public void follow(int followerId, int followeeId) {
            users.get(followerId).follows.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            users.get(followerId).follows.remove(followeeId);
        }

        private static class User {
            int id;
            Set<Integer> follows;
            PriorityQueue<Tweet> tweets;

            public User(int id) {
                this.id = id;
                this.follows = new HashSet<>();
                this.tweets = new PriorityQueue<>((a, b) -> b.n - a.n);
            }
        }

        private static class Tweet {
            int n;
            int id;

            public Tweet(int n, int id) {
                this.n = n;
                this.id = id;
            }
        }

    }

}
