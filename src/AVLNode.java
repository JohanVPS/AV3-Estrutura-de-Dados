package src;

/**
 * Represents a node in an AVL tree.
 * @param <T> The type of data stored in the node, must be comparable.
 */
public class AVLNode<T extends Comparable<T>> {
    private T data;
    private AVLNode<T> left;
    private AVLNode<T> right;
    private int height;

    public AVLNode(T data) {
        this.data = data;
        this.height = 1;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
} 