package com.github.hubbards.data.structures;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * This class represents a generic implementation of a binary tree. A binary
 * tree is either empty or a root node with left and right subtrees.
 * </p>
 *
 * <p>
 * A root node is called the parent of the root nodes of its left and right
 * subtrees. The root node of a subtree is called a child of its parent node. If
 * the subtrees of a root node are empty, then the node is called a leaf,
 * otherwise it is called a branch.
 * </p>
 *
 * <p>
 * The depth of a node in a tree is the length of the path from the root of the
 * tree to the node. The height of a tree is the length of the longest path from
 * the root to a leaf node or negative one if the tree is empty. The number of
 * levels in a tree is one less than the height of the tree. The level of a node
 * in a tree is one more than the depth of the node in the tree.
 * </p>
 *
 * @param <E> the element type of this tree
 *
 * @author Spencer Hubbard
 */
public class BinaryTree<E> {
    // root node of tree
    private Node<E> root;

    /**
     * Constructs an empty tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Constructs a tree in level-order from a given array of values.
     *
     * @param values the given array of values
     */
    public BinaryTree(E[] values) {
        root = buildTree(values, 0);
    }

    /*
     * Helper method for constructing a tree in level-order.
     */
    private Node<E> buildTree(E[] values, int i) {
        if (i < values.length) {
            return new Node<E>(
                    values[i],
                    buildTree(values, 2 * i + 1),
                    buildTree(values, 2 * i + 2)
            );
        } else {
            return null;
        }
    }

    /**
     * Checks if this tree is empty.
     *
     * @return <code>true</code> if this tree is empty, otherwise
     * <code>false</code>
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Counts the number of levels (or one less than height) of this tree.
     *
     * @return the number of levels in this tree
     */
    public int countLevels() {
        return countLevels(root);
    }

    /*
     * Helper method for counting levels.
     */
    private int countLevels(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(countLevels(node.left), countLevels(node.right));
        }
    }

    /**
     * Counts the number of leaves in this tree.
     *
     * @return the number of leaves in this tree
     */
    public int countLeaves() {
        return countLeaves(root);
    }

    /*
     * Helper method for counting leaves.
     */
    private int countLeaves(Node<E> node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            // leaf node
            return 1;
        } else {
            // branch node
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }

    /**
     * Returns a pre-order traversal of elements in this tree.
     *
     * @return pre-order traversal of elements in this tree
     */
    public List<E> preOrder() {
        return preOrder(root);
    }

    /*
     * Helper method for pre-order traversal.
     */
    private List<E> preOrder(Node<E> node) {
        List<E> list = new LinkedList<E>();
        if (node != null) {
            list.add(node.data);
            list.addAll(preOrder(node.left));
            list.addAll(preOrder(node.right));
        }
        return list;
    }

    /**
     * Returns an in-order traversal of elements in this tree.
     */
    public List<E> inOrder() {
        return inOrder(root);
    }

    /*
     * Helper method for in-order traversal of tree.
     */
    private List<E> inOrder(Node<E> node) {
        List<E> list = new LinkedList<E>();
        if (node != null) {
            list.addAll(inOrder(node.left));
            list.add(node.data);
            list.addAll(inOrder(node.right));
        }
        return list;
    }

    /**
     * Returns a post-order traversal of elements in this tree.
     */
    public List<E> postOrder() {
        return postOrder(root);
    }

    /*
     * Helper method for post-order traversal of tree.
     */
    private List<E> postOrder(Node<E> node) {
        List<E> list = new LinkedList<E>();
        if (node != null) {
            list.addAll(postOrder(node.left));
            list.addAll(postOrder(node.right));
            list.add(node.data);
        }
        return list;
    }

    /**
     * Returns a level-order traversal of elements in this tree.
     */
    public List<E> levelOrder() {
        List<E> list = new LinkedList<E>();
        Queue<Node<E>> queue = new LinkedList<Node<E>>();
        // add node at level 1
        if (root != null) {
            queue.add(root);
        }
        // level order traversal
        while (!queue.isEmpty()) {
            // nodes in queue at same level
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node<E> node = queue.remove();
                // traverse node at current level
                list.add(node.data);
                // add left node at next level
                if (node.left != null) {
                    queue.add(node.left);
                }
                // add right node at next level
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return list;
    }

    /*
     * This inner class represents a node in a (binary) tree.
     */
    private static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this(data, null, null);
        }

        Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
