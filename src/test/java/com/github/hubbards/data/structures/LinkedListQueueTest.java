package com.github.hubbards.data.structures;

/**
 * This class is a simple test suite for the {@link LinkedList} implementation
 * of {@link Queue}.
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
