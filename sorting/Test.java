package sorting;

public class Test {

    public static void main(String[] args) {
        //		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 11 };
        //        int[] a = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        //                int[] a = {2, 8, 7, 1, 3, 5, 6, 4};
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort.sort(a);
        System.out.println("	   " + QuickSort.toString(a));
        //		for (int i = 0; i < 10; i++) {
        //			System.out.println(i/2);
        //		}
    }
}
