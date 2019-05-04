package com.github.hubbards.data.structures;

/**
 * TODO document class
 */
public class LinkedListTest extends ListTest<LinkedList<Integer>> {
    @Override
    protected LinkedList<Integer> createList() {
        return new LinkedList<Integer>();
    }
}
