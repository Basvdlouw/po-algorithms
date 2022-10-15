package tree.avl;

import tree.binarysearch.BinarySearchTree;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    public AVLTree(AVLTreeNode<T> root) {
        super(root);
    }

    @Override
    public void insert(T value) {
        getRoot().insert(value);
        correctBalance((AVLTreeNode<T>) getRoot().find(value));
    }

    @Override
    public void remove(T value) {
        AVLTreeNode<T> parent = (AVLTreeNode<T>) getRoot().find(value).getParent();
        super.remove(value);
        correctBalance(parent);
    }

    private void correctBalance(AVLTreeNode<T> node) {
        AVLTreeNode<T> current = node;
        while (current != null) {
            AVLTreeNode<T> child = current.isBalanced();
            if (child != null) {
                AVLTreeNode<T> left = child.getLeft();
                AVLTreeNode<T> right = child.getRight();
                if (child == current.getLeft()) {
                    if ((left != null) && (right != null)) {
                        if (left.getHeight() > right.getHeight()) {
                            LLCorrectBalance(current, child);
                        } else if (right.getHeight() > left.getHeight()) {
                            LRCorrectBalance(current, child);
                        }
                    } else {
                        if (left != null) {
                            LLCorrectBalance(current, child);
                        } else {
                            LRCorrectBalance(current, child);
                        }
                    }
                } else if (child == current.getRight()) {
                    if ((left != null) && (right != null)) {
                        if (right.getHeight() > left.getHeight()) {
                            RRCorrectBalance(current, child);
                        } else if (left.getHeight() > right.getHeight()) {
                            RLCorrectBalance(current, child);
                        }
                    } else {
                        if (right != null) {
                            RRCorrectBalance(current, child);
                        } else {
                            RLCorrectBalance(current, child);
                        }
                    }
                }
                break;
            }
            current = current.getParent();
        }
    }

    private void LLCorrectBalance(AVLTreeNode<T> current, AVLTreeNode<T> child) {
        AVLTreeNode<T> parent = current.getParent();
        current.setLeft(child.getRight());
        child.setRight(current);
        if (parent != null) {
            if (parent.getLeft() == current) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        } else {
            child.setParent(null);
            root = child;
        }
    }

    private void LRCorrectBalance(AVLTreeNode<T> current, AVLTreeNode<T> child) {
        AVLTreeNode<T> sub = child.getRight();
        RRCorrectBalance(child, sub);
        LLCorrectBalance(current, sub);
    }

    private void RRCorrectBalance(AVLTreeNode<T> current, AVLTreeNode<T> child) {
        AVLTreeNode<T> parent = current.getParent();
        current.setRight(child.getLeft());
        child.setLeft(current);
        if (parent != null) {
            if (parent.getLeft() == current) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        } else {
            child.setParent(null);
            root = child;
        }
    }

    private void RLCorrectBalance(AVLTreeNode<T> current, AVLTreeNode<T> child) {
        AVLTreeNode<T> sub = child.getLeft();
        LLCorrectBalance(child, sub);
        RRCorrectBalance(current, sub);
    }

    @Override
    public AVLTreeNode<T> getRoot() {
        return (AVLTreeNode<T>) root;
    }

    @Override
    public void print() {
        System.out.println("AVL Tree:");
        root.print();
    }
}