package dataStructures;

import java.util.NoSuchElementException;

/**
 * 
 * 18. jul. 2014
 * 
 * @author GuoJunjun
 *
 *         implement a queue as a circular array.
 */
public class CircularArrayQueue {
	private Object[] elements;
	private int currentSize, head, tail;

	public CircularArrayQueue() {
		final int INITIAL_SIZE = 5;
		elements = new Object[INITIAL_SIZE];
		currentSize = 0;
		head = 0;
		tail = 0;
	}

	public boolean empty() {
		return currentSize == 0;
	}

	public void add(Object newElement) {
		growIfNecessary();
		currentSize++;
		elements[tail] = newElement;
		tail = (tail + 1) % elements.length;
	}

	public Object remove() {
		if (currentSize == 0) {
			throw new NoSuchElementException();
		}
		Object removed = elements[head];// remove element form head of queue
		head = (head + 1) % elements.length; // head move to next
		currentSize--; // size - 1
		return removed;
	}

	private void growIfNecessary() {
		if (currentSize == elements.length) {
			Object[] newElements = new Object[2 * elements.length];
			for (int i = 0; i < elements.length; i++) {
				newElements[i] = elements[(head + i) % elements.length];
			}
			elements = newElements;
			head = 0;
			tail = currentSize;
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < elements.length; i++) {
			s += elements[i] + ", ";
		}
		return s;
	}
}
