package sorting;

public class QuickSort {

	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	public static void sort(int[] a, int from, int to) {
		if (from >= to) {
			return;
		}
		int p = partition(a, from, to);
		System.out.println("p: " + p);
		System.out.println("sort(a,from,p)");
		sort(a, from, p);
		System.out.println("a: " + QuickSort.toString(a));
		System.out.println("sort(a,p+1,to)");
		sort(a, p + 1, to);
		System.out.println("a: " + QuickSort.toString(a));
	}

	public static int partition(int[] a, int from, int to) {
		int pivot = a[from];
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
				a = mySwap(a, i, j);
			}
		}
		return j;
	}

	public static int[] mySwap(int[] a, int i, int j) {
		System.out.println("swap : " + QuickSort.toString(a));
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
