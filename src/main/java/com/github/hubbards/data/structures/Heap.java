package com.github.hubbards.data.structures;

/**
 * This class represents a generic binary (min) heap implementation of the
 * priority queue ADT. A binary heap is a binary tree of key-value pairs with
 * the following properties:
 * <dl>
 * <dt>structure property</dt>
 * <dd>the tree is a <em>complete</em> binary tree, i.e., each level other than
 * the last level is full and the last level is filled left-to-right.</dd>
 * <dt>heap-order property</dt>
 * <dd>the key of the root node is no greater than then key of any descendant
 * node.</dd>
 * </dl>
 * 
 * @author Spencer Hubbard
 *
 * @param <E> the element type of this heap
 */
public class Heap<E extends Comparable<E>> {
    private static final int DEFAULT_CAPACITY = 10;

    // elements stored in heap
    private E[] array;
    // number of elements stored in heap
    private int size;

    /**
    * Constructs a heap with the default capacity.
    */
    public Heap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a heap with a given capacity. See item #26 in Effective Java,
     * 2nd edition.
     *
     * @param capacity the given capacity
     *
     * @throws IllegalArgumentException if the given capacity is negative
     */
    @SuppressWarnings("unchecked")
    public Heap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        array = (E[]) new Comparable[capacity];
        size = 0;
    }

    /**
     * Inserts a given element into this heap.
     * 
     * @param element the element to insert
     */
    public void insert(E element) {
        if (size == array.length - 1) {
            enlargeArray(2 * array.length + 1);
        }
        // insert element into heap
        size++;
        array[size] = element;
        // percolate up
        percolateUp();
    }

    /**
     * Returns but does not remove the minimum element in this heap.
     * 
     * @return the minimum element in this heap
     * 
     * @throws UnderflowException if this heap is empty
     */
    public E findMin() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return array[1];
    }

    /**
     * Returns and removes the minimum element in this heap.
     * 
     * @return the minimum element in this heap
     * 
     * @throws UnderflowException if this heap is empty
     */
    public E deleteMin() {
        // find minimum element in heap
        E result = findMin();
        // delete minimum element from heap
        array[1] = array[size];
        array[size] = null; // remove reference for garbage collector
        size--;
        // percolate down to restore heap-order property
        percolateDown();
        // return minimum element
        return result;
    }

    /**
     * Checks if this heap is empty.
     * 
     * @return <code>true</code> if this heap is empty, otherwise
     * <code>false</code>
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            String result = "[" + array[1];
            for (int i = 2; i <= size; i++) {
                result += ", " + array[i];
            }
            result += "]";
            return result;
        }
    }

    /*
     * Restores heap-order property after insertion.
     */
    private void percolateUp() {
        // start hole at last leaf
        int i = size;
        while (hasParent(i) && array[parentIndex(i)].compareTo(array[i]) > 0) {
            // parent greater than hole
            swap(i, parentIndex(i));
            // percolate hole up
            i = parentIndex(i);
        }
    }

    /*
     * Restores heap-order property after deletion.
     */
    private void percolateDown() {
        // start hole at root
        int i = 1;
        while (hasLeft(i)) {
            // find smallest child
            int j = leftIndex(i);
            if (hasRight(i) && array[j].compareTo(array[rightIndex(i)]) > 0) {
                // left child greater than right child
                j = rightIndex(i);
            }
            if (array[i].compareTo(array[j]) > 0) {
                // hole greater than smaller child
                swap(i, j);
                // percolate hole down
                i = j;
            } else {
                // hole less than or equal to smallest child
                break;
            }
        }
    }

    /*
     * Returns the index of the parent of the node at a given index. Suppose
     * that i and j are indices. Then j is the index of the parent of the node
     * at index i if and only if j = floor(i / 2).
     */
    private int parentIndex(int i) {
        return i / 2;
    }

    /*
     * Returns the index of the left child of the node at a given index. Suppose
     * that i and j are indices. Then j is the index of the left child of the
     * node at index i if and only if j = 2 * i.
     */
    private int leftIndex(int i) {
        return 2 * i;
    }

    /*
     * Returns the index of the right child of the node at a given index.
     * Suppose that i and j are indices. Then j is the index of the right child
     * of the node at index i if and only if j = 2 * i + 1.
     */
    private int rightIndex(int i) {
        return 2 * i + 1;
    }

    /*
     * Checks if the node at a given index has a parent. Suppose that i is an
     * index. Then i has a parent if and only if i > 1.
     */
    private boolean hasParent(int i) {
        return i > 1;
    }

    /*
     * Checks if the node at a given index has a left child. Suppose that i is
     * an index. Then the node at index i has a left child if and only if
     * 2 * i <= size.
     */
    private boolean hasLeft(int i) {
        return 2 * i <= size;
    }

    /*
     * Checks if the node at the given index has a right child. Suppose that i
     * is an index. Then the node at index i has a right child if and only if
     * 2 * i + 1 <= size.
     */
    private boolean hasRight(int i) {
        return 2 * i + 1 <= size;
    }

    /*
     * Swaps the nodes at given indices.
     */
    private void swap(int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*
     * Increases the capacity of this heap to a given capacity.
     */
    @SuppressWarnings("unchecked")
    private void enlargeArray(int capacity) {
        E[] temp = array;
        array = (E[]) new Comparable[capacity];
        for (int i = 1; i <= size; i++) {
            array[i] = temp[i];
        }
        // TODO: rewrite method using block copy operation
        // array = Arrays.copyOf(array, capacity); // block copy operation
    }
}
