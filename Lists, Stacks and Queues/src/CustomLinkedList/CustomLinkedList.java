package CustomLinkedList;

public class CustomLinkedList<T> {

    private CustomLinkedListNode<T> header;

    public CustomLinkedList() {
        header = new CustomLinkedListNode<T>();
    }

    public void addFirst(T value) {
        CustomLinkedListNode<T> first = new CustomLinkedListNode<T>();
        first.setValue(value);

        if (header.getNext() == null) {
            header.setNext(first);
        } else {
            CustomLinkedListNode<T> second = header.getNext();
            header.setNext(first);
            first.setNext(second);
        }
    }

    public void removeFirst() throws IndexOutOfBoundsException {
        if (header.getNext() == null) {
            throw new IndexOutOfBoundsException();
        } else {
            CustomLinkedListNode<T> first = header.getNext();
            header.setNext(first.getNext());
        }
    }

    public void insert(int index, T value) throws IndexOutOfBoundsException {
        if (index == 0) {
            addFirst(value);
            return;
        }

        CustomLinkedListNode<T> prev = getNode(index - 1);
        CustomLinkedListNode<T> insert = new CustomLinkedListNode<T>();
        insert.setValue(value);

        if (prev.getNext() == null) {
            prev.setNext(insert);
        } else {
            CustomLinkedListNode<T> next = prev.getNext();
            prev.setNext(insert);
            insert.setNext(next);
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            removeFirst();
            return;
        }

        CustomLinkedListNode<T> prev = getNode(index - 1);
        if (prev.getNext() == null) {
            throw new IndexOutOfBoundsException();
        } else {
            CustomLinkedListNode<T> remove = prev.getNext();
            CustomLinkedListNode<T> next = remove.getNext();
            prev.setNext(next);
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {
        return getNode(index).getValue();
    }

    public int getSize() {
        int size = 0;
        CustomLinkedListNode<T> i = header.getNext();
        while (i != null) {
            i = i.getNext();
            size++;
        }
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        int size = 0;
        CustomLinkedListNode<T> i = header.getNext();
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

    private CustomLinkedListNode<T> getNode(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        int i = 0;
        CustomLinkedListNode<T> n = header.getNext();

        while (i <= index) {
            if (n == null) {
                throw new IndexOutOfBoundsException();
            }

            if (i == index) {
                break;
            }

            i++;
            n = n.getNext();
        }

        return n;
    }
}