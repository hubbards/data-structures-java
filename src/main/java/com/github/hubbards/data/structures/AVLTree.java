package com.github.hubbards.data.structures;

/**
 * This class represents an AVL tree implementation of the binary search tree
 * ADT. An AVL tree is a binary search tree with the property that for a
 * nonempty tree, the heights of the left and right subtrees differ by at most
 * one. The height of an empty tree is defined to be negative one.
 *
 * @param <E> the element type of this tree
 *
 * @author Spencer Hubbard
 */
public class AVLTree<E extends Comparable<E>> extends BinarySearchTree<E> {
    private AVLTreeNode<E> root;

    public AVLTree() {
        clear();
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public void insert(E value) {
        root = insert(root, value);
    }

    private AVLTreeNode<E> insert(AVLTreeNode<E> node, E value) {
        if (node == null) {
            // add at root
            return new AVLTreeNode<E>(value);
        }
        int temp = value.compareTo(node.data);
        if (temp < 0) {
            // insert into left subtree
            node.left = insert(node.left, value);
            // check balance condition
            if (height(node.left) - height(node.right) == 2) {
                // restore balance condition
                if (value.compareTo(node.left.data) < 0) {
                    // case 1: insertion into left subtree of left child
                    singleL(node);
                } else {
                    // case 2: insertion into right subtree of left child
                    doubleLR(node);
                }
            }
        } else if (temp > 0) {
            // insert into right subtree
            node.right = insert(node.right, value);
            // check balance condition
            if (height(node.right) - height(node.left) == 2) {
                // restore balance condition
                if (value.compareTo(node.right.data) < 0) {
                    // case 3: insertion into left subtree of right child
                    doubleRL(node);
                } else {
                    // case 4: insertion into right subtree of right child
                    singleR(node);
                }
            }
        }
        // update height
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        // return root
        return node;
    }

    @Override
    public void remove(E value) {
        if (root == null) {
            throw new UnderflowException("empty tree");
        }
        root = delete(root, value);
    }

    private AVLTreeNode<E> delete(AVLTreeNode<E> node, E value) {
        // TODO: implement
        throw new RuntimeException("method not implemented");
    }

    /*
     * Perform a single rotation of a given node with its left child. Suppose
     * that N1 is the given node and N2 is the left child. Suppose further that
     * R1 is the right subtree of N1 and L2 and R2 are the left and right
     * subtrees of N2 respectively. Then a single rotation of N1 with
     * N2 would restore the balance condition of the tree if L2 is two levels
     * deeper than R1.
     *
     * Before single rotation of N1 with N2:
     *          N1
     *    N2          R1
     * L2    R2
     *
     * After single rotation of N1 with N2:
     *       N2
     * L2          N1
     *          R2    R1
     */
    private AVLTreeNode<E> singleL(AVLTreeNode<E> node1) {
        assert node1 != null && node1.left != null;
        // single rotation with left child
        AVLTreeNode<E> node2 = node1.left;
        node1.left = node2.right;
        node2.right = node1;
        // update height
        node1.height = Math.max(height(node1.left), height(node1.right)) + 1;
        node2.height = Math.max(height(node2.left), node1.height) + 1;
        // return root
        return node2;
    }

    /*
     * Perform a single rotation of a given node with its right child. Suppose
     * that N1 is the given node and N2 is the right child of N1. Suppose
     * further that L1 is the left subtree of N1 and L2 and R2 are the left and
     * right subtrees of N2, respectively. Then a single rotation of N1 with
     * N2 would restore the balance condition of the tree if L2 is two levels
     * deeper than L1.
     *
     * Before single rotation of N1 with N2:
     *       N1
     * L1          N2
     *          L2    R2
     *
     * After single rotation of N1 with N2:
     *          N2
     *    N1          R2
     * L1    L2
     */
    private AVLTreeNode<E> singleR(AVLTreeNode<E> node1) {
        assert node1 != null && node1.right != null;
        // single rotation with right child
        AVLTreeNode<E> node2 = node1.right;
        node1.right = node2.left;
        node2.left = node1;
        // update height
        node1.height = Math.max(height(node1.left), height(node1.right)) + 1;
        node2.height = Math.max(node1.height, height(node2.right)) + 1;
        // return root
        return node2;
    }

    /*
     * Perform a double rotation of a given node with its left child and the
     * right child of the left child. Suppose that N1 is the given node, N2 is
     * the left child of N1, and N3 is the right child of N2. Suppose further
     * that R1 is the left subtree of N1, L2 is the left subtree of N2, and L3
     * and R3 are the left and right subtrees of N3, respectively. Then a
     * double rotation with N1, N2, and N3 would restore the balance condition
     * of the tree if L3 or R3 is two levels deeper than R1.
     *
     * Before double rotation of N1, N2, and N3:
     *                 N1
     *     N2                N2
     * L2        N3
     *        L3    R3
     *
     * After double rotation of N1, N2, and N3:
     *          N3
     *    N1          N2
     * L1    L3    R3    R2
     */
    private AVLTreeNode<E> doubleLR(AVLTreeNode<E> node1) {
        assert node1 != null && node1.left != null && node1.left.right != null;
        node1.left = singleR(node1.left);
        return singleL(node1);
    }

    /*
     * Perform a double rotation of a given node with its right child and the
     * left child of the right child. Suppose that N1 is the given node, N2 is
     * the right child of N1, and N3 is the left child of N2. Suppose further
     * that L1 is the left subtree of N1, R2 is the right subtree of N2, and
     * L3 and R3 are the left and right subtrees of N3, respectively. Then a
     * double rotation with N1, N2, and N3 would restore the balance condition
     * of the tree if L3 or R3 is two levels deeper than L1.
     *
     * Before double rotation of N1, N2, and N3:
     *             N1
     * L1                      N2
     *                   N3          R2
     *                L3    R3
     *
     * After double rotation of N1, N2, and N3:
     *          N3
     *    N1          N2
     * L1    L3    R3    R2
     */
    private AVLTreeNode<E> doubleRL(AVLTreeNode<E> node1) {
        assert node1 != null && node1.right != null && node1.right.left != null;
        node1.right = singleR(node1.right);
        return singleL(node1);
    }

    /*
     * Returns the height of a given subtree.
     */
    private int height(AVLTreeNode<E> node) {
        return node == null ? -1 : node.height;
    }

    /*
     * This inner class represents a node in a tree.
     */
    private static class AVLTreeNode<E> extends TreeNode<E> {
        AVLTreeNode<E> left;
        AVLTreeNode<E> right;
        int height;

        AVLTreeNode(E value) {
            super(value);
            left = null;
            right = null;
            height = 0;
        }
    }
}
