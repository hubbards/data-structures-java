package com.github.hubbards.data.structures;

/**
 * This program is a simple test suite for the circular array implementation of
 * the queue ADT.
 *
 * @author Spencer Hubbard
 */
public class ArrayQueueTest extends QueueTest {
    @Override
    protected ArrayQueue<Integer> createQueue() {
        return new ArrayQueue<Integer>();
    }

    // TODO: write implementation specific tests
}
