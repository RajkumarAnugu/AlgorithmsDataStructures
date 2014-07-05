package sorting;

public class Test {

	public static void main(String[] args) {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 11 };
		QuickSort.sort(a);
		System.out.println(QuickSort.toString(a));
	}
}
