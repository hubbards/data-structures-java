package com.github.hubbards.data.structures;

/**
 * This interface represents a generic interface for the (FIFO or LILO) queue
 * ADT.
 * 
 * @param <E> the element type of this queue
 *
 * @author Spencer Hubbard
 */
public interface Queue<E> {
    /**
     * Checks if this queue is empty.
     * 
     * @return <code>true</code> if this queue is empty, otherwise
     * <code>false</code>
     */
    public boolean isEmpty();

    /**
     * Adds a given value to the back of this queue.
     * 
     * @param value the value to add
     */
    public void enqueue(E value);

    /**
     * Returns and removes the value at the front of this queue.
     * 
     * @return the value at the front of this queue
     * 
     * @throws UnderflowException if this queue is empty
     */
    public E dequeue();

    /**
     * Returns but do not removes the value at the front of this queue.
     * 
     * @return the value at the front of this queue
     * 
     * @throws UnderflowException if this queue is empty
     */
    public E peek();
}
