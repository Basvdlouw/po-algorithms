package CustomQueue;

public class CustomQueueElement<T> {

    private T value;
    private CustomQueueElement<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public CustomQueueElement<T> getNext() {
        return next;
    }

    public void setNext(CustomQueueElement<T> next) {
        this.next = next;
    }
}