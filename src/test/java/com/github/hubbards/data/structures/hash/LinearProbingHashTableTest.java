package com.github.hubbards.data.structures.hash;

/**
 * This class is a simple test suite for the {@link LinearProbingHashTable}
 * implementation {@link HashTable}.
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
