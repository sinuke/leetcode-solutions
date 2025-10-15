package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignCircularQueueTest {

    @ParameterizedTest
    @MethodSource("testData")
    void DesignCircularQueueTest(String[] operations, Integer[] values, Object[] expected) {
        DesignCircularQueue.MyCircularQueue solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MyCircularQueue" -> {
                    solution = new DesignCircularQueue.MyCircularQueue(values[i]);
                    actual[i] = null;
                }

                case "enQueue" -> actual[i] = solution.enQueue(values[i]);
                case "deQueue" -> actual[i] = solution.deQueue();
                case "Front" -> actual[i] = solution.Front();
                case "Rear" -> actual[i] = solution.Rear();
                case "isEmpty" -> actual[i] = solution.isEmpty();
                case "isFull" -> actual[i] = solution.isFull();

                default -> throw new IllegalArgumentException("Unexpected value: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"},
                        new Integer[] {3, 1, 2, 3, 4, null, null, null, 4, null},
                        new Object[] {null, true, true, true, false, 3, true, true, true, 4}
                ),
                Arguments.of(
                        new String[] {"MyCircularQueue","enQueue","enQueue","deQueue","enQueue","deQueue","enQueue","deQueue","enQueue","deQueue", "Front"},
                        new Integer[] {2,1,2,null,3,null,3,null,3,null,null},
                        new Object[] {null,true,true,true,true,true,true,true,true,true,3}
                ),
                Arguments.of(
                        new String[] {"MyCircularQueue","enQueue","Front","enQueue","Rear","enQueue","enQueue","Rear","deQueue","Front","deQueue","Front"},
                        new Integer[] {7,0,null,4,null,6,3,null,null,null,null,null},
                        new Object[] {null,true,0,true,4,true,true,3,true,4,true,6}
                )
        );
    }

}
