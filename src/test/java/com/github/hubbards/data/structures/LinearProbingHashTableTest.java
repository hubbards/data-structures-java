package com.github.hubbards.data.structures;

/**
 * This program is a simple test suit for the implementation of the hash table
 * ADT using linear probing to avoid collisions.
 *
 * @see LinearProbingHashTable
 *
 * @author Spencer Hubbard
 */
public class LinearProbingHashTableTest extends HashTableTest {
    @Override
    protected LinearProbingHashTable<String> createHashTable() {
        return new LinearProbingHashTable<String>();
    }

    // TODO: write implementation specific tests
}
