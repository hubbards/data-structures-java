package com.github.hubbards.data.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class is a simple test suite for {@link List}.
 *
 * @author Spencer Hubbard
 */
public abstract class ListTest {
    private List<Integer> list;

    protected abstract List<Integer> createList();

    @Before
    public void setUp() {
        list = createList();
    }

    @Test
    public void testIsEmpty1() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmpty2() {
        list.add(1);

        assertFalse(list.isEmpty());
    }

    @Test
    public void testIsEmpty3() {
        list.add(1);
        list.add(2);
        list.remove(1);

        assertFalse(list.isEmpty());
    }

    @Test
    public void testIsEmpty4() {
        list.add(1);
        list.remove(0);

        assertTrue(list.isEmpty());
    }

    @Test
    public void testSize1() {
        assertEquals(0, list.size());
    }

    @Test
    public void testSize2() {
        list.add(1);

        assertEquals(1, list.size());
    }

    @Test
    public void testSize3() {
        list.add(1);
        list.add(2);
        list.remove(1);

        assertEquals(1, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetThrows1() {
        list.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetThrows2() {
        list.add(1);
        list.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetThrows3() {
        list.add(1);
        list.remove(0);
        list.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetThrows4() {
        list.add(1);
        list.add(1);
        list.remove(1);
        list.get(1);
    }
}
