package com.github.hubbards.data.structures;

import java.util.Arrays;

/**
 * This class represents a generic circular array implementation of the queue
 * ADT.
 *
 * @author Spencer Hubbard
 */
public class ArrayQueue<E> implements Queue<E> {
    public static final int DEFAULT_CAPACITY = 100;

    // circular array for queue
    private E[] elementData;
    // index of front of queue
    private int front;
    // index of back of queue
    private int back;

    /**
     * Constructs an empty queue with default capacity.
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty queue with a given capacity. See item #26 in
     * Effective Java, 2nd edition.
     *
     * @param capacity the given capacity
     *
     * @throws IllegalArgumentException if capacity is nonpositive
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = (E[]) new Object[capacity];
        front = 0;
        back = -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        String s = "[" + elementData[front % elementData.length];
        for (int i = 1; i < size(); i++) {
            s += ", " + elementData[(front + i) % elementData.length];
        }
        s += "]";
        return s;
    }

    @Override
    public boolean isEmpty() {
        return back == front - 1;
    }

    /**
     * Returns the number of elements in this array queue.
     *
     * @return the number of elements in this array queue
     */
    public int size() {
        return back - front + 1;
    }

    @Override
    public void enqueue(E value) {
        ensureCapacity(size() + 1);
        back++;
        elementData[back % elementData.length] = value;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new UnderflowException("empty queue");
        }
        E result = elementData[front % elementData.length];
        front++;
        return result;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new UnderflowException("empty queue");
        }
        return elementData[front % elementData.length];
    }

    /**
     * Increases the capacity of this queue if a given capacity is greater than
     * the current capacity.
     *
     * @param capacity the given capacity
     */
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = 2 * elementData.length + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            // block copy operation
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }
}
