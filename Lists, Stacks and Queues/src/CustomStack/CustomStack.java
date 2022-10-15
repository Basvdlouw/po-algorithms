package CustomStack;

public class CustomStack<T> {

    private CustomStackElement<T> top;

    public void push(T value) {
        CustomStackElement<T> push = new CustomStackElement<T>();
        push.setValue(value);

        if (top == null) {
            top = push;
        } else {
            push.setPrevious(top);
            top = push;
        }
    }

    public T pop() throws IndexOutOfBoundsException {
        if (top == null) {
            throw new IndexOutOfBoundsException();
        } else {
            CustomStackElement<T> pop = top;
            top = pop.getPrevious();
            return pop.getValue();
        }
    }

    public T top() throws IndexOutOfBoundsException {
        if (top == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return top.getValue();
        }
    }

    public int getSize() {
        int size = 0;
        CustomStackElement<T> i = top;
        while (i != null) {
            i = i.getPrevious();
            size++;
        }
        return size;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        int size = 0;
        CustomStackElement<T> i = top;
        while (i != null) {
            sb.append(i.getValue());
            sb.append(", ");

            size++;
            i = i.getPrevious();
        }

        if (size > 0) {
            sb.delete(sb.length() - 2, sb.length() - 1);
        }

        return sb.toString();
    }
}