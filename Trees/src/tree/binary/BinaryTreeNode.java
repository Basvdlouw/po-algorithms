package tree.binary;

import tree.TreeNode;

public class BinaryTreeNode<T> extends TreeNode<T> {

    protected BinaryTreeNode<T> left;
    protected BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        super(value);
    }

    @Override
    public int getAmountOfChildren() {
        if ((left == null) && (right == null)) {
            return 0;
        } else if ((left != null) && (right != null)) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public int getAmountOfLeaves() {
        if ((left == null) && (right == null)) {
            return 1;
        } else if ((left != null) && (right != null)) {
            return left.getAmountOfLeaves() + right.getAmountOfLeaves();
        } else {
            if (left != null) {
                return left.getAmountOfLeaves();
            } else {
                return right.getAmountOfLeaves();
            }
        }
    }

    @Override
    public int getHeight() {
        if ((left == null) && (right == null)) {
            return 0;
        } else if ((left != null) && (right != null)) {
            int height = left.getHeight();
            if (right.getHeight() > height) {
                height = right.getHeight();
            }
            return 1 + height;
        } else {
            if (left != null) {
                return 1 + left.getHeight();
            } else {
                return 1 + right.getHeight();
            }
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
        if ((left == null) && (right == null)) {
            return 1;
        } else if ((left != null) && (right != null)) {
            return 1 + left.getSize() + right.getSize();
        } else {
            if (left != null) {
                return 1 + left.getSize();
            } else {
                return 1 + right.getSize();
            }
        }
    }

    @Override
    public BinaryTreeNode<T> getParent() {
        return (BinaryTreeNode<T>) parent;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        if (left != null) {
            left.setParent(this);
        }
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        if (right != null) {
            right.setParent(this);
        }
        this.right = right;
    }

    @Override
    public void print() {
        StringBuilder offset = new StringBuilder();
        BinaryTreeNode<T> current = this;
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
            if ((left != null) || (right != null)) {
                System.out.println(offset + "|   |");
            }
        } else {
            System.out.println(offset + value.toString());
            if ((left != null) || (right != null)) {
                System.out.println(offset + "|");
            }
        }

        if (left != null) {
            left.print();
            if (parent != null) {
                System.out.println(offset + "|   |");
            } else {
                System.out.println(offset + "|");
            }
        }

        if (right != null) {
            right.print();
        }
    }
}