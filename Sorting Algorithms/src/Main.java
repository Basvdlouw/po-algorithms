public class Main {

    public static void main(String[] args) {
        Sort is = new InsertionSort<Integer>();
        Sort ms = new MergeSort<Integer>();
        Sort qs = new QuickSort<Integer>();

        Integer[] a = {8, 1, 4, 1, 5, 9, 2, 6, 5};
//        String[] a = {"Dailen", "Bas", "Hoang"};

//        is.sort(a);
//        ms.sort(a);
        qs.sort(a);
    }

    public static <T extends Comparable<T>> void printArray(T[] a) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            sb.append(", ");
        }

        if (a.length > 0) {
            sb.delete(sb.length() - 2, sb.length() - 1);
        }

        System.out.println(sb);
    }
}