package com.github.hubbards.data.structures;

/**
 * This program is a simple test suit for the implementation of the hash table
 * ADT using separate chaining to avoid collisions.
 *
 * @see SeparateChainingHashTable
 *
 * @author Spencer Hubbard
 */
public class SeparateChainingHashTableTest extends HashTableTest {
    @Override
    protected SeparateChainingHashTable<String> createHashTable() {
        return new SeparateChainingHashTable<String>();
    }

    // TODO: write implementation specific tests
}
