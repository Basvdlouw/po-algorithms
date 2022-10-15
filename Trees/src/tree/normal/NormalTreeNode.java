package tree.normal;

import tree.NonBinaryTreeNode;

import java.util.ArrayList;

public class NormalTreeNode<T> extends NonBinaryTreeNode<T> {

    public NormalTreeNode(T value) {
        super(value, new ArrayList<>());
    }

    @Override
    public NormalTreeNode<T> getParent() {
        return (NormalTreeNode<T>) parent;
    }

    public void setParent(NormalTreeNode<T> parent) {
        this.parent = parent;
    }
}