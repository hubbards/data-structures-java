package com.github.hubbards.data.structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

/**
 * <p>
 * This class represents a generic implementation of a binary tree. A binary
 * tree is either empty or a root node with left and right subtrees.
 * </p>
 *
 * <p>
 * A root node is called the parent of the root nodes of its left and right
 * subtrees. The root node of a subtree is called a child of its parent node.
 * If the subtrees of a root node are empty, then the node is called a leaf,
 * otherwise it is called a branch.
 * </p>
 *
 * <p>
 * The depth of a node in a tree is the length of the path from the root of the
 * tree to the node. The height of a tree is the length of the longest path
 * from the root to a leaf node or negative one if the tree is empty. The
 * number of levels in a tree is one less than the height of the tree. The
 * level of a node in a tree is one more than the depth of the node in the
 * tree.
 * </p>
 *
 * @param <E> the element type of this tree
 *
 * @author Spencer Hubbard
 */
public class BinaryTree<E> {
    // root node of tree
    protected TreeNode<E> root;

    /**
     * Constructs an empty tree.
     */
    public BinaryTree() {
        clear();
    }

    /**
     * Constructs a tree with a given collection of values.
     *
     * @param values the given collection of values
     */
    public BinaryTree(Collection<E> values) {
        root = buildTree(values.iterator());
    }

    /*
     * Helper method for constructing a tree.
     */
    private TreeNode<E> buildTree(Iterator<E> itr) {
        if (itr.hasNext()) {
            return new TreeNode<E>(itr.next(), buildTree(itr), buildTree(itr));
        } else {
            return null;
        }
    }

    /**
     * Removes all elements from this tree.
     */
    public void clear() {
        root = null;
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
    private int countLevels(TreeNode<E> node) {
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
    private int countLeaves(TreeNode<E> node) {
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
     * Prints the elements in this tree using a pre-order traversal.
     */
    public void printPreOrder() {
        System.out.print("preorder:");
        printPreOrder(root);
        System.out.println();
    }

    /*
     * Helper method for printing preorder traversal of tree.
     */
    private void printPreOrder(TreeNode<E> node) {
        if (node != null) {
            System.out.print(" " + node.data);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    /**
     * Prints the elements in this tree using an in-order traversal.
     */
    public void printInOrder() {
        System.out.print("inorder:");
        printInOrder(root);
        System.out.println();
    }

    /*
     * Helper method for printing in-order traversal of tree.
     */
    private void printInOrder(TreeNode<E> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(" " + node.data);
            printInOrder(node.right);
        }
    }

    /**
     * Prints the elements in this tree using a post-order traversal.
     */
    public void printPostOrder() {
        System.out.print("postorder:");
        printPostOrder(root);
        System.out.println();
    }

    /*
     * Helper method for printing post-order traversal of tree.
     */
    private void printPostOrder(TreeNode<E> node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    /**
     * Prints the elements in this tree, one per line, following an in-order
     * traversal and using indentation to indicate depth; prints right-to-left
     * so that the output looks correct when rotated by ninety degrees
     * counter-clockwise.
     */
    public void printSideways() {
        printSideways(root, 0);
    }

    private void printSideways(TreeNode<E> node, int level) {
        if (node != null) {
            printSideways(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(node.data);
            printSideways(node.left, level + 1);
        }
    }

    /**
     * Prints elements in this tree using level-order traversal.
     */
    public void printLevelOrder() {
        Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
        // add node at level 1
        if (root != null) {
            queue.add(root);
        }
        // level order traversal
        while (!queue.isEmpty()) {
            // nodes in queue at same level
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<E> node = queue.remove();
                // print node at current level
                System.out.print(node.data + " ");
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
        System.out.println();
    }

    /*
     * This inner class represents a node in a (binary) tree.
     */
    protected class TreeNode<E> {
        public E data;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E data) {
            this(data, null, null);
        }

        public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
