package sorting;

/**
 * Quicksort, or partition-exchange sort, is a sorting algorithm developed by Tony Hoare that, on average, makes O(n log
 * n) comparisons to sort n items. In the worst case, it makes O(n^2) comparisons, though this behavior is rare.
 * Quicksort is often faster in practice than other O(n log n) algorithms. <br> Additionally, quicksort's sequential and
 * localized memory references work well with a cache. Quicksort is a comparison sort and, in efficient implementations,
 * is not a stable sort. Quicksort can be implemented with an in-place partitioning algorithm, so the entire sort can be
 * done with only O(log n) additional space used by the stack during the recursion.
 */
public class QuickSort {

    public static void sort(int[] a) {
        System.out.println("array: " + toString(a));
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int from, int to) {
        if (from >= to) {
            return;
        }
        //                int p = partition(a, from, to);
        int p = partitioning(a, from, to);
        //        System.out.println("p: " + p);
        //        System.out.println("sort(a,from,p)"+"p: " + p);
        sort(a, from, p - 1);
        //        System.out.println("a: " + QuickSort.toString(a)+"  p: " + p);
        //        System.out.println("sort(a,p+1,to)");
        sort(a, p + 1, to);
        System.out.println("a    : " + QuickSort.toString(a) + "  p: " + p);
    }

    public static int partition(int[] a, int from, int to) {
        int pivot = a[to];
        int i = from - 1;
        int j = to + 1;
        while (i < j) {
            i++;
            while (a[i] < pivot) {
                i++;
            }
            j--;
            while (a[j] > pivot) {
                j--;
            }
            if (i < j) {
                a = swap(a, i, j);
            }
        }
        return j;
    }

    /**
     * Quicksort page 171
     *
     * @param A list
     * @param p from
     * @param r to
     *
     * @return partition
     */
    public static int partitioning(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return i + 1;
    }

    public static int[] swap(int[] a, int i, int j) {
        //        System.out.println("swap : " + QuickSort.toString(a));
        if (i < 0 || j < 0 || i > a.length || j > a.length) {
            throw new IllegalArgumentException("Illegal argument!");
        } else {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        System.out.println("swap : " + QuickSort.toString(a));
        return a;
    }

    public static String toString(int[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            s += a[i] + ", ";
        }
        return s;
    }

}
