package com.github.hubbards.data.structures;

/**
 * This program is a simple test suite for the linked list implementation of the
 * stack ADT.
 *
 * @see LinkedList
 *
 * @author Spencer Hubbard
 */
public class LinkedListStackTest extends StackTest {
    @Override
    protected Stack<Integer> createStack() {
        return new LinkedList<Integer>();
    }

    // TODO: write implementation specific tests
}
