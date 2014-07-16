package dataStructures;

import java.util.ListIterator;
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

	/**
	 * LinkedList class declares a private inner class LinkedListIterator, which
	 * implements our simplified ListIterator interface. Because
	 * LinkedListIterator is an inner class, it has access to the private
	 * features of the LinkedList class in particular, the instance variable
	 * first and the private Node class.
	 * 
	 */
	public ListIterator<?> listiterator() {
		return new LinkedListIterator();
	}

	class LinkedListIterator implements ListIterator<Object> {

		private Node position;
		private Node previous;
		private boolean isAfterNext;

		public LinkedListIterator() {
			position = null;
			previous = null;
			isAfterNext = false;
		}

		@Override
		public boolean hasNext() {
			if (position == null) {
				return first != null;
			} else {
				return position.next != null;
			}
		}

		/**
		 * the position reference is updated to position.next, and the old
		 * position is remembered in previous. The previous position is used for
		 * just one purpose: to remove the element if the remove method is
		 * called after the next method.
		 * There is a special case, however—if the iterator points before the
		 * first element of the list, then the old position is null, and
		 * position must be set to first
		 */
		@Override
		public Object next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			previous = position;
			isAfterNext = true;
			if (position == null) {
				position = first;
			} else {
				position = position.next;
			}
			return position.data;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			if (!isAfterNext) {
				throw new IllegalStateException();
			}
			if (position == first) {
				removeFirst();
			} else {
				previous.next = position.next;
			}
			position = previous;
			isAfterNext = false;
		}

		/**
		 * As with the remove method, a call to set is only valid if it was
		 * preceded by a call to the next method. We throw an exception if we
		 * find that there was a call to add or remove immediately before
		 * calling set.
		 */
		@Override
		public void set(Object e) {
			if (!isAfterNext) {
				throw new IllegalStateException();
			}
			position.data = e;
		}

		@Override
		public void add(Object e) {
			if (position == null) {
				addFirst(e);
				position = first;
			} else {
				Node newNode = new Node();
				newNode.data = e;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}
			isAfterNext = false;
		}

	}
}
