/**
 * <p>
 * This class represents a generic implementation of the binary search tree ADT
 * without balancing. A binary search tree is a binary tree where the value in
 * the root node is greater than the values in the left subtree and less than
 * the values in the right subtree.
 * </p>
 * 
 * @param <E>
 * the element type of this tree
 * 
 * @author Spencer Hubbard
 */
public class SearchTree<E extends Comparable<E>> {
    // root node
    private TreeNode<E> root;

    /**
     * Constructs an empty tree.
     */
    public SearchTree() {
        clear();
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
     * @return
     * <code>true</code> if this tree is empty, otherwise <code>false</code>
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Checks if this tree contains a given value.
     * 
     * @param value
     * the value to check for
     * 
     * @return
     * <code>true</code> if this tree contains the given value, otherwise
     * <code>false</code>
     */
    public boolean contains(E value) {
        return contains(root, value);
    }

    /*
     * Helper method for finding value.
     */
    private boolean contains(TreeNode<E> node, E value) {
        if (node == null) {
            return false;
        }
        int temp = value.compareTo(node.data);
        if (temp < 0) {
            // check left subtree
            return contains(node.left, value);
        } else if (temp > 0) {
            // check right subtree
            return contains(node.right, value);
        } else {
            // value at node
            return true;
        }
    }

    /**
     * Finds the minimum value in this tree.
     * 
     * @return
     * the minimum value in this tree
     * 
     * @throws UnderflowException
     * if this tree is empty
     */
    public E findMin() {
        if (root == null) {
            throw new UnderflowException("empty tree");
        }
        return findMin(root);
    }

    /*
     * Helper method for finding minimum value.
     */
    private E findMin(TreeNode<E> node) {
        assert node != null;
        if (node.left == null) {
            // smallest value at node
            return node.data;
        } else {
            // smallest value in left subtree
            return findMin(node.left);
        }
    }

    /**
     * Finds the maximum value in this tree.
     * 
     * @return
     * the maximum value in this tree
     * 
     * @throws UnderflowException
     * if this tree is empty
     */
    public E findMax() {
        if (root == null) {
            throw new UnderflowException("empty tree");
        }
        return findMax(root);
    }

    /*
     * Helper method for finding maximum value.
     */
    private E findMax(TreeNode<E> node) {
        assert node != null;
        if (node.right == null) {
            // largest value at node
            return node.data;
        } else {
            // largest value in right subtree
            return findMax(node.right);
        }
    }

    /**
     * Inserts a given value into this tree if it does not belong to this tree
     * already.
     * 
     * @param value
     * the value to insert
     */
    public void insert(E value) {
        root = insert(root, value);
    }

    /*
     * Helper method for inserting.
     */
    private TreeNode<E> insert(TreeNode<E> node, E value) {
        if (node == null) {
            // add at root
            return new TreeNode<E>(value);
        }
        int temp = value.compareTo(node.data);
        if (temp < 0) {
            // add to left subtree
            node.left = insert(node.left, value);
        } else if (temp > 0) {
            // add to right subtree
            node.right = insert(node.right, value);
        }
        return node;
    }

    /**
     * Removes a given value from this tree if it belongs to this tree.
     * 
     * @param value
     * the value to remove
     * 
     * @throws UnderflowException
     * if this tree is empty
     */
    public void remove(E value) {
        if (root == null) {
            throw new UnderflowException("empty tree");
        }
        root = remove(root, value);
    }

    /*
     * Helper method for removing.
     */
    private TreeNode<E> remove(TreeNode<E> node, E value) {
        if (node == null) {
            // value not in tree
            return null;
        }
        int temp = value.compareTo(node.data);
        if (temp < 0) {
            // remove value from left subtree
            node.left = remove(node.left, value);
        } else if (temp > 0) {
            // remove value from right subtree
            node.right = remove(node.right, value);
        } else {
            // remove value at node
            if (node.left != null && node.right != null) {
                // node has two children; replace with minimum in right tree
                node.data = findMin(node.right);
                node.right = remove(node.right, node.data);
            } else {
                // node has at most one child; replace with child (or null)
                node = node.left != null ? node.left : node.right;
            }
        }
        return node;
    }

    /*
     * This inner class represents a node in a (binary) tree.
     */
    private static class TreeNode<E> {
        public E data;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E value) {
            data = value;
            left = null;
            right = null;
        }
    }
}
