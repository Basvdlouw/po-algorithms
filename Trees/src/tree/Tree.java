package tree;

public abstract class Tree<T> {

    protected TreeNode<T> root;

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    public int getAmountOfLeaves() {
        return root.getAmountOfLeaves();
    }

    public int getSize() {
        return root.getSize();
    }

    public abstract TreeNode<T> getRoot();

    public abstract void print();
}