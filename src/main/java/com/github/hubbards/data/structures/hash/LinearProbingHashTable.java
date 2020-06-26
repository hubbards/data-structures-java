package com.github.hubbards.data.structures.hash;

/**
 * This class represents a genaric implementation of the hash table ADT using
 * linear probing to avoid collisions.
 *
 * @author Spencer Hubbard
 */
public class LinearProbingHashTable<E> implements HashTable<E> {
    // default number of buckets
    public static final int DEFAULT_PRIME = 11;

    // dummy object to indicate removed values
    private static final Object REMOVED = new Object();

    // elements in this hash table
    private Object[] buckets;
    // number of elements in this hash table
    private int size;

    /**
     * Constructs a hash table with the default number of buckets.
     */
    public LinearProbingHashTable() {
        this(DEFAULT_PRIME);
    }

    /**
     * Constructs a hash table with some number of buckets between a given
     * number and twice the given number.
     *
     * @param n the given number
     */
    public LinearProbingHashTable(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException();
        }
        int p = Sieve.nextPrime(n);
        buckets = new Object[p];
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
        while (buckets[i] != null) {
            if (buckets[i].equals(value)) {
                return true;
            }
            // collision occured
            i = (i + 1) % buckets.length;
        }
        // value is not contained in this table
        return false;
    }

    @Override
    public void insert(E value) {
        // TODO: rehash if load factor is more than 0.5
        // check load factor
        if (3 * buckets.length < 4 * size) {
            rehash();
        }
        // linear probing to avoid collisions
        int i = hash(value);
        while (buckets[i] != null && !buckets[i].equals(REMOVED) && !buckets[i].equals(value)) {
            // collision occurred
            i = (i + 1) % buckets.length;
        }
        if (buckets[i] == null || buckets[i].equals(REMOVED)) {
            buckets[i] = value;
            size++;
        }
    }

    @Override
    public void remove(E value) {
        int i = hash(value);
        while (buckets[i] != null && !buckets[i].equals(value)) {
            // collision occurred
            i = (i + 1) % buckets.length;
        }
        if (buckets[i] != null) {
            // remove value
            buckets[i] = REMOVED;
            size--;
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
        Object[] temp = buckets;
        int p = Sieve.nextPrime(2 * buckets.length);
        buckets = new Object[p];
        size = 0;
        // add all values in this hash table
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null && !temp[i].equals(REMOVED)) {
                insert((E) temp[i]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        if (!isEmpty()) {
            // find first element
            int i = 0;
            while (buckets[i] == null || buckets[i].equals(REMOVED)) {
                i++;
            }
            // add first element
            builder.append(buckets[i]);
            // find and add all other elements
            for (int j = i + 1; j < buckets.length; j++) {
                if (buckets[j] != null && !buckets[j].equals(REMOVED)) {
                    builder.append(", ");
                    builder.append(buckets[j]);
                }
            }
        }
        builder.append(']');
        return builder.toString();
    }
}
