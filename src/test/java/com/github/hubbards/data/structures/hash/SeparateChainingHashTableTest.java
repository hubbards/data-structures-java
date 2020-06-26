package com.github.hubbards.data.structures.hash;

/**
 * This program is a simple test suite for the {@link SeparateChainingHashTable}
 * implementation of {@link HashTable}.
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
