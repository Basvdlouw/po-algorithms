package tree.normal;

import tree.Tree;

public class NormalTree<T> extends Tree<T> {

    public NormalTree(NormalTreeNode<T> root) {
        super(root);
    }

    @Override
    public NormalTreeNode<T> getRoot() {
        return (NormalTreeNode<T>) root;
    }

    @Override
    public void print() {
        System.out.println("Normal Tree:");
        root.print();
    }
}