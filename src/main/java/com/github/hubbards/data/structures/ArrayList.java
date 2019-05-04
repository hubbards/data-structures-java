package com.github.hubbards.data.structures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a generic array implementation of the list ADT.
 * 
 * @author Spencer Hubbard
 */
public class ArrayList<E> extends AbstractList<E> {
    public static final int DEFAULT_CAPACITY = 100;

    // values stored in list
    private E[] elementData;
    // number of elements in list
    private int size;

    /**
     * Constructs an empty list with default capacity.
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty list with a given capacity. See item #26 in Effective
     * Java, 2nd edition.
     * 
     * @param capacity the given capacity
     * 
     * @throws IllegalArgumentException if capacity is negative
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        if (!isEmpty()) {
            builder.append(elementData[0]);
            for (int i = 1; i < size; i++) {
                builder.append(", ");
                builder.append(elementData[i]);
            }
        }
        builder.append(']');
        return builder.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(E value) {
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ensureCapacity(size + 1);
        for (int i = size; i >= index + 1; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    @Override
    public void addAll(List<E> other) {
        ensureCapacity(size + other.size());
        for (E value : other) {
            add(value);
        }
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        // remove reference for garbage collection
        elementData[size - 1] = null;
        size--;
    }

    @Override
    public void set(int index, E value) {
        checkIndex(index);
        elementData[index] = value;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            // remove reference for garbage collection
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Increases the capacity of this list if a given capacity is greater than
     * the current capacity.
     * 
     * @param capacity the given capacity
     */
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            // block copy operation
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    /*
     * This inner class represents an iterator used for an array list.
     */
    private class ArrayListIterator implements Iterator<E> {
        // next element
        private int position;
        // legal state for remove
        private boolean removeOK;

        public ArrayListIterator() {
            position = 0;
            removeOK = false;
        }

        @Override
        public boolean hasNext() {
            return position < size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = elementData[position];
            position++;
            removeOK = true;
            return result;
        }

        @Override
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ArrayList.this.remove(position - 1);
            position--;
            removeOK = false;
        }
    }
}
