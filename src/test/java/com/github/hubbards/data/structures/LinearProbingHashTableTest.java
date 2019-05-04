package com.github.hubbards.data.structures;

/**
 * TODO document class
 */
public class LinearProbingHashTableTest extends HashTableTest<LinearProbingHashTable<String>> {
    @Override
    protected LinearProbingHashTable<String> createHashTable() {
        return new LinearProbingHashTable<String>();
    }

    // TODO write implementation specific tests
}
