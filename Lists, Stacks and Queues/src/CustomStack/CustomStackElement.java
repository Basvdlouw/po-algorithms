package CustomStack;

public class CustomStackElement<T> {

    private T value;
    private CustomStackElement<T> previous;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public CustomStackElement<T> getPrevious() {
        return previous;
    }

    public void setPrevious(CustomStackElement<T> previous) {
        this.previous = previous;
    }
}