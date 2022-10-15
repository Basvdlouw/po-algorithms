package CustomLinkedList;

public class CustomLinkedListNode<T> {

    private T value;
    private CustomLinkedListNode<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public CustomLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(CustomLinkedListNode<T> next) {
        this.next = next;
    }
}