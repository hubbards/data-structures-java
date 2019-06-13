package com.github.hubbards.data.structures;

/**
 * This class is a simple test suite for the {@link LinkedList} implementation
 * of {@link Stack}.
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
