package com.github.hubbards.data.structures;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * This class represents a generic doubly linked list implementation of the list
 * ADT. This class also implements the queue and stack ADTs.
 *
 * @author Spencer Hubbard
 */
public class LinkedList<E> extends AbstractList<E> implements Queue<E>, Stack<E> {
    // first dummy node
    private final Node front;
    // last dummy node
    private final Node back;
    // number of elements in list
    private int size;

    /**
     * Constructs an empty list.
     */
    public LinkedList() {
        front = new Node(null);
        back = new Node(null);
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node current = nodeAt(index);
        return current.data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        if (!isEmpty()) {
            builder.append(front.next.data);
            Node current = front.next.next;
            while (current != back) {
                builder.append(", ");
                builder.append(current.data);
                current = current.next;
            }
        }
        builder.append(']');
        return builder.toString();
    }

    @Override
    public int indexOf(E value) {
        int index = 0;
        Node current = front.next;
        while (current != back) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    @Override
    public void add(E value) {
        add(size, value);
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        Node current = nodeAt(index - 1);
        Node newNode = new Node(value, current.next, current);
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    @Override
    public void addAll(List<E> other) {
        for (E value : other) {
            add(value);
        }
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        Node current = nodeAt(index - 1);
        current.next = current.next.next;
        current.next.prev = current;
        size--;
    }

    @Override
    public void set(int index, E value) {
        checkIndex(index);
        Node current = nodeAt(index);
        current.data = value;
    }

    @Override
    public void clear() {
        front.next = back;
        back.prev = front;
        size = 0;
    }

    @Override
    public void push(E value) {
        add(0, value);
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return remove();
    }

    @Override
    public void enqueue(E value) {
        add(value);
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            throw new UnderflowException("empty queue");
        }
        return remove();
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new UnderflowException("empty queue");
        }
        return front.next.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator();
    }

    /*
     * Removes the element at the head of this list.
     */
    private E remove() {
        E value = front.next.data;
        front.next = front.next.next;
        front.next.prev = front;
        size--;
        return value;
    }

    /*
     * Returns the node at a given index, otherwise throws an exception.
     */
    private Node nodeAt(int index) {
        Node current;
        if (index < size / 2) {
            // start from front of list
            current = front;
            for (int i = 0; i <= index; i++) {
                current = current.next;
            }
        } else {
            // start from back of list
            current = back;
            for (int i = size; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    /*
     * This inner class represents a node used in a doubly linked list.
     */
    private class Node {
        // data stored in node
        public E data;
        // link to next node in list
        public Node next;
        // link to previous node in list
        public Node prev;

        /*
         * Constructs a node with given data and null links.
         */
        public Node(E data) {
            this(data, null, null);
        }

        /*
         * Constructs a node with given data and given links.
         */
        public Node(E data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /*
     * This inner class represents an iterator used for a linked list.
     */
    private class NodeIterator implements Iterator<E> {
        // next element
        private Node current;
        // legal state for remove
        private boolean removeOK;

        public NodeIterator() {
            current = front.next;
            removeOK = false;
        }

        @Override
        public boolean hasNext() {
            return current != back;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            removeOK = true;
            return result;
        }

        @Override
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            Node prev2 = current.prev.prev;
            prev2.next = current;
            current.prev = prev2;
            size--;
            removeOK = false;
        }
    }
}
