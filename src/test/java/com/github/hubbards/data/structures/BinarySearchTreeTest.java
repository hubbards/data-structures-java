package com.github.hubbards.data.structures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TODO: document
 */
public class BinarySearchTreeTest {
    @Test
    public void testContains1() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

        assertFalse(tree.contains(1));
    }

    @Test
    public void testContains2() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);

        assertTrue(tree.contains(1));
        assertFalse(tree.contains(2));
    }

    @Test
    public void testContains3() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(2);

        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertFalse(tree.contains(3));
    }

    @Test
    public void testContains4() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.remove(1);
        tree.insert(2);

        assertFalse(tree.contains(1));
        assertTrue(tree.contains(2));
    }

    @Test
    public void testContains5() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.remove(1);

        assertFalse(tree.contains(1));
        assertTrue(tree.contains(2));
    }

    @Test
    public void testFindMin1() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(2);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMin2() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(2);
        tree.insert(1);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMin3() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMin4() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.remove(2);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMin5() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.remove(1);

        assertEquals(2, (int) tree.findMin());
    }

    @Test
    public void testFindMax1() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(2);
        tree.insert(1);

        assertEquals(2, (int) tree.findMax());
    }

    @Test
    public void testFindMax2() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(2);

        assertEquals(2, (int) tree.findMax());
    }

    @Test
    public void testFindMax3() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);

        assertEquals(3, (int) tree.findMax());
    }

    @Test
    public void testFindMax4() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.remove(2);

        assertEquals(3, (int) tree.findMax());
    }

    @Test
    public void testFindMax5() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.remove(3);

        assertEquals(2, (int) tree.findMax());
    }
}
