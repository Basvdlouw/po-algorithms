package CustomArrayList;

public class CustomArrayList<T> {

    private T[] array;
    private int nextInsert;

    public CustomArrayList() {
        Object[] a = new Object[10];
        array = (T[]) a;
        nextInsert = 0;
    }

    public CustomArrayList(int size) {
        Object[] a = new Object[size];
        array = (T[]) a;
        nextInsert = 0;
    }

    public void add(T value) {
        if (nextInsert == array.length) {
            Object[] a = new Object[array.length * 2 + 1];
            T[] t = (T[]) a;
            System.arraycopy(array, 0, t, 0, array.length);
            array = t;
        }
        array[nextInsert] = value;
        nextInsert++;
    }

    public void set(int index, T value) throws IndexOutOfBoundsException {
        checkBounds(index);
        array[index] = value;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        checkBounds(index);
        return array[index];
    }

    public int size() {
        return array.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nextInsert; i++) {
            sb.append(array[i]);
            sb.append(", ");
        }

        if (array.length > 0) {
            sb.delete(sb.length() - 2, sb.length() - 1);
        }

        return sb.toString();
    }

    private void checkBounds(int index) throws IndexOutOfBoundsException {
        if ((index >= array.length) || (index < 0)) {
            throw new IndexOutOfBoundsException();
        }
    }
}