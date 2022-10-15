package tree;

import java.util.List;

public abstract class NonBinaryTreeNode<T> extends TreeNode<T> {

    protected List<NonBinaryTreeNode<T>> children;

    public NonBinaryTreeNode(T value, List<NonBinaryTreeNode<T>> children) {
        super(value);
        this.children = children;
    }

    public void addChild(NonBinaryTreeNode<T> child) {
        child.setParent(this);
        children.add(child);
    }

    public void removeChild(NonBinaryTreeNode<T> child) {
        while (children.remove(child)) ;
    }

    @Override
    public int getAmountOfChildren() {
        return children.size();
    }

    @Override
    public int getAmountOfLeaves() {
        if (children.size() == 0) {
            return 1;
        } else {
            int amount = 0;
            for (NonBinaryTreeNode<T> child : children) {
                amount += child.getAmountOfLeaves();
            }
            return amount;
        }
    }

    @Override
    public int getHeight() {
        if (children.size() == 0) {
            return 0;
        } else {
            int height = 0;
            for (NonBinaryTreeNode<T> child : children) {
                if (child.getHeight() > height) {
                    height = child.getHeight();
                }
            }
            return 1 + height;
        }
    }

    @Override
    public int getDepth() {
        if (parent == null) {
            return 0;
        } else {
            return 1 + parent.getDepth();
        }
    }

    @Override
    public int getSize() {
        if (children.size() == 0) {
            return 1;
        } else {
            int size = 1;
            for (NonBinaryTreeNode<T> child : children) {
                size += child.getSize();
            }
            return size;
        }
    }

    @Override
    public NonBinaryTreeNode<T> getParent() {
        return (NonBinaryTreeNode<T>) parent;
    }

    public void setParent(NonBinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public List<NonBinaryTreeNode<T>> getChildren() {
        return children;
    }

    @Override
    public void print() {
        StringBuilder offset = new StringBuilder();
        NonBinaryTreeNode<T> current = this;
        while (current.getParent() != null) {
            current = current.getParent();
            if (current.getParent() != null) {
                offset.append("|   ");
            }
            for (int i = 0; i < current.getValue().toString().length() - 1; i++) {
                offset.append(" ");
            }
        }

        if (parent != null) {
            System.out.println(offset + "o - " + value.toString());
            if (children.size() > 0) {
                System.out.println(offset + "|   |");
            }
        } else {
            System.out.println(offset + value.toString());
            if (children.size() > 0) {
                System.out.println(offset + "|");
            }
        }

        for (int i = 0; i < children.size(); i++) {
            children.get(i).print();
            if (i < children.size() - 1) {
                if (parent != null) {
                    System.out.println(offset + "|   |");
                } else {
                    System.out.println(offset + "|");
                }
            }
        }
    }
}