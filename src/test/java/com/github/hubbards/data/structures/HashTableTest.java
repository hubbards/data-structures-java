package com.github.hubbards.data.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class is a simple test suite for {@link HashTable}.
 *
 * @author Spencer Hubbard
 */
public abstract class HashTableTest {
    private HashTable<String> hashTable;

    protected abstract HashTable<String> createHashTable();

    @Before
    public void setUp() {
        hashTable = createHashTable();
    }

    @Test
    public void testIsEmpty1() {
        assertTrue(hashTable.isEmpty());
    }

    @Test
    public void testIsEmpty2() {
        hashTable.insert("a");

        assertFalse(hashTable.isEmpty());
    }

    @Test
    public void testIsEmpty3() {
        hashTable.insert("a");
        hashTable.insert("b");
        hashTable.remove("a");

        assertFalse(hashTable.isEmpty());
    }

    @Test
    public void testIsEmpty4() {
        hashTable.insert("a");
        hashTable.remove("a");

        assertTrue(hashTable.isEmpty());
    }

    @Test
    public void testSize1() {
        assertEquals(0, hashTable.size());
    }

    @Test
    public void testSize2() {
        hashTable.insert("a");

        assertEquals(1, hashTable.size());
    }

    @Test
    public void testSize3() {
        hashTable.insert("a");
        hashTable.insert("b");
        hashTable.remove("a");

        assertEquals(1, hashTable.size());
    }

    @Test
    public void testContains1() {
        assertFalse(hashTable.contains("a"));
    }

    @Test
    public void testContains2() {
        hashTable.insert("a");

        assertTrue(hashTable.contains("a"));
    }

    @Test
    public void testContains3() {
        hashTable.insert("b");

        assertFalse(hashTable.contains("a"));
    }

    @Test
    public void testContains4() {
        hashTable.insert("a");
        hashTable.remove("a");

        assertFalse(hashTable.contains("a"));
    }

    @Test
    public void testContains5() {
        hashTable.insert("a");
        hashTable.insert("b");
        hashTable.remove("a");

        assertTrue(hashTable.contains("b"));
    }
}
