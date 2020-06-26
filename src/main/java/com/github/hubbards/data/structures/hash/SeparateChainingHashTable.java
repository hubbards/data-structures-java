package com.github.hubbards.data.structures.hash;

/**
 * This class represents a genaric implementation of the hash table ADT using
 * separate chaining to avoid collisions.
 *
 * @author Spencer Hubbard
 */
public class SeparateChainingHashTable<E> implements HashTable<E> {
    // default number of buckets
    public static final int DEFAULT_PRIME = 11;

    // elements in this hash table
    private Node[] buckets;
    // number of elements in this hash table
    private int size;

    /**
     * Constructs a hash table with the default number of buckets.
     */
    public SeparateChainingHashTable() {
        this(DEFAULT_PRIME);
    }

    /**
     * Constructs a hash table with some number of buckets between a given
     * number and twice the given number.
     *
     * @param n the given number
     */
    @SuppressWarnings("unchecked")
    public SeparateChainingHashTable(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException();
        }
        int p = Sieve.nextPrime(n);
        buckets = (Node[]) new SeparateChainingHashTable.Node[p];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E value) {
        int i = hash(value);
        Node current = buckets[i];
        while (current != null) {
            if (current.data.equals(value)) {
                // value at current node
                return true;
            }
            // value not at current node
            current = current.next;
        }
        // value not contained in this hash table
        return false;
    }

    @Override
    public void insert(E value) {
        // TODO: rehash if load factor is greater than 1
        // check load factor
        if (3 * buckets.length < 4 * size) {
            rehash();
        }
        // separate chaining to avoid collisions
        if (!contains(value)) {
            int i = hash(value);
            Node node = new Node(value);
            node.next = buckets[i];
            buckets[i] = node;
            size++;
        }
    }

    @Override
    public void remove(E value) {
        int i = hash(value);
        if (buckets[i] != null) {
            if (buckets[i].data.equals(value)) {
                // value at front of list
                buckets[i] = buckets[i].next;
                size--;
            } else {
                // value not at front of list
                Node current = buckets[i];
                while (current.next != null && !current.next.data.equals(value)) {
                    // value not next in list
                    current = current.next;
                }
                if (current.next != null) {
                    // value next in list
                    current.next = current.next.next;
                    size--;
                }
            }
        }
    }

    /*
     * Hash function for this hash table.
     */
    private int hash(E value) {
        int temp = value.hashCode() % buckets.length;
        if (temp < 0) {
            return temp + buckets.length;
        } else {
            return temp;
        }
    }

    /*
     * Rehash this hash table.
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        Node[] temp = buckets;
        int p = Sieve.nextPrime(2 * buckets.length);
        buckets = (Node[]) new SeparateChainingHashTable.Node[p];
        size = 0;
        for (int i = 0; i < temp.length; i++) {
            Node node = temp[i];
            while (node != null) {
                insert(node.data);
                node = node.next;
            }
        }
    }

    /**
     * Prints this hash table. Note that output is formatted "nicely" if values
     * are no more than six characters long.
     */
    public void debug() {
        System.out.println("debug output");
        System.out.println("index: data:");
        for (int i = 0; i < buckets.length; i++) {
            // print row for list of values
            System.out.printf("%-4d   ", i);
            Node node = buckets[i];
            if (node == null) {
                System.out.printf("%s\n", "null");
            } else {
                System.out.printf("%-6s", node.data);
                node = node.next;
                while (node != null) {
                    System.out.printf(" --> %-6s", node.data);
                    node = node.next;
                }
                System.out.println();
            }
        }
        System.out.println("size: " + size);
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        if (!isEmpty()) {
            // find first list
            int i = 0;
            while (buckets[i] == null) {
                i++;
            }
            // add elements in first list
            Node current = buckets[i];
            builder.append(current.data);
            while (current.next != null) {
                current = current.next;
                builder.append(", ");
                builder.append(current.data);
            }
            // find and add elements in all other lists
            for (int j = i + 1; j < buckets.length; j++) {
                current = buckets[j];
                while (current != null) {
                    builder.append(", ");
                    builder.append(current.data);
                    current = current.next;
                }
            }
        }
        builder.append(']');
        return builder.toString();
    }

    /*
     * This inner class represents a node in a singly linked list used for
     * separate chaining.
     */
    private class Node {
        private E data;
        private Node next;

        public Node(E value) {
            data = value;
            next = null;
        }
    }
}
