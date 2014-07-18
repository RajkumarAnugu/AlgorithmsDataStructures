package dataStructures;

import java.util.NoSuchElementException;

/**
 * 
 * 18. jul. 2014
 * 
 * @author GuoJunjun
 *
 *         implement a stack as a sequence of nodes.
 */
public class LinkedListStack {
	private Node first;

	public LinkedListStack() {
		first = null; // constructs an empty stack.
	}

	public void push(Object element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
	}

	public Object pop() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		Object element = first.data;
		first = first.next;
		return element;
	}

	public Object peek() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	public boolean empty() {
		return first == null;
	}

	class Node {
		Object data;
		Node next;
	}
}
