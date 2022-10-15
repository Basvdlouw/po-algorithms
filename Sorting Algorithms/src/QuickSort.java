import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> implements Sort {

    @Override
    public void sort(Object[] a) {
        quickSortMedian((T[]) a);
    }

    public T[] quickSortMedian(T[] a) {
        if (a.length <= 1) {
            return a;
        } else if (a.length == 2) {
            if (a[0].compareTo(a[1]) > 0) {
                swap(a, 0, 1);
            }
            return a;
        } else {
            int pivotPos = getMedianPosition(a);
            T pivot = a[pivotPos];

            a[pivotPos] = a[a.length - 1];
            a[a.length - 1] = pivot;

            int i = 0;
            int j = a.length - 2;

            while (i <= j) {
                while (a[i].compareTo(pivot) < 0) {
                    i++;
                }
                while (a[j].compareTo(pivot) > 0) {
                    j--;
                }
                if (i <= j) {
                    swap(a, i, j);

                    i++;
                    j--;
                }
            }

            T[] lower = Arrays.copyOfRange(a, 0, j + 1);
            T[] higher = Arrays.copyOfRange(a, j + 1, a.length - 1);
            T[] c = combine(quickSortMedian(lower), pivot, quickSortMedian(higher));
            Main.printArray(c);
            return c;
        }
    }

    private int getMedianPosition(T[] a) {
        int leftPos = 0;
        T left = a[leftPos];
        int centerPos = (a.length - 1) / 2;
        T center = a[centerPos];
        int rightPos = a.length - 1;
        T right = a[rightPos];

        if (((left.compareTo(center) > 0) && (left.compareTo(right) < 0)) || ((left.compareTo(right) > 0) && (left.compareTo(center) < 0))) {
            return leftPos;
        } else if (((right.compareTo(center) > 0) && (right.compareTo(left) < 0)) || ((right.compareTo(left) > 0) && (right.compareTo(center) < 0))) {
            return rightPos;
        } else {
            return centerPos;
        }
    }

    private void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private T[] combine(T[] lower, T pivot, T[] higher) {
        Comparable[] a = new Comparable[lower.length + higher.length + 1];
        T[] combined = (T[]) a;
        System.arraycopy(lower, 0, combined, 0, lower.length);
        combined[lower.length] = pivot;
        System.arraycopy(higher, 0, combined, lower.length + 1, higher.length);
        return combined;
    }
}