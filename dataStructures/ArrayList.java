package dataStructures;

public class ArrayList {
	private Object[] elements;
	private int currentSize;

	public ArrayList() {
		final int INITIAL_SIZE = 10;
		elements = new Object[INITIAL_SIZE];
		currentSize = 0;
	}

	public int size() {
		return currentSize;
	}

	public void checkBounds(int n) {
		if (n < 0 || n > currentSize) {
			throw new IndexOutOfBoundsException();
		}
	}

	public Object get(int pos) {
		checkBounds(pos);
		return elements[pos];
	}

	public void set(int pos, Object element) {
		this.elements[pos] = element;
	}

	/**
	 * If we assume that removal happens at random locations, then on average,
	 * each removal moves n / 2 elements, where n is the size of the array
	 * list.
	 * 
	 * Inserting or removing an array list element is an O(n) operation.
	 * 
	 * @param pos
	 * @return
	 */
	public Object remove(int pos) {
		checkBounds(pos);
		Object removed = elements[pos];
		for (int i = pos + 1; i < currentSize; i++) {
			elements[i - 1] = elements[i];
		}
		currentSize--;
		return removed;
	}

	public boolean addLast(Object newElement) {
		/**
		 * If there is no more room in the internal array, then we need to grow
		 * it. That is the topic of the next section.
		 */
		growIfNecessary();
		currentSize++;
		elements[currentSize - 1] = newElement;
		return true;
	}

	private void growIfNecessary() {
		if (currentSize == elements.length) {
			Object[] newElements = new Object[2 * elements.length];
			for (int i = 0; i < elements.length; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
		}
	}
}
