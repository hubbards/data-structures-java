package com.github.hubbards.data.structures;

/**
 * This class is a simple test suite for the {@link ArrayQueue} implementation
 * of {@link Queue}.
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
