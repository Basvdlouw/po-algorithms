package Quack;

public class QuackElement<T> {

    private T value;
    private QuackElement<T> previous;
    private QuackElement<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public QuackElement<T> getPrevious() {
        return previous;
    }

    public void setPrevious(QuackElement<T> previous) {
        this.previous = previous;
    }

    public QuackElement<T> getNext() {
        return next;
    }

    public void setNext(QuackElement<T> next) {
        this.next = next;
    }
}