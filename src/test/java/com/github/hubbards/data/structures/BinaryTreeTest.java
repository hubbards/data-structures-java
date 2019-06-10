package com.github.hubbards.data.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TODO: document
 */
public class BinaryTreeTest {
    private BinaryTree<Integer> tree;

    @Before
    public void setUp() {
        tree = new BinaryTree<Integer>();
    }

    @Test
    public void testIsEmpty1() {
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testIsEmpty2() {
        tree.insert(1);

        assertFalse(tree.isEmpty());
    }

    // TODO: write more unit tests
}
