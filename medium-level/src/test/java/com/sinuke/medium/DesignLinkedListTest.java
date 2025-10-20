package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void designLinkedList(String[] operations, Integer[][] values, Integer[] expected) {
        DesignLinkedList.MyLinkedList solution = null;
        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MyLinkedList" -> {
                    solution = new DesignLinkedList.MyLinkedList();
                    actual[i] = null;
                }
                case "get" -> actual[i] = solution.get(values[i][0]);
                case "addAtHead" -> {
                    solution.addAtHead(values[i][0]);
                    actual[i] = null;
                }
                case "addAtTail" -> {
                    solution.addAtTail(values[i][0]);
                    actual[i] = null;
                }
                case "addAtIndex" -> {
                    solution.addAtIndex(values[i][0], values[i][1]);
                    actual[i] = null;
                }
                case "deleteAtIndex" -> {
                    solution.deleteAtIndex(values[i][0]);
                    actual[i] = null;
                }

                default -> throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"},
                        new Integer[][] {{}, {1}, {3}, {1, 2}, {1}, {1}, {1}},
                        new Integer[] {null, null, null, null, 2, null, 3}
                ),
                Arguments.of(
                        new String[] {"MyLinkedList","addAtHead","deleteAtIndex"},
                        new Integer[][] {{},{1},{0}},
                        new Integer[] {null,null,null}
                )
        );
    }

}
