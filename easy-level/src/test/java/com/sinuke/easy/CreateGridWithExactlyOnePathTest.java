package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateGridWithExactlyOnePathTest {

    @ParameterizedTest
    @MethodSource("testData")
    void createGrid(int m, int n) {
        var solution = new CreateGridWithExactlyOnePath();
        assertEquals(1, countPaths(solution.createGrid(m, n), m, n));
        assertEquals(1, countPaths(solution.createGrid2(m, n), m, n));
    }

    private static int countPaths(String[] grid, int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0].charAt(0) == '.' ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i].charAt(0) == '.' ? dp[i - 1][0] : 0;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0].charAt(j) == '.' ? dp[0][j - 1] : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i].charAt(j) == '.' ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 3),
                Arguments.of(3, 3),
                Arguments.of(1, 4),
                Arguments.of(1, 1),
                Arguments.of(25, 25)
        );
    }

}
