public class InsertionSort<T extends Comparable<T>> implements Sort {

    @Override
    public void sort(Object[] a) {
        insertionSort((T[]) a);
    }

    public void insertionSort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            Main.printArray(a);

            T toBeInserted = a[i];

            int j = i;
            while ((j > 0) && (toBeInserted.compareTo(a[j - 1]) < 0)) {
                a[j] = a[j - 1];
                j--;
            }

            a[j] = toBeInserted;
        }

        Main.printArray(a);
    }
}