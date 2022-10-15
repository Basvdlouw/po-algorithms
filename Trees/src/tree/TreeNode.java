package tree;

public abstract class TreeNode<T> {

    protected T value;
    protected TreeNode<T> parent;

    public TreeNode(T value) {
        this.value = value;
    }

    public abstract int getAmountOfChildren();

    public abstract int getAmountOfLeaves();

    public abstract int getHeight();

    public abstract int getDepth();

    public abstract int getSize();

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public abstract TreeNode<T> getParent();

    public abstract void print();
}