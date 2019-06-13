package com.github.hubbards.data.structures;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * This class is a simple test suite for {@link BinaryTree}.
 *
 * @author Spencer Hubbard
 */
public class BinaryTreeTest {
    @Test
    public void testIsEmpty1() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();

        assertTrue(tree.isEmpty());
    }

    @Test
    public void testIsEmpty2() {
        Integer[] values = { 1 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        assertFalse(tree.isEmpty());
    }

    @Test
    public void testCountLevels1() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();

        assertEquals(0, tree.countLevels());
    }

    @Test
    public void testCountLevels2() {
        Integer[] values = { 1, 2, 3 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        assertEquals(2, tree.countLevels());
    }

    @Test
    public void testCountLevels3() {
        Integer[] values = { 1, 2, 3, 4 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        assertEquals(3, tree.countLevels());
    }

    @Test
    public void testCountLeaves1() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();

        assertEquals(0, tree.countLevels());
    }

    @Test
    public void testCountLeaves2() {
        Integer[] values = { 1 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        assertEquals(1, tree.countLeaves());
    }

    @Test
    public void testCountLeaves3() {
        Integer[] values = { 1, 2, 3 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        assertEquals(2, tree.countLeaves());
    }

    @Test
    public void testCountLeaves4() {
        Integer[] values = { 1, 2, 3, 4, 5 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        assertEquals(3, tree.countLeaves());
    }

    @Test
    public void testPreOrder1() {
        Integer[] values = { 1, 2, 3 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        List<Integer> list = tree.preOrder();

        assertEquals(3, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
    }

    @Test
    public void testPreOrder2() {
        Integer[] values = { 1, 2, 3, 4 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        List<Integer> list = tree.preOrder();

        assertEquals(4, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(4, (int) list.get(2));
        assertEquals(3, (int) list.get(3));
    }

    @Test
    public void testInOrder1() {
        Integer[] values = { 1, 2, 3 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        List<Integer> list = tree.inOrder();

        assertEquals(3, list.size());
        assertEquals(2, (int) list.get(0));
        assertEquals(1, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
    }

    @Test
    public void testInOrder2() {
        Integer[] values = { 1, 2, 3, 4 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        List<Integer> list = tree.inOrder();

        assertEquals(4, list.size());
        assertEquals(4, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(1, (int) list.get(2));
        assertEquals(3, (int) list.get(3));
    }

    @Test
    public void testPostOrder1() {
        Integer[] values = { 1, 2, 3 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        List<Integer> list = tree.postOrder();

        assertEquals(3, list.size());
        assertEquals(2, (int) list.get(0));
        assertEquals(3, (int) list.get(1));
        assertEquals(1, (int) list.get(2));
    }

    @Test
    public void testPostOrder2() {
        Integer[] values = { 1, 2, 3, 4 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        List<Integer> list = tree.postOrder();

        assertEquals(4, list.size());
        assertEquals(4, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(1, (int) list.get(3));
    }

    @Test
    public void testLevelOrder1() {
        Integer[] values = { 1, 2, 3 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        List<Integer> list = tree.levelOrder();

        assertEquals(3, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
    }

    @Test
    public void testLevelOrder2() {
        Integer[] values = { 1, 2, 3, 4 };

        BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

        List<Integer> list = tree.levelOrder();

        assertEquals(4, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
    }
}
