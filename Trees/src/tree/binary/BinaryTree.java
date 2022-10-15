package tree.binary;

import tree.Tree;

public class BinaryTree<T> extends Tree<T> {

    public BinaryTree(BinaryTreeNode<T> root) {
        super(root);
    }

    @Override
    public BinaryTreeNode<T> getRoot() {
        return (BinaryTreeNode<T>) root;
    }

    @Override
    public void print() {
        System.out.println("Binary Tree:");
        root.print();
    }
}