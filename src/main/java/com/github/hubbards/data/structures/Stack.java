package com.github.hubbards.data.structures;

/**
 * This class represents a generic interface for the (LIFO or FILO) stack ADT.
 *
 * @param <E> the element type of this stack
 *
 * @author Spencer Hubbard
 */
public interface Stack<E> {
    /**
     * Checks if this stack is empty.
     *
     * @return <code>true</code> if this queue is empty, otherwise
     * <code>false</code>
     */
    boolean isEmpty();

    /**
     * Adds a given value to the top of this stack.
     *
     * @param value the value to add
     */
    void push(E value);

    /**
     * Returns and removes the value at the top of this stack.
     *
     * @return the value at the top of this stack
     *
     * @throws UnderflowException if this stack is empty
     */
    E pop();
}
