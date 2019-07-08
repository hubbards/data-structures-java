package com.github.hubbards.data.structures;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * This class is a simple test suite for {@link AVLTree}.
 *
 * @author Spencer Hubbard
 */
public class AVLTreeTest {
    @Test
    public void testFindMin1() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(1);
        tree.insert(2);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMin2() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(2);
        tree.insert(1);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMin3() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMin4() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMin5() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMin6() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMin7() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMin8() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        assertEquals(1, (int) tree.findMin());
    }

    @Test
    public void testFindMax1() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(2);
        tree.insert(1);

        assertEquals(2, (int) tree.findMax());
    }

    @Test
    public void testFindMax2() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(1);
        tree.insert(2);

        assertEquals(2, (int) tree.findMax());
    }

    @Test
    public void testFindMax3() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        assertEquals(3, (int) tree.findMax());
    }

    @Test
    public void testFindMax4() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);

        assertEquals(3, (int) tree.findMax());
    }

    @Test
    public void testFindMax5() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);

        assertEquals(3, (int) tree.findMax());
    }

    @Test
    public void testFindMax6() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);

        assertEquals(3, (int) tree.findMax());
    }

    @Test
    public void testFindMax7() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);

        assertEquals(3, (int) tree.findMax());
    }

    @Test
    public void testFindMax8() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        assertEquals(3, (int) tree.findMax());
    }
}
