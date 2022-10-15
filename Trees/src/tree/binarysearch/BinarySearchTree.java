package tree.binarysearch;

import tree.binary.BinaryTree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public BinarySearchTree(BinarySearchTreeNode<T> root) {
        super(root);
    }

    public void insert(T value) {
        getRoot().insert(value);
    }

    public void remove(T value) {
        BinarySearchTreeNode<T> remove = getRoot().find(value);
        int children = remove.getAmountOfChildren();
        if (children == 2) {
            removeTwoChildren(remove);
        } else if (children == 1) {
            removeOneChild(remove);
        } else {
            removeLeaf(remove);
        }
    }

    private void removeTwoChildren(BinarySearchTreeNode<T> remove) {
        BinarySearchTreeNode<T> min = remove.getRight().findMin();
        T value = min.getValue();
        if (min.getAmountOfChildren() == 1) {
            removeOneChild(min);
        } else {
            removeLeaf(min);
        }
        remove.setValue(value);
    }

    private void removeOneChild(BinarySearchTreeNode<T> remove) {
        BinarySearchTreeNode<T> child;
        if (remove.getLeft() != null) {
            child = remove.getLeft();
        } else {
            child = remove.getRight();
        }

        BinarySearchTreeNode<T> parent = remove.getParent();
        if (parent.getLeft() == remove) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
    }

    private void removeLeaf(BinarySearchTreeNode<T> remove) {
        BinarySearchTreeNode<T> parent = remove.getParent();
        if (parent.getLeft() == remove) {
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }
    }

    public T find(T value) {
        return getRoot().find(value).getValue();
    }

    public T findMin() {
        return getRoot().findMin().getValue();
    }

    public T findMax() {
        return getRoot().findMax().getValue();
    }

    @Override
    public BinarySearchTreeNode<T> getRoot() {
        return (BinarySearchTreeNode<T>) root;
    }

    @Override
    public void print() {
        System.out.println("Binary Search Tree:");
        root.print();
    }
}