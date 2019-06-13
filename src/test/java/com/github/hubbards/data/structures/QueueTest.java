package com.github.hubbards.data.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class is a simple test suite for {@link Queue}.
 *
 * @author Spencer Hubbard
 */
public abstract class QueueTest {
    private Queue<Integer> queue;

    protected abstract Queue<Integer> createQueue();

    @Before
    public void setUp() {
        queue = createQueue();
    }

    @Test
    public void testIsEmpty1() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty2() {
        queue.enqueue(1);

        assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsEmpty3() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();

        assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsEmpty4() {
        queue.enqueue(1);
        queue.dequeue();

        assertTrue(queue.isEmpty());
    }

    @Test(expected = UnderflowException.class)
    public void testDequeue1() {
        queue.dequeue();
    }

    @Test(expected = UnderflowException.class)
    public void testDequeue2() {
        queue.enqueue(1);
        queue.dequeue();
        queue.dequeue();
    }

    @Test
    public void testDequeue3() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, (int) queue.dequeue());
        assertEquals(2, (int) queue.dequeue());
        assertEquals(3, (int) queue.dequeue());
    }

    @Test
    public void testDequeue4() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, (int) queue.dequeue());

        queue.enqueue(3);

        assertEquals(2, (int) queue.dequeue());
        assertEquals(3, (int) queue.dequeue());
    }

    @Test(expected = UnderflowException.class)
    public void testPeek1() {
        queue.peek();
    }

    @Test(expected = UnderflowException.class)
    public void testPeek2() {
        queue.enqueue(1);
        queue.dequeue();
        queue.peek();
    }

    @Test
    public void testPeek3() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, (int) queue.peek());

        queue.enqueue(3);

        assertEquals(1, (int) queue.peek());
    }
}
