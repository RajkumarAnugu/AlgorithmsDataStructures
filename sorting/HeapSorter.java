package sorting;

import java.util.Arrays;

/**
 * 
 * 23. jul. 2014
 * sort an array using the heap sort algorithm.
 * 
 * The heapsort algorithm is based on inserting elements into a heap and
 * removing them in sorted order.
 * 
 * 
 * Heapsort algorithm:
 * First insert all elements to be sorted into the heap, then keep extracting
 * the minimum.
 * 
 * This algorithm is an O(n log(n)) algorithm: each insertion and removal is
 * O(log(n)), and these steps are repeated n times, once for each element in the
 * sequence that is to be sorted.
 * 
 * 
 */
public class HeapSorter {
	/**
	 * Sorts an array, using selection sort.
	 * 
	 * @param array
	 *            to sort
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
			fixHeap(array, i, n);
			processString += "fixHeap: " + Arrays.toString(array) + " pos: "
					+ i + " lastPos: " + n + "\n";
		}
		while (n > 0) {
			ArrayUtil.swap(array, 0, n);
			processString += "   swap: " + Arrays.toString(array) + " pos: 0"
					+ " lastPos: " + n + "\n";
			n--;
			fixHeap(array, 0, n);
			processString += "fixHeap: " + Arrays.toString(array) + " pos: 0"
					+ " lastPos: " + n + "\n";
		}
	}

	/**
	 * 
	 * @param a
	 * @param rootIndex
	 * @param lastIndex
	 * 
	 * 
	 * 
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
				if (rightChildIndex <= lastIndex
						&& a[rightChildIndex] > a[childIndex]) {
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
