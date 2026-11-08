package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignTwitterTest {

    @ParameterizedTest
    @MethodSource("testData")
    void twitterTest(String[] operations, Object[] values, Object[] expected) {
        DesignTwitter.Twitter solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Twitter" -> {
                    solution = new DesignTwitter.Twitter();
                    actual[i] = null;
                }

                case "postTweet" -> {
                    int[] vals = (int[]) values[i];
                    solution.postTweet(vals[0], vals[1]);
                    actual[i] = null;
                }

                case "getNewsFeed" -> {
                    int[] vals = (int[]) values[i];
                    actual[i] = solution.getNewsFeed(vals[0]);
                }

                case "follow" -> {
                    int[] vals = (int[]) values[i];
                    solution.follow(vals[0], vals[1]);
                    actual[i] = null;
                }

                case "unfollow" -> {
                    int[] vals = (int[]) values[i];
                    solution.unfollow(vals[0], vals[1]);
                    actual[i] = null;
                }

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"},
                        new Object[] {
                                new int[] {},
                                new int[] {1, 5},
                                new int[] {1},
                                new int[] {1, 2},
                                new int[] {2, 6},
                                new int[] {1},
                                new int[] {1, 2},
                                new int[] {1}
                        },
                        new Object[] {null, null, List.of(5), null, null, List.of(6, 5), null, List.of(5)}
                )
        );
    }

}
