package com.github.hubbards.data.structures;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * Unit tests for stack ADT.
 *
 * @see Stack
 *
 * @author Spencer Hubbard
 */
public abstract class StackTest {
    private Stack<Integer> stack;

    protected abstract Stack<Integer> createStack();

    @Before
    public void setUp() {
        stack = createStack();
    }

    @Test
    public void testIsEmpty1() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty2() {
        stack.push(1);

        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsEmpty3() {
        stack.push(1);
        stack.push(2);
        stack.pop();

        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsEmpty4() {
        stack.push(1);
        stack.pop();

        assertTrue(stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testPop1() {
        stack.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void testPop2() {
        stack.push(1);
        stack.pop();
        stack.pop();
    }

    @Test
    public void testPop3() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, (int) stack.pop());
        assertEquals(2, (int) stack.pop());
        assertEquals(1, (int) stack.pop());
    }

    @Test
    public void testPop4() {
        stack.push(1);
        stack.push(2);

        assertEquals(2, (int) stack.pop());

        stack.push(3);

        assertEquals(3, (int) stack.pop());
        assertEquals(1, (int) stack.pop());
    }
}
