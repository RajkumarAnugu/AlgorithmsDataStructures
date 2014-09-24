package dataStructures;

import java.util.ArrayList;

/**
 * 
 * a heap is a specialized tree-based data structure that satisfies the
 * heap property:
 * - If A is a parent node of B then the key of node A is ordered with
 * respect to the key of node B with the same ordering applying across
 * the heap.
 *
 * - Either the keys of parent nodes are always greater than or equal to
 * those of the children and the highest key is in the root node (this
 * kind of heap is called max heap)
 *
 * - or the keys of parent nodes are less than or equal to those of the
 * children and the lowest key is in the root node (min heap).
 *
 * Heaps are crucial in several efficient graph algorithms such as
 * Dijkstra's algorithm, and in the sorting algorithm heapsort.
 *
 * A common implementation of a heap is the binary heap, in which the
 * tree is a complete binary tree.
 *
 * n a heap the highest (or lowest) priority element is always stored at
 * the root, hence the name heap.
 *
 * A heap is not a sorted structure and can be regarded as partially
 * ordered.
 * As visible from the Heap-diagram, there is no particular relationship
 * among nodes on any given level, even among the siblings.
 *
 * When a heap is a complete binary tree, it has a smallest possible
 * height - a heap with N nodes always has O(log N) height.
 *
 * A heap is a useful data structure when you need to remove the object
 * with the highest (or lowest) priority.
 */
public class MinHeap {

	private ArrayList<Comparable<Object>> elements;

	public MinHeap() {
		elements = new ArrayList<Comparable<Object>>();
		elements.add(null);
	}

	@SuppressWarnings("unchecked")
	public void add(String object) {
		// cast String object to Object object
		// cat Object object to Comparable<Object> object
		add((Comparable<Object>) (Object) object);
	}

	public void add(Comparable<Object> newElement) {

		// add a new leaf
		elements.add(null);
		int index = elements.size() - 1;

		// Demote parents that are larger than the new element

		while (index > 1 && getParent(index).compareTo(newElement) > 0) {
			elements.set(index, getParent(index));
			index = getParentIndex(index);
		}

		// Store the new element into the vacant slot
		elements.set(index, newElement);
	}

	/**
	 * Gets the minimum element stored in this heap.
	 * 
	 * @return the minimum element
	 */
	public Comparable<Object> peek() {
		return elements.get(1);
	}

	/**
	 * Removes the minimum element from this heap.
	 * 
	 * @return the minimum element
	 */
	public Comparable<Object> remove() { // the root
		Comparable<Object> minimum = peek(); // elements.get(1);

		// Remove last element
		int lastIndex = elements.size() - 1;
		Comparable<Object> last = elements.remove(lastIndex);

		if (lastIndex > 1) {
			elements.set(1, last);
			fixHeap();
		}

		return minimum;
	}

	private String s = "";

	public String getFixHeapString() {
		return s;
	}

	/**
	 * Turns the tree back into a heap, provided only the root node violates the
	 * heap condition.
	 */
	private void fixHeap() {
		s += "\n" + "before fix: " + elements.toString();
		Comparable<Object> root = elements.get(1);

		int lastIndex = elements.size() - 1;
		// Promote children of removed root while they are smaller than last

		int index = 1;
		boolean more = true;
		while (more) {
			int childIndex = getLeftChildIndex(index);
			s += "\n" + "fix childIndex: " + childIndex;
			if (childIndex <= lastIndex) {
				// Get smaller child

				// Get left child first
				Comparable<Object> child = getLeftChild(index);
				s += "\n" + "fix child: " + child + " ROOT: " + root;
				// Use right child instead if it is smaller
				if (getRightChildIndex(index) <= lastIndex
						&& getRightChild(index).compareTo(child) < 0) {
					childIndex = getRightChildIndex(index);
					child = getRightChild(index);
					s += "\n" + "fix -childIndex: " + childIndex;
					s += "\n" + "fix -child: " + child + " ROOT: " + root;
				}

				// Check if larger child is smaller than root
				if (child.compareTo(root) < 0) {
					// Promote child
					elements.set(index, child);
					index = childIndex;
					s +=
							"\n" + "fix : " + elements.toString() + " index: "
									+ index + " ROOT: " + root;
				} else {
					// Root is smaller than both children
					more = false;
				}
			} else {
				// No children
				more = false;
			}
		}

		// Store root element in vacant slot
		elements.set(index, root);
		s += "\n" + "Fix: " + elements.toString();
	}

	/**
	 * Checks whether this heap is empty.
	 */
	public boolean empty() {
		return elements.size() == 1;
	}

	/**
	 * For convenience, we leave the 0 element of the array empty. Then the
	 * child nodes of the node with index i have index 2 · i and2·i+1, and the
	 * parent node of the node with index i has index i 2.
	 */

	/**
	 * Returns the index of the left child.
	 * 
	 * @param index
	 *            the index of a node in this heap
	 * @return the index of the left child of the given node
	 */
	private static int getLeftChildIndex(int index) {
		return 2 * index;
	}

	/**
	 * Returns the index of the right child.
	 * 
	 * @param index
	 *            the index of a node in this heap
	 * @return the index of the right child of the given node
	 */
	private static int getRightChildIndex(int index) {
		return 2 * index + 1;
	}

	/**
	 * Returns the index of the parent.
	 * 
	 * @param index
	 *            the index of a node in this heap
	 * @return the index of the parent of the given node
	 */
	private static int getParentIndex(int index) {
		return index / 2;
	}

	/**
	 * Returns the value of the left child.
	 * 
	 * @param index
	 *            the index of a node in this heap
	 * @return the value of the left child of the given node
	 */
	private Comparable<Object> getLeftChild(int index) {
		return elements.get(2 * index);
	}

	/**
	 * Returns the value of the right child.
	 * 
	 * @param index
	 *            the index of a node in this heap
	 * @return the value of the right child of the given node
	 */
	private Comparable<Object> getRightChild(int index) {
		return elements.get(2 * index + 1);
	}

	/**
	 * Returns the value of the parent.
	 * 
	 * @param index
	 *            the index of a node in this heap
	 * @return the value of the parent of the given node
	 */
	private Comparable<Object> getParent(int index) {
		return elements.get(index / 2);
	}

	public ArrayList<Comparable<Object>> getElements() {
		return elements;
	}
}
