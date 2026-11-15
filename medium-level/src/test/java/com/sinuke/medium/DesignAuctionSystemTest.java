package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignAuctionSystemTest {

    @ParameterizedTest
    @MethodSource("testData")
    void auctionSystemTest(String[] operations, Object[] values, Object[] expected) {
        DesignAuctionSystem.AuctionSystem solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "AuctionSystem" -> {
                    solution = new DesignAuctionSystem.AuctionSystem();
                    actual[i] = null;
                }

                case "addBid" -> {
                    int[] vals = (int[]) values[i];
                    solution.addBid(vals[0], vals[1], vals[2]);
                    actual[i] = null;
                }

                case "updateBid" -> {
                    int[] vals = (int[]) values[i];
                    solution.updateBid(vals[0], vals[1], vals[2]);
                    actual[i] = null;
                }

                case "removeBid" -> {
                    int[] vals = (int[]) values[i];
                    solution.removeBid(vals[0], vals[1]);
                    actual[i] = null;
                }

                case "getHighestBidder" -> actual[i] = solution.getHighestBidder((int) values[i]);

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"AuctionSystem", "addBid", "addBid", "getHighestBidder", "updateBid", "getHighestBidder", "removeBid", "getHighestBidder", "getHighestBidder"},
                        new Object[] {null, new int[] {1, 7, 5}, new int[] {2, 7, 6}, 7, new int[] {1, 7, 8}, 7, new int[] {2, 7}, 7, 3},
                        new Object[] {null, null, null, 2, null, 1, null, 1, -1}
                ),
                Arguments.of(
                        new String[] {"AuctionSystem", "addBid", "addBid", "addBid", "getHighestBidder", "removeBid", "getHighestBidder"},
                        new Object[] {null, new int[] {3, 1, 10}, new int[] {1, 1, 10}, new int[] {2, 1, 5}, 1, new int[] {3, 1}, 1},
                        new Object[] {null, null, null, null, 3, null, 1}
                ),
                Arguments.of(
                        new String[] {"AuctionSystem", "addBid", "addBid", "getHighestBidder", "updateBid", "getHighestBidder", "removeBid", "getHighestBidder"},
                        new Object[] {null, new int[] {5, 2, 7}, new int[] {5, 2, 9}, 2, new int[] {5, 2, 4}, 2, new int[] {5, 2}, 2},
                        new Object[] {null, null, null, 5, null, 5, null, -1}
                )
        );
    }

}
