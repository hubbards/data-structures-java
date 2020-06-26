package com.github.hubbards.data.structures;

/**
 * This class represents a runtime exception for operation on an empty
 * collection, e.g., list, queue, or heap.
 *
 * @author Spencer Hubbard
 */
public class UnderflowException extends RuntimeException {
    /**
     * Constructs a new underflow exception.
     */
    public UnderflowException() {
        super();
    }

    /**
     * Constructs a new underflow exception with a given message.
     *
     * @param message the given message
     */
    public UnderflowException(String message) {
        super(message);
    }
}
