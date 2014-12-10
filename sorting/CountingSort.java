package sorting;

/**
 * Counting sort assumes that each of the n input elements is an integer in the range 0 to k, for some integer k.
 * <br>When k = O(n) the sort runs in Θ(n) time.
 * <p/>
 * Created by GuoJunjun on 10.12.14.
 */
public class CountingSort {
    private static String ps;

    public static int[] sort(int[] A) {
        int[] B = new int[A.length];
        int k = maxelement(A) + 1;
        return sort(A, B, k);
    }

    /**
     * @param A
     *         array
     * @param k
     *         max element value
     *
     * @return
     */
    public static int[] sort(int[] A, int k) {
        int[] B = new int[A.length];
        return sort(A, B, k);
    }

    public static int maxelement(int[] a) {
        int max = -9999;
        for (int i : a) {
            if (max <= i) {
                max = i;
            }
        }
        return max;
    }

    /**
     * @param A
     *         input is an array A
     * @param B
     *         hold for the sorted output
     * @param k
     *         k >= the max element in A
     *
     * @return
     */
    public static int[] sort(int[] A, int[] B, int k) {
        ps = "input A:" + toString(A) + "\n";
        ps += "holderB:" + toString(B) + "\n";
        int[] C = new int[k];
        ps += "C      :" + toString(C) + "\n";
        //        for (int i = 0; i < k; i++) {
        //            C[i] = 0;
        //        }
        for (int j = 0; j < A.length; j++) {
            C[A[j]] += 1;// total number of this values
        }
        ps += "C1     :" + toString(C) + "\n";
        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        ps += "C2     :" + toString(C) + "\n";
        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            ps += "B-" + String.format("%-5d", (A.length - j)) + ":" + toString(B) + "\n";
            C[A[j]] -= 1;
            ps += "C-" + String.format("%-5d", (A.length - j) + 2) + ":" + toString(C) + "\n";
        }
        return B;
    }

    public static String toString(int a[]) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            s += String.format("%4d", a[i]);
        }
        return s;
    }

    public static String getProcess() {
        return ps;
    }
}
