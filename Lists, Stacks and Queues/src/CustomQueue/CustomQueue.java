package CustomQueue;

public class CustomQueue<T> {

    private CustomQueueElement<T> first;
    private CustomQueueElement<T> last;

    public void enqueue(T value) {
        CustomQueueElement<T> en = new CustomQueueElement<T>();
        en.setValue(value);

        if (first == null) {
            first = en;
            last = en;
        } else {
            last.setNext(en);
            last = en;
        }
    }

    public T dequeue() throws IndexOutOfBoundsException {
        if (first == null) {
            throw new IndexOutOfBoundsException();
        } else {
            CustomQueueElement<T> de = first;
            first = first.getNext();
            return de.getValue();
        }
    }

    public T getFirst() {
        if (first == null) {
            return null;
        } else {
            return first.getValue();
        }
    }

    public int getSize() {
        int size = 0;
        CustomQueueElement<T> i = first;
        while (i != null) {
            i = i.getNext();
            size++;
        }
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        int size = 0;
        CustomQueueElement<T> i = first;
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