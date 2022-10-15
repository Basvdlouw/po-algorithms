package tree.binarysearch;

import tree.binary.BinaryTreeNode;

public class BinarySearchTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T> {

    public BinarySearchTreeNode(T value) {
        super(value);
    }

    public void insert(T value) {
        if (value.compareTo(this.value) < 0) {
            if (left != null) {
                getLeft().insert(value);
            } else {
                BinarySearchTreeNode<T> insert = new BinarySearchTreeNode<>(value);
                insert.setParent(this);
                left = insert;
            }
        } else if (value.compareTo(this.value) > 0) {
            if (right != null) {
                getRight().insert(value);
            } else {
                BinarySearchTreeNode<T> insert = new BinarySearchTreeNode<>(value);
                insert.setParent(this);
                right = insert;
            }
        } else {
            System.out.println("Cannot insert duplicate values: " + value);
        }
    }

    public BinarySearchTreeNode<T> find(T value) {
        if (value.compareTo(this.value) < 0) {
            return getLeft().find(value);
        } else if (value.compareTo(this.value) > 0) {
            return getRight().find(value);
        } else if (value.compareTo(this.value) == 0) {
            return this;
        } else {
            System.out.println("Value: " + value + " not found");
            return null;
        }
    }

    public BinarySearchTreeNode<T> findMin() {
        if (left != null) {
            return getLeft().findMin();
        } else {
            return this;
        }
    }

    public BinarySearchTreeNode<T> findMax() {
        if (right != null) {
            return getRight().findMax();
        } else {
            return this;
        }
    }

    @Override
    public BinarySearchTreeNode<T> getParent() {
        return (BinarySearchTreeNode<T>) parent;
    }

    public void setParent(BinarySearchTreeNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public BinarySearchTreeNode<T> getLeft() {
        return (BinarySearchTreeNode<T>) left;
    }

    public void setLeft(BinarySearchTreeNode<T> left) {
        if (left != null) {
            left.setParent(this);
        }
        this.left = left;
    }

    @Override
    public BinarySearchTreeNode<T> getRight() {
        return (BinarySearchTreeNode<T>) right;
    }

    public void setRight(BinarySearchTreeNode<T> right) {
        if (right != null) {
            right.setParent(this);
        }
        this.right = right;
    }
}