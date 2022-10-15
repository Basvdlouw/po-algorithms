public class Min {

    public static <T extends Comparable<T>> T getMin(T[] a) {
        T min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(min) < 0) {
                min = a[i];
            }
        }
        return min;
    }
}