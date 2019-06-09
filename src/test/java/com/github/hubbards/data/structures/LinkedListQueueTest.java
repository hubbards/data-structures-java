package com.github.hubbards.data.structures;

/**
 * This program is a simple test suit for the linked list implementation of the
 * queue ADT.
 *
 * @see LinkedList
 *
 * @author Spencer Hubbard
 */
public class LinkedListQueueTest extends QueueTest {
    @Override
    protected Queue<Integer> createQueue() {
        return new LinkedList<Integer>();
    }

    // TODO: write implementation specific tests
}
