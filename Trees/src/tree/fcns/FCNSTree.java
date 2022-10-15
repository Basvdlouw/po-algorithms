package tree.fcns;

import tree.Tree;

public class FCNSTree<T> extends Tree<T> {

    public FCNSTree(FCNSTreeNode<T> root) {
        super(root);
    }

    @Override
    public FCNSTreeNode<T> getRoot() {
        return (FCNSTreeNode<T>) root;
    }

    @Override
    public void print() {
        System.out.println("FCNS Tree:");
        root.print();
    }
}