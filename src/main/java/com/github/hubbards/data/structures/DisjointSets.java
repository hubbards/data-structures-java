package com.github.hubbards.data.structures;

/**
 * <p>
 * This class represents an implementation of the disjoint sets (or union-find)
 * ADT using weighted union (union-by-rank) and path compression.
 * </p>
 * 
 * <p>
 * The worst-case time complexity for any sequence of <em>m = Omega(n)</em>
 * union and find operations on <em>n</em> elements (with weighted union and
 * path compression) is <em>Theta(m * alpha(m, n))</em> and
 * <em>O(m * log*(n))</em> where <em>alpha</em> denotes the inverse Ackermann
 * function. For each integer <em>n</em> with <em>n > 1</em>, define
 * <em>log*(n)</em> as the smallest positive integer <em>i</em> such that the
 * composition of <em>log</em> with itself <em>i</em> times is less than or
 * equal to one. For example, <em>log*(65536) = 4</em> because
 * <em>65536 = 2^16 = 2^(2^(2^2))</em> and so
 * <em>log(log(log(log(25536)))) = 1</em>. Then
 * <em>alpha(m, n) = O(log*(n))</em>.
 * </p>
 * 
 * @author Spencer Hubbard
 */
public class DisjointSets {
    // forest of up trees
    private int[] array;

    /**
     * Constructs disjoint sets with a given number of elements.
     * 
     * @param numElements the given number of elements
     * 
     * @throws IllegalArgumentException if given number of elements is not
     * positive
     */
    public DisjointSets(int numElements) {
        if (numElements < 1) {
            throw new IllegalArgumentException();
        }
        // initialize rank of each set to 1
        array = new int[numElements];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
    }

    /**
     * Forms the union of two given sets. Union-by-rank means make the tree with
     * smaller rank a subtree of the tree with larger rank. Union-by-rank
     * becomes union-by-height without path compression.
     * 
     * @param root1 the index of the root element of the first set
     * 
     * @param root2 the index of the root element of the second set
     * 
     * @throws IndexOutOfBoundsException if the given indices are out of bounds
     *
     * @throws IllegalArgumentException if the given indices are equal or not
     * root elements
     */
    public void union(int root1, int root2) {
        // check preconditions
        checkIndex(root1);
        checkIndex(root2);
        if (root1 == root2 || array[root1] >= 0 || array[root2] >= 0) {
            throw new IllegalArgumentException();
        }
        // form union
        if (array[root2] < array[root1]) {
            // rank of second tree is greater than rank of first
            array[root1] = root2;
        } else {
            // rank of first tree is greater than or equal to rank of second
            if (array[root1] == array[root2]) {
                // rank of first tree is equal to rank of second
                array[root1]--;
            }
            array[root2] = root1;
        }
    }

    /**
     * Returns the index of the root element of the set containing the element
     * at a given index.
     * 
     * @param index the given index
     * 
     * @return the index of the root element of the set containing the element
     * at the given index.
     * 
     * @throws IndexOutOfBoundsException if the given index is out of bounds
     */
    public int find(int index) {
        checkIndex(index);
        // find root
        int root = index;
        while (array[root] >= 0) {
            root = array[root];
        }
        // path compression
        while (index != root) {
            // make root parent of next node on path
            int temp = array[index];
            array[index] = root;
            index = temp;
        }
        return root;
    }

    /*
     * Throws an exception if a given index is illegal.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
}
