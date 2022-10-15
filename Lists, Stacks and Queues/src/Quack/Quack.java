package Quack;

public class Quack<T> {

    private QuackElement<T> first;
    private QuackElement<T> last;

    public void addFirst(T value) {
        QuackElement<T> add = new QuackElement<T>();
        add.setValue(value);

        if (first == null) {
            first = add;
            last = add;
        } else {
            first.setPrevious(add);
            add.setNext(first);
            first = add;
        }
    }

    public T popFirst() throws IndexOutOfBoundsException {
        if (first == null) {
            throw new IndexOutOfBoundsException();
        } else {
            QuackElement<T> pop = first;
            QuackElement<T> second = first.getNext();
            second.setPrevious(null);
            first = second;
            return pop.getValue();
        }
    }

    public T getFirst() throws IndexOutOfBoundsException {
        if (first == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return first.getValue();
        }
    }

    public void addLast(T value) {
        QuackElement<T> add = new QuackElement<T>();
        add.setValue(value);

        if (last == null) {
            first = add;
            last = add;
        } else {
            last.setNext(add);
            add.setPrevious(last);
            last = add;
        }
    }

    public T popLast() throws IndexOutOfBoundsException {
        if (last == null) {
            throw new IndexOutOfBoundsException();
        } else {
            QuackElement<T> pop = last;
            QuackElement<T> secondLast = last.getPrevious();
            secondLast.setNext(null);
            last = secondLast;
            return pop.getValue();
        }
    }

    public T getLast() {
        if (last == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return last.getValue();
        }
    }

    public int getSize() {
        int size = 0;
        QuackElement<T> i = first;
        while (i != null) {
            i = i.getNext();
            size++;
        }
        return size;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        int size = 0;
        QuackElement<T> i = first;
        while (i != null) {
            sb.append(i.getValue());
            sb.append(", ");

            size++;
            i = i.getNext();
        }

        if (size > 0) {
            sb.delete(sb.length() - 2, sb.length() - 1);
        }

        return sb.toString();
    }
}