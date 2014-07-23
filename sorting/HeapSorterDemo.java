package sorting;

import java.util.Arrays;

public class HeapSorterDemo {
	public static void main(String[] args) {
		int[] al = { 20, 75, 43, 84, 90, 57, 71, 96, 91, 93 };
		System.out.println(Arrays.toString(al));
		HeapSorter.sort(al);
		System.out.println(HeapSorter.getProcessString());
		System.out.println(Arrays.toString(al));
		System.out.println("\n ------- \n");
		int[] a = ArrayUtil.randomIntArray(10, 20);
		System.out.println(Arrays.toString(a));
		HeapSorter.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
