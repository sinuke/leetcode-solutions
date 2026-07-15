package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintInOrderTest {

    @ParameterizedTest
    @MethodSource("testData")
    void printInOrder(int[] nums) throws InterruptedException {
        PrintInOrder foo = new PrintInOrder();
        StringBuilder result = new StringBuilder();

        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            int method = nums[i];
            threads[i] = new Thread(() -> {
                try {
                    switch (method) {
                        case 1 -> foo.first(() -> result.append("first"));
                        case 2 -> foo.second(() -> result.append("second"));
                        case 3 -> foo.third(() -> result.append("third"));
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        assertEquals("firstsecondthird", result.toString());
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}),
                Arguments.of(new int[]{1, 3, 2})
        );
    }

}
