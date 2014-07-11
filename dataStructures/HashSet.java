package dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashSet {
	private Node[] buckets;
	private int currentSize;
	private String outprint="";

	/**
	 * Constructs a hash table.
	 * 
	 * @param bucketsLength
	 */
	public HashSet(int bucketsLength) {
		buckets = new Node[bucketsLength];
		currentSize = 0;
		outprint+="create HashSet object\n";
	}

	public boolean contains(Object x) {
		outprint+="boolean contains Object x\n";
		int h = x.hashCode();
		outprint+="    x.hashCode: "+h+"\n";
		if (h < 0) {
			h = -h;
		}
		h = h % buckets.length;
		outprint+="    x.hashCode%buckets.length: "+h+"\n";
		Node current = buckets[h];
		while (current != null) {
			if (current.data.equals(x)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/**
	 * Adds an element to this set.
	 * 
	 * @param x
	 * @return true x is a new object, false x was already in the set
	 */
	public boolean add(Object x) {
		outprint+="boolean add Object x\n";
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % buckets.length;
		Node current = buckets[h];
		while (current != null) {
			if (current.data.equals(x)) {
				return false;
			}
			current = current.next;
		}
		Node newNode = new Node();
		newNode.data = x;
		newNode.next = buckets[h];
		buckets[h] = newNode;
		currentSize++;
		return true;
	}

	/**
	 * Removes an object from this set.
	 * 
	 * @param x
	 *            an object
	 * @return true x was removed; false x was not an element of this set
	 */
	public boolean remove(Object x) {
		outprint+="boolean remove Object x\n";
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % buckets.length;

		Node current = buckets[h];
		Node previous = null;
		while (current != null) {
			if (current.data.equals(x)) {
				if (previous == null) {
					buckets[h] = current.next;
				} else {
					previous.next = current.next;
				}
				currentSize--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}

	public Iterator<?> iterator() {
		outprint+="iterator()\n";
		return new HashSetIterator();
	}

	public int size() {
		return currentSize;
	}

	class Node {
		//outprint+="create Node\n";
		public Object data;
		public Node next;
	}

	class HashSetIterator implements Iterator<Object> {
		
		private int bucketIndex;
		private Node current;
		//outprint+="HashSetIterator implements Iterator\n";
		public HashSetIterator() {
			current = null;
			bucketIndex = -1;
		}

		public boolean hasNext() {
			if (current != null && current.next != null) {
				return true;
			}
			for (int b = bucketIndex + 1; b < buckets.length; b++) {
				if (buckets[b] != null) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public Object next() {
			if (current != null && current.next != null) {
				current = current.next; // Move to next element in bucket
			} else { // Move to next bucket
				do {
					bucketIndex++;
					if (bucketIndex == buckets.length) {
						throw new NoSuchElementException();
					}
					current = buckets[bucketIndex];
				} while (current == null);
			}
			return current.data;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public String getOutprint(){
		return outprint;
	}
}