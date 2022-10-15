package tree.fcns;

import tree.NonBinaryTreeNode;

import java.util.LinkedList;

public class FCNSTreeNode<T> extends NonBinaryTreeNode<T> {

    public FCNSTreeNode(T value) {
        super(value, new LinkedList<>());
    }

    @Override
    public FCNSTreeNode<T> getParent() {
        return (FCNSTreeNode<T>) parent;
    }

    public void setParent(FCNSTreeNode<T> parent) {
        this.parent = parent;
    }
}