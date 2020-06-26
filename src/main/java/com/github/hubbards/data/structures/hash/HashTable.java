package com.github.hubbards.data.structures.hash;

/**
 * This interface represents a generic interface for the hash table ADT.
 *
 * @param <E> the element type of this hash table
 *
 * @author Spencer Hubbard
 */
public interface HashTable<E> {
    /**
     * Returns the number of elements in this hash table.
     *
     * @return the number of elements in this hash table
     */
    int size();

    /**
     * Checks if this hash table is empty.
     *
     * @return <code>true</code> if this hash table is empty, otherwise
     * <code>false</code>
     */
    boolean isEmpty();

    /**
     * Checks if a given value is contained in this hash table.
     *
     * @param value the value to check for
     *
     * @return <code>true</code> if the given value belongs to this hash table,
     * otherwise <code>false</code>
     */
    boolean contains(E value);

    /**
     * Inserts a given value into this hash table if this hash table does not
     * already contain the given value. The hash table is rehashed if the ratio
     * of the size of the hash table to the length of the backing array is more
     * than three quarters. The ratio is called the load factor and is sometimes
     * denoted by the lower-case Greek letter lambda.
     *
     * @param value the value to insert
     */
    void insert(E value);

    /**
     * Removes a given value from this hash table if this hash table contains
     * the given value.
     *
     * @param value the value to remove
     */
    void remove(E value);
}
