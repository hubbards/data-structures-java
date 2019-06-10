package com.github.hubbards.data.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This program is a simple test suite for the binary (min) heap implementation
 * of the priority queue ADT.
 *
 * @see Heap
 *
 * @author Spencer Hubbard
 */
public class HeapTest {
    private Heap<Integer> heap;

    @Before
    public void setUp() {
        heap = new Heap<Integer>();
    }

    @Test
    public void testIsEmpty1() {
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsEmpty2() {
        heap.insert(1);

        assertFalse(heap.isEmpty());
    }

    @Test
    public void testIsEmpty3() {
        heap.insert(1);
        heap.insert(2);
        heap.deleteMin();

        assertFalse(heap.isEmpty());
    }

    @Test
    public void testIsEmpty4() {
        heap.insert(1);
        heap.deleteMin();

        assertTrue(heap.isEmpty());
    }

    @Test(expected = UnderflowException.class)
    public void testFindMin1() {
        heap.findMin();
    }

    @Test(expected = UnderflowException.class)
    public void testFindMin2() {
        heap.insert(1);
        heap.deleteMin();
        heap.findMin();
    }

    @Test
    public void testFindMin3() {
        heap.insert(1);

        assertEquals(1, (int) heap.findMin());
    }

    @Test
    public void testFindMin4() {
        heap.insert(1);
        heap.insert(2);

        assertEquals(1, (int) heap.findMin());
    }

    @Test
    public void testFindMin5() {
        heap.insert(2);
        heap.insert(1);

        assertEquals(1, (int) heap.findMin());
    }

    @Test
    public void testFindMin6() {
        heap.insert(1);
        heap.insert(2);
        heap.deleteMin();

        assertEquals(2, (int) heap.findMin());
    }

    @Test(expected = UnderflowException.class)
    public void testDeleteMin1() {
        heap.deleteMin();
    }

    @Test(expected = UnderflowException.class)
    public void testDeleteMin2() {
        heap.insert(1);
        heap.deleteMin();
        heap.deleteMin();
    }

    // TODO: write more tests
}
