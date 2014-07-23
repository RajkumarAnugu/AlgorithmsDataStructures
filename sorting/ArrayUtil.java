package sorting;

import java.util.Random;

public class ArrayUtil {
	private static Random generator = new Random();

	/**
	 * 
	 * @param length
	 *            of the array
	 * @param n
	 *            the number of possible random values
	 * @return an array filled with length number between 0 & n-1;
	 */
	public static int[] randomIntArray(int length, int n) {
		int[] a = new int[length];
		for (int i = 0; i < a.length; i++) {
			a[i] = generator.nextInt(n);
		}
		return a;
	}

	/**
	 * Swaps two entries of an array.
	 * 
	 * @param array
	 * @param first
	 *            position
	 * @param second
	 *            position
	 */
	public static void swap(int[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}
