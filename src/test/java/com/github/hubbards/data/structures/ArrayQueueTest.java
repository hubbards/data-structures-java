package com.github.hubbards.data.structures;

/**
 * TODO document class
 */
public class ArrayQueueTest extends QueueTest {
    @Override
    protected ArrayQueue<Integer> createQueue() {
        return new ArrayQueue<Integer>();
    }
}
