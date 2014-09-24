package sorting;

/**
 * In computer science, merge sort (also commonly spelled mergesort) is an O(n
 * log n) comparison-based sorting algorithm. Most implementations produce a
 * stable sort, which means that the implementation preserves the input order of
 * equal elements in the sorted output. Mergesort is a divide and conquer
 * algorithm that was invented by John von Neumann in 1945. A detailed
 * description and analysis of bottom-up mergesort appeared in a report by
 * Goldstine and Neumann as early as 1948.
 * 
 * 
 * Conceptually, a merge sort works as follows:
 * 
 * Divide the unsorted list into n sublists, each containing 1 element (a list
 * of 1 element is considered sorted).
 * Repeatedly merge sublists to produce new sorted sublists until there is only
 * 1 sublist remaining. This will be the sorted list.
 */
public class MergeSort {

	public static void sort(int[] a) {
		if (a.length <= 1) {
			return;
		}
		int[] first = new int[a.length / 2];
		int[] second = new int[a.length - first.length];
		for (int i = 0; i < first.length; i++) {
			first[i] = a[i];
		}
		for (int i = 0; i < second.length; i++) {
			second[i] = a[first.length + i];
		}
		System.out.println("first : " + MergeSort.toString(first));
		sort(first);
		System.out.println("second: " + MergeSort.toString(second));
		sort(second);
		System.out.println("merge!");
		merge(first, second, a);
		System.out.println("Merge: ");
		System.out.println("    first : " + MergeSort.toString(first));
		System.out.println("    second: " + MergeSort.toString(second));
		System.out.println("    a     : " + MergeSort.toString(a));
	}

	private static void merge(int[] first, int[] second, int[] a) {
		int iFirst = 0, iSecond = 0, j = 0;
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst] < second[iSecond]) {
				a[j] = first[iFirst];
				iFirst++;
			} else {
				a[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}
		while (iFirst < first.length) {
			a[j] = first[iFirst];
			iFirst++;
			j++;
		}
		while (iSecond < second.length) {
			a[j] = second[iSecond];
			iSecond++;
			j++;
		}
	}

	public static String toString(int[] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s += a[i] + ", ";
		}
		return s;
	}

	// public static void main(String[] args) {
	// int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 11 };
	// MergeSort.sort(a);
	// System.out.println(MergeSort.toString(a));
	// }
}
