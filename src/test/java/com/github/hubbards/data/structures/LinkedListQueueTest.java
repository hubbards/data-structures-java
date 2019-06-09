package com.github.hubbards.data.structures;

public class LinkedListQueueTest extends QueueTest {
    @Override
    protected Queue<Integer> createQueue() {
        return new LinkedList<Integer>();
    }
}
