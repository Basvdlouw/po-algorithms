public class MergeSort<T extends Comparable<T>> implements Sort {

    @Override
    public void sort(Object[] a) {
        mergeSort((T[]) a);
    }

    public void mergeSort(T[] a) {
        Object[] tmp = new Object[a.length];
        mergeS(a, tmp, 0, a.length - 1);
    }

    private void mergeS(T[] a, Object[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeS(a, tmp, left, center);
            mergeS(a, tmp, center + 1, right);
            merge(a, tmp, left, center, right);
            Main.printArray(a);
        }
    }

    private void merge(T[] a, Object[] tmp, int left, int center, int right) {
        int c = left;
        int i = left;
        int j = center + 1;

        while (c <= right) {
            if ((i <= center) && (j <= right)) {
                if (a[i].compareTo(a[j]) < 0) {
                    tmp[c] = a[i];
                    i++;
                } else {
                    tmp[c] = a[j];
                    j++;
                }
            } else if ((i > center) && (j <= right)) {
                tmp[c] = a[j];
                j++;
            } else if ((i <= center) && (j > right)) {
                tmp[c] = a[i];
                i++;
            } else {
                break;
            }
            c++;
        }

        for (int l = left; l <= right; l++) {
            a[l] = (T) tmp[l];
        }
    }
}