package dataStructures;

public class BinarySearchTree {
	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	//	public void add(Object obj) {
	//		Comparable<Object> object = (Comparable<Object>) obj;
	//		add(object);
	//	}

	public void add(Comparable object) {
		Node newNode = new Node();
		newNode.data = object;
		newNode.left = null;
		newNode.right = null;
		if (root == null) {
			root = newNode;
			System.out.println("	 ROOT: " + root.data);
		}
		root.addNode(newNode);
	}

	class Node {
		public Comparable data;
		public Node left;
		public Node right;

		/**
		 * 
		 * @param newNode
		 * 
		 *            If you encounter an on-null node reference,look at its
		 *            data value. If the data value of that node is larger than
		 *            the value you want to insert, continue the process with
		 *            the left child. If the node’s data value is smaller than
		 *            the one you want to insert, continue the process with the
		 *            right child. If the node’s data value is the same as the
		 *            one you want to insert, you are done, because a set does
		 *            not store duplicate values
		 */
		public void addNode(Node newNode) {
			int compare = newNode.data.compareTo(data);
			if (compare < 0) {
				if (left == null) {
					left = newNode;
					System.out.println("  left: " + left.data);
				} else {
					left.addNode(newNode);
				}
			} else if (compare > 0) {
				if (right == null) {
					right = newNode;
					System.out.println("  		right: " + right.data);
				} else {
					right.addNode(newNode);
				}
			}
		}

		public String toString() {
			return data.toString();
		}
	}

	private static String ss;

	private static String toString(Node n) {
		if (n == null) {
			return ss;
		}
		toString(n.left);
		ss += n.toString() + " ";
		toString(n.right);
		return ss;
	}

	public String toString() {
		ss = "";
		return toString(root);
	}

	public void print() {
		print(root);
		System.out.println();
	}

	private static void print(Node parent) {
		if (parent == null) {
			return;
		}
		print(parent.left);
		System.out.print(parent.data + " ");
		print(parent.right);
	}

	private static int height(Node n) {
		if (n == null) {
			return 0;
		} else {
			return 1 + Math.max(height(n.left), height(n.right));
		}
	}

	public int height() {
		return height(root);
	}

	/**
	 * 
	 * @param object
	 * @return result message
	 */
	public String remove(Object object) {
		// find node   to be removed
		Node toBeRemoved = root;
		Node parent = null;
		boolean found = false;
		while (!found && toBeRemoved != null) {
			int compare = toBeRemoved.data.compareTo(object);
			if (compare == 0) {
				found = true;
			} else {
				parent = toBeRemoved;
				if (compare > 0) {
					toBeRemoved = toBeRemoved.left;
				} else {
					toBeRemoved = toBeRemoved.right;
				}
			}
		}
		if (!found) {
			return object + "not found!";
		}

		// to be removed contains object
		// . . if one of the children is empty, use the other
		if (toBeRemoved.left == null || toBeRemoved.right == null) {
			// set newChild
			Node newChild;
			if (toBeRemoved.left == null) {
				newChild = toBeRemoved.right;
			} else {
				newChild = toBeRemoved.left;
			}
			// connect to newChild
			if (parent == null) {// found in root
				root = newChild;
			} else if (parent.left == toBeRemoved) {
				parent.left = newChild;
			} else {
				parent.right = newChild;
			}
			ss = "";
			return object + " removed!" + "\n" + "moved tree: " + "\n"
					+ toString(newChild);
		}
		// Neither subtree is empty
		// ... Find smallest element of the right subtree
		Node smallestParent = toBeRemoved;
		Node smallest = toBeRemoved.right;
		System.out.println("..sp: " + smallestParent + " s: " + smallest);
		while (smallest.left != null) {
			smallestParent = smallest;
			smallest = smallest.left;
			System.out.println("....sp: " + smallestParent + " s: " + smallest);
		}

		// smallest contains smallest child in right subtree

		// Move contents, unlink child
		toBeRemoved.data = smallest.data;
		if (smallestParent == toBeRemoved) {
			smallestParent.right = smallest.right;
			System.out
					.println("....=sp: " + smallestParent + " s: " + smallest);
		} else {
			smallestParent.left = smallest.right;
			System.out.println("....!=sp: " + smallestParent + " s: "
					+ smallest);
		}
		ss = "";
		return object + " removed!" + "\n" + "moved tree: " + "\n"
				+ toString(toBeRemoved.left);
	}
}
