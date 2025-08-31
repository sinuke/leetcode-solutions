package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignBrowserHistoryTest {

    @ParameterizedTest
    @MethodSource("testData")
    void browserHistoryTest(String[] operations, Object[][] values, String[] expected) {
        DesignBrowserHistory.BrowserHistory solution = null;
        String[] actual = new String[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "BrowserHistory": {
                    solution = new DesignBrowserHistory.BrowserHistory((String) values[i][0]);
                    actual[i] = null;
                    break;
                }

                case "visit": {
                    solution.visit((String) values[i][0]);
                    actual[i] = null;
                    break;
                }

                case "back": {
                    actual[i] = solution.back((int) values[i][0]);
                    break;
                }

                case "forward": {
                    actual[i] = solution.forward((int) values[i][0]);
                    break;
                }

                default: throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"},
                        new Object[][] {{"leetcode.com"},{"google.com"},{"facebook.com"},{"youtube.com"},{1},{1},{1},{"linkedin.com"},{2},{2},{7}},
                        new String[] {null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"}
                )
        );
    }

}
