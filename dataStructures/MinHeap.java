package dataStructures;

import java.util.ArrayList;

public class MinHeap {

	private ArrayList<Comparable> elements;

	public MinHeap() {
		elements = new ArrayList<Comparable>();
		elements.add(null);
	}

	public void add(Comparable newElement) {

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
	public Comparable peek() {
		return elements.get(1);
	}

	/**
	 * Removes the minimum element from this heap.
	 * 
	 * @return the minimum element
	 */
	public Comparable remove() { // the root
		Comparable minimum = peek(); //elements.get(1);

		// Remove last element
		int lastIndex = elements.size() - 1;
		Comparable last = elements.remove(lastIndex);

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
	 * Turns the tree back into a heap, provided only the root
	 * node violates the heap condition.
	 */
	private void fixHeap() {
		s += "\n" + "before fix: " + elements.toString();
		Comparable root = elements.get(1);

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
				Comparable child = getLeftChild(index);
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
					s += "\n" + "fix : " + elements.toString() + " index: "
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
	 * child nodes of the node with index i have index 2 · i
	 * and2·i+1, and the parent node of the node with index i has index i 2.
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
	private Comparable getLeftChild(int index) {
		return elements.get(2 * index);
	}

	/**
	 * Returns the value of the right child.
	 * 
	 * @param index
	 *            the index of a node in this heap
	 * @return the value of the right child of the given node
	 */
	private Comparable getRightChild(int index) {
		return elements.get(2 * index + 1);
	}

	/**
	 * Returns the value of the parent.
	 * 
	 * @param index
	 *            the index of a node in this heap
	 * @return the value of the parent of the given node
	 */
	private Comparable getParent(int index) {
		return elements.get(index / 2);
	}

	public ArrayList<Comparable> getElements() {
		return elements;
	}
}
