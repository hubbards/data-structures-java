package com.github.hubbards.data.structures;

public class LinkedListStackTest extends StackTest {
    @Override
    protected Stack<Integer> createStack() {
        return new LinkedList<Integer>();
    }
}
