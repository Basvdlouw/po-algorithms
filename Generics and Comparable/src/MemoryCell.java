public class MemoryCell<T> implements Comparable<MemoryCell<T>> {

    private T storedValue;

    public T read() {
        return storedValue;
    }

    public void write(T x) {
        storedValue = x;
    }

    @Override
    public int compareTo(MemoryCell<T> other) {
//        if (storedValue == other.read()) return 0;
//        if (storedValue > other.read()) return 1;
        return -1;
    }
}