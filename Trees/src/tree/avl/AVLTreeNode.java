package tree.avl;

import tree.binarysearch.BinarySearchTreeNode;

public class AVLTreeNode<T extends Comparable<T>> extends BinarySearchTreeNode<T> {

    public AVLTreeNode(T value) {
        super(value);
    }

    @Override
    public void insert(T value) {
        if (value.compareTo(this.value) < 0) {
            if (left != null) {
                getLeft().insert(value);
            } else {
                AVLTreeNode<T> insert = new AVLTreeNode<>(value);
                insert.setParent(this);
                left = insert;
            }
        } else if (value.compareTo(this.value) > 0) {
            if (right != null) {
                getRight().insert(value);
            } else {
                AVLTreeNode<T> insert = new AVLTreeNode<>(value);
                insert.setParent(this);
                right = insert;
            }
        } else {
            System.out.println("Cannot insert duplicate values: " + value);
        }
    }

    public AVLTreeNode<T> isBalanced() {
        if ((left == null) && (right == null)) {
            return null;
        } else {
            int leftHeight = 0;
            int rightHeight = 0;
            if ((left != null) && (right != null)) {
                leftHeight = left.getHeight();
                rightHeight = right.getHeight();
                return outBalanceSide(leftHeight, rightHeight);
            } else {
                if (left != null) {
                    leftHeight = left.getHeight();
                    return outBalanceSide(leftHeight, rightHeight);
                } else {
                    rightHeight = right.getHeight();
                    return outBalanceSide(leftHeight, rightHeight);
                }
            }
        }
    }

    private AVLTreeNode<T> outBalanceSide(int leftHeight, int rightHeight) {
        if (Math.abs(leftHeight - rightHeight) > 1) {
            if (leftHeight > rightHeight) {
                return (AVLTreeNode<T>) left;
            } else {
                return (AVLTreeNode<T>) right;
            }
        } else {
            return null;
        }
    }

    @Override
    public AVLTreeNode<T> getParent() {
        return (AVLTreeNode<T>) parent;
    }

    public void setParent(AVLTreeNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public AVLTreeNode<T> getLeft() {
        return (AVLTreeNode<T>) left;
    }

    public void setLeft(AVLTreeNode<T> left) {
        if (left != null) {
            left.setParent(this);
        }
        this.left = left;
    }

    @Override
    public AVLTreeNode<T> getRight() {
        return (AVLTreeNode<T>) right;
    }

    public void setRight(AVLTreeNode<T> right) {
        if (right != null) {
            right.setParent(this);
        }
        this.right = right;
    }
}