package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignCircularDequeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void MyCircularDequeTest(String[] operations, Integer[] values, Object[] expected) {
        DesignCircularDeque.MyCircularDeque solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MyCircularDeque" -> {
                    solution = new DesignCircularDeque.MyCircularDeque(values[i]);
                    actual[i] = null;
                }

                case "insertFront" -> actual[i] = solution.insertFront(values[i]);
                case "insertLast" -> actual[i] = solution.insertLast(values[i]);
                case "deleteFront" -> actual[i] = solution.deleteFront();
                case "deleteLast" -> actual[i] = solution.deleteLast();
                case "isEmpty" -> actual[i] = solution.isEmpty();
                case "isFull" -> actual[i] = solution.isFull();
                case "getFront" -> actual[i] = solution.getFront();
                case "getRear" -> actual[i] = solution.getRear();

                default -> throw new IllegalArgumentException("invalid operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"},
                        new Integer[] {3,1,2,3,4,null,null,null,4,null},
                        new Object[] {null, true, true, true, false, 2, true, true, true, 4}
                )
        );
    }

}
