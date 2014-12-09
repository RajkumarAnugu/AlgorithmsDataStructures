package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 23. jul. 2014
 * <p/>
 * sort an array using the heap sort algorithm.
 * <p/>
 * The heapsort algorithm is based on inserting elements into a heap and removing them in sorted order.
 * <p/>
 * Heapsort algorithm: First insert all elements to be sorted into the heap, then keep extracting the minimum.
 * <p/>
 * This algorithm is an O(n log(n)) algorithm: each insertion and removal is O(log(n)), and these steps are repeated n
 * times, once for each element in the sequence that is to be sorted.
 */
public class HeapSorter {
    /**
     * Sorts an array, using selection sort.
     */
    private static String processString;

    public static void sort(int[] array) {

        /**
         * first fix small subtrees into heaps, then fix larger trees. Because
         * trees of size 1 are automatically heaps, we can begin the fixing
         * procedure with the subtrees whose roots are located in the
         * next-to-last level of the tree.
         */
        int n = array.length - 1;
        processString = "";
        // (n-1)/2 next-to-last level of the tree (last smallest subtree)
        for (int i = (n - 1) / 2; i >= 0; i--) {
            //            fixHeap(array, i, n);
            array = maxHeapify(array, i);
            processString += "fixHeap: " + Arrays.toString(array) + " pos: " + i + " lastPos: " + n + "\n";
        }
        while (n > 0) {
            ArrayUtil.swap(array, 0, n);
            processString += "   swap: " + Arrays.toString(array) + " pos: 0" + " lastPos: " + n + "\n";
            n--;
            //            fixHeap(array, 0, n);
            array = maxHeapify(array, 0);
            processString += "fixHeap: " + Arrays.toString(array) + " pos: 0" + " lastPos: " + n + "\n";
        }
    }

    public static int[] heapsort(int[] A) {
        A = buildMaxHeap(A);
        for (int i = A.length; i < 1; i--) {
            swap(A, 1, i);
            maxHeapify(A, 1);
        }
        return A;
    }

    public static int[] buildMaxHeap(int[] A) {
        for (int i = A.length; i > 0; i--) {
            maxHeapify(A, i);
        }
        return A;
    }

    public static int[] maxHeapify(int[] A, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l <= A.length - 1 && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= A.length - 1 && A[r] > A[i]) {
            largest = r;
        }
        if (largest != i) {
            swap(A, i, largest);
            maxHeapify(A, largest);
        }
        return A;
    }

    public static final int[] swap(int[] l, int i, int j) {
        int a = l[i];
        l[j] = l[i];
        l[i] = a;
        return l;
    }

    public static int parent(int i) {
        return i / 2;
    }

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    /**
     * @param a
     * @param rootIndex
     * @param lastIndex
     */
    private static void fixHeap(int[] a, int rootIndex, int lastIndex) {

        // Remove root
        int rootValue = a[rootIndex];

        //promote children while they are lager than the root

        int index = rootIndex;
        boolean more = true;
        while (more) {
            int childIndex = getLeftChildIndex(index);
            if (childIndex <= lastIndex) {
                // use right child instead if it is larger
                int rightChildIndex = getRightChildIndex(index);
                if (rightChildIndex <= lastIndex && a[rightChildIndex] > a[childIndex]) {
                    childIndex = rightChildIndex;
                }
                if (a[childIndex] > rootValue) {
                    // promote child
                    a[index] = a[childIndex];
                    index = childIndex;
                } else {
                    // root value is larger than both children
                    more = false;
                }
            } else {
                // no childen
                more = false;
            }
        }
        // store root value in vacant slot
        a[index] = rootValue;
    }

    private static int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private static int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public static String getProcessString() {
        return processString;
    }
}
