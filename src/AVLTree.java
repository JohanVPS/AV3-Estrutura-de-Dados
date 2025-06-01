package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of an AVL tree data structure.
 * @param <T> The type of data stored in the tree, must be comparable.
 */
public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Gets the size of the tree.
     * @return The number of nodes in the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the tree is empty.
     * @return true if the tree is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the height of a node.
     * @param node The node to get the height of.
     * @return The height of the node, or 0 if the node is null.
     */
    private int height(AVLNode<T> node) {
        return node == null ? 0 : node.getHeight();
    }

    /**
     * Gets the balance factor of a node.
     * @param node The node to get the balance factor of.
     * @return The balance factor of the node.
     */
    private int getBalanceFactor(AVLNode<T> node) {
        return node == null ? 0 : height(node.getLeft()) - height(node.getRight());
    }

    /**
     * Updates the height of a node.
     * @param node The node to update the height of.
     */
    private void updateHeight(AVLNode<T> node) {
        if (node != null) {
            node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        }
    }

    /**
     * Performs a right rotation on the given node.
     * @param y The node to rotate.
     * @return The new root of the rotated subtree.
     */
    private AVLNode<T> rightRotate(AVLNode<T> y) {
        AVLNode<T> x = y.getLeft();
        AVLNode<T> T2 = x.getRight();

        // Perform rotation
        x.setRight(y);
        y.setLeft(T2);

        // Update heights
        updateHeight(y);
        updateHeight(x);

        // Return new root
        return x;
    }

    /**
     * Performs a left rotation on the given node.
     * @param x The node to rotate.
     * @return The new root of the rotated subtree.
     */
    private AVLNode<T> leftRotate(AVLNode<T> x) {
        AVLNode<T> y = x.getRight();
        AVLNode<T> T2 = y.getLeft();

        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);

        // Update heights
        updateHeight(x);
        updateHeight(y);

        // Return new root
        return y;
    }

    /**
     * Inserts a value into the tree.
     * @param value The value to insert.
     */
    public void insert(T value) {
        root = insert(root, value);
        size++;
    }

    /**
     * Helper method to insert a value into the tree.
     * @param node The current node.
     * @param value The value to insert.
     * @return The new root of the modified subtree.
     */
    private AVLNode<T> insert(AVLNode<T> node, T value) {
        // Perform standard BST insert
        if (node == null) {
            return new AVLNode<>(value);
        }

        int compareResult = value.compareTo(node.getData());

        if (compareResult < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (compareResult > 0) {
            node.setRight(insert(node.getRight(), value));
        } else {
            // Duplicate values not allowed, decrement size
            size--;
            return node;
        }

        // Update height of current node
        updateHeight(node);

        // Get the balance factor to check if this node became unbalanced
        int balance = getBalanceFactor(node);

        // Left Left Case
        if (balance > 1 && value.compareTo(node.getLeft().getData()) < 0) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && value.compareTo(node.getRight().getData()) > 0) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && value.compareTo(node.getLeft().getData()) > 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value.compareTo(node.getRight().getData()) < 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        // Return the unchanged node
        return node;
    }

    /**
     * Searches for a value in the tree.
     * @param value The value to search for.
     * @return true if the value is found, false otherwise.
     */
    public boolean search(T value) {
        return search(root, value);
    }

    /**
     * Helper method to search for a value in the tree.
     * @param node The current node.
     * @param value The value to search for.
     * @return true if the value is found, false otherwise.
     */
    private boolean search(AVLNode<T> node, T value) {
        if (node == null) {
            return false;
        }

        int compareResult = value.compareTo(node.getData());

        if (compareResult == 0) {
            return true;
        } else if (compareResult < 0) {
            return search(node.getLeft(), value);
        } else {
            return search(node.getRight(), value);
        }
    }

    /**
     * Removes a value from the tree.
     * @param value The value to remove.
     * @return true if the value was removed, false if it wasn't found.
     */
    public boolean remove(T value) {
        int originalSize = size;
        root = remove(root, value);
        return originalSize != size;
    }

    /**
     * Helper method to remove a value from the tree.
     * @param node The current node.
     * @param value The value to remove.
     * @return The new root of the modified subtree.
     */
    private AVLNode<T> remove(AVLNode<T> node, T value) {
        if (node == null) {
            return null;
        }

        int compareResult = value.compareTo(node.getData());

        if (compareResult < 0) {
            node.setLeft(remove(node.getLeft(), value));
        } else if (compareResult > 0) {
            node.setRight(remove(node.getRight(), value));
        } else {
            // Node with the value found, remove it
            size--;

            // Node with only one child or no child
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // Node with two children
            // Get the inorder successor (smallest in the right subtree)
            AVLNode<T> successor = findMin(node.getRight());
            node.setData(successor.getData());
            node.setRight(remove(node.getRight(), successor.getData()));
            size++; // Adjust for double decrement
        }

        if (node == null) {
            return null;
        }

        // Update height
        updateHeight(node);

        // Get the balance factor
        int balance = getBalanceFactor(node);

        // Left Left Case
        if (balance > 1 && getBalanceFactor(node.getLeft()) >= 0) {
            return rightRotate(node);
        }

        // Left Right Case
        if (balance > 1 && getBalanceFactor(node.getLeft()) < 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && getBalanceFactor(node.getRight()) <= 0) {
            return leftRotate(node);
        }

        // Right Left Case
        if (balance < -1 && getBalanceFactor(node.getRight()) > 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    /**
     * Finds the minimum value node in a subtree.
     * @param node The root of the subtree.
     * @return The node with the minimum value.
     */
    private AVLNode<T> findMin(AVLNode<T> node) {
        AVLNode<T> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    /**
     * Performs an inorder traversal of the tree.
     * @return A list of all elements in sorted order.
     */
    public List<T> inorderTraversal() {
        List<T> resultList = new ArrayList<>(size);
        inorderTraversal(root, resultList);
        return resultList;
    }

    /**
     * Helper method for inorder traversal.
     * @param node The current node.
     * @param resultList The list to store the traversal result.
     */
    private void inorderTraversal(AVLNode<T> node, List<T> resultList) {
        if (node != null) {
            inorderTraversal(node.getLeft(), resultList);
            resultList.add(node.getData());
            inorderTraversal(node.getRight(), resultList);
        }
    }

    /**
     * Gets the root node of the tree.
     * @return The root node.
     */
    public AVLNode<T> getRoot() {
        return root;
    }
} 