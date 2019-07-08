package com.github.hubbards.data.structures;

/**
 * This class is a simple test suite for the {@link ArrayList} implementation of
 * {@link List}.
 *
 * @author Spencer Hubbard
 */
public class ArrayListTest extends ListTest {
    @Override
    protected ArrayList<Integer> createList() {
        return new ArrayList<Integer>();
    }

    // TODO: write implementation specific tests
}
