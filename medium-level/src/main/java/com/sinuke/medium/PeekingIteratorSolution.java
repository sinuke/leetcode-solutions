package com.sinuke.medium;

import java.util.Iterator;

public class PeekingIteratorSolution {

    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
    public static class PeekingIterator implements Iterator<Integer> {
        private final Iterator<Integer> iterator;
        private Integer next = null;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            this.next = iterator.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            var current = next;
            next = iterator.hasNext() ? iterator.next() : null;
            return current;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }

}
