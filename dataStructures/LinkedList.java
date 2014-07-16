package dataStructures;

import java.util.NoSuchElementException;

/**
 * A linked list object holds a reference to the first node, and each node holds
 * a reference to the next node.
 **/
public class LinkedList {
	private Node first;

	public LinkedList() {
		first = null;
	}

	public Object getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	/**
	 * When a new node is added, it becomes the head of the list, and the node
	 * that was the old list head becomes its next node
	 * 
	 * @param element
	 */
	public void addFirst(Object element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
	}

	/**
	 * The data of the first node are saved and later returned as the method
	 * result. The successor of the first node becomes the first node of the
	 * shorter list. Then there are no further references to the
	 * old node, and the garbage collector will eventually recycle it.
	 * 
	 * @return data of the original first
	 */
	public Object removeFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		Object element = first.data;
		first = first.next;
		return element;
	}

	/**
	 * 
	 * An inner class is a class that is defined inside another class. The
	 * methods of the outer class can access the public features of the inner
	 * class.
	 */
	class Node {
		public Object data;
		public Node next;
	}

}
