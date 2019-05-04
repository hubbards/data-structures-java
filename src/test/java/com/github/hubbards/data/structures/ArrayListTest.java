package com.github.hubbards.data.structures;

/**
 * TODO document class
 */
public class ArrayListTest extends ListTest<ArrayList<Integer>> {
    @Override
    protected ArrayList<Integer> createList() {
        return new ArrayList<Integer>();
    }
}
