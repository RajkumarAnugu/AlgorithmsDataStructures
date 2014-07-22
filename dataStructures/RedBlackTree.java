package dataStructures;

/**
 * 
 * 22. jul. 2014
 * 
 *
 * insertion and removal in a binary search tree are O(log(n))
 * operations provided that the tree is balanced. In red-black trees, a
 * special kind of binary search tree that rebalances itself after each
 * insertion or removal. With red-black trees, we can guarantee
 * efficiency of these operations. In fact, the Java Collections
 * framework uses red-black trees to implement tree sets and tree maps.
 * 
 * 
 */
public class RedBlackTree {
	public Node root;
	static final int BLACK = 1;
	static final int RED = 0;
	private static final int NEGATIVE_RED = -1;
	private static final int DOUBLE_BLACK = 2;

	public RedBlackTree() {
		root = null;
	}

	/**
	 * 
	 * @param object
	 *            insert a new node into the tree
	 */
	public void add(Comparable object) {
		Node newNode = new Node();
		newNode.data = object;
		newNode.left = null;
		newNode.right = null;
		if (root == null) {
			root = newNode;
		} else {
			root.addNode(newNode);
		}
		fixAfterAdd(newNode);
	}

	/**
	 * 
	 * @param object
	 * @return true if object is contained in the tree
	 */
	public boolean find(Comparable object) {
		Node current = root;
		while (current != null) {
			int d = current.data.compareTo(object);
			if (d == 0) {
				return true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	public void remove(Comparable object) {
		// find node to be removed

		Node toBeRemoved = root;
		boolean found = false;
		while (!found && toBeRemoved != null) {
			int d = toBeRemoved.data.compareTo(object);
			if (d == 0) {
				found = true;
			} else {
				if (d > 0) {
					toBeRemoved = toBeRemoved.left;
				} else {
					toBeRemoved = toBeRemoved.right;
				}
			}
		}
		if (!found) {
			return;
		}

		// toBeRemoved contains object

		// If one of the children is empty, use the other

		if (toBeRemoved.left == null || toBeRemoved.right == null) {
			Node newChild;
			if (toBeRemoved.left == null) {
				newChild = toBeRemoved.right;
			} else {
				newChild = toBeRemoved.left;
			}
			fixBeforeRemove(toBeRemoved);
			replaceWith(toBeRemoved, newChild);
			return;
		}

		// both subtree has child

		// find smallest element of the right subtree

		Node smallest = toBeRemoved.right;
		while (smallest.left != null) {
			smallest = smallest.left;
		}

		// smallest contains smallest child in right subtree

		// move contents, unlink child

		toBeRemoved.data = smallest.data;
		fixBeforeRemove(smallest);
		replaceWith(smallest, smallest.right);
	}

	/**
	 * @return inordered iterms;
	 */
	public String toString() {
		return toString(root);
	}

	/**
	 * 
	 * @param parent
	 * @return inordered items
	 */
	private static String toString(Node parent) {
		if (parent == null) {
			return "";
		}
		return toString(parent.left) + parent.data + " "
				+ toString(parent.right);
	}

	public String cString() {
		return cString(root);
	}

	private static String cString(Node parent) {
		if (parent == null) {
			return "";
		}
		return cString(parent.left) + parent.data + "-" + parent.getColor()
				+ " " + cString(parent.right);
	}

	public static class Node {
		public Comparable data;
		public Node left;
		public Node right;
		public Node parent;
		public int color;

		/**
		 * constructs a red node with no data;
		 * 
		 */
		public Node() {
		}

		public String getColor() {
			String s = "";
			switch (color) {
				case 1:
					s = "BLACK";
					break;
				case 0:
					s = "RED";
					break;
				case -1:
					s = "NEGATIVE_RED";
					break;
				case 2:
					s = "DOUBLE_BLACK";
					break;
			}

			return s;
		}

		/**
		 * sets the left child and updates its parent reference
		 * 
		 * @param child
		 */
		public void setLeftChild(Node child) {
			left = child;
			if (child != null) {
				child.parent = this;
			}
		}

		public void setRightChild(Node child) {
			right = child;
			if (child != null) {
				child.parent = this;
			}
		}

		/**
		 * inserts a new node as a descendant of this node;
		 * 
		 * @param n
		 */
		public void addNode(Node n) {
			int compare = n.data.compareTo(data);
			if (compare < 0) {
				if (left == null) {
					left = n;
					left.parent = this;
				} else {
					left.addNode(n);
				}
			} else if (compare > 0) {
				if (right == null) {
					right = n;
					right.parent = this;
				} else {
					right.addNode(n);
				}
			}
		}
	}

	/**
	 * restores the tree to a red black tree after a node has been added
	 * 
	 * @param n
	 *            node n
	 */
	public void fixAfterAdd(Node n) {
		if (n.parent == null) {//root
			n.color = BLACK;
		} else {
			n.color = RED;
			if (n.parent.color == RED) {
				fixDoubleRed(n);
			}
		}
	}

	/**
	 * fixes a double red violation (four possible configurations )
	 * 
	 * @param child
	 *            child with a red parent
	 */
	public void fixDoubleRed(Node child) {
		Node parent = child.parent;
		Node grandParent = parent.parent;
		if (grandParent == null) {// parent was root
			parent.color = BLACK;
			return;
		}

		Node n1, n2, n3, t1, t2, t3, t4;

		if (parent == grandParent.left) {// parent at left
			n3 = grandParent;
			t4 = grandParent.right;
			if (child == parent.left) {// child at left 
				n1 = child;
				n2 = parent;
				t1 = child.left;
				t2 = child.right;
				t3 = parent.right;
			} else {
				n1 = parent;
				n2 = child;
				t1 = parent.left;
				t2 = child.left;
				t3 = child.right;
			}
		} else {// parent == grandParent.right
			n1 = grandParent;
			t1 = grandParent.left;
			if (child == parent.left) {
				n2 = child;
				n3 = parent;
				t2 = child.left;
				t3 = child.right;
				t4 = parent.right;
			} else {
				n2 = parent;
				n3 = child;
				t2 = parent.left;
				t3 = child.left;
				t4 = child.right;
			}
		}
		replaceWith(grandParent, n2);// replace 
		// set new link
		n1.setLeftChild(t1);
		n1.setRightChild(t2);
		n2.setLeftChild(n1);
		n2.setRightChild(n3);
		n3.setLeftChild(t3);
		n3.setRightChild(t4);
		n2.color = grandParent.color - 1;
		n1.color = BLACK;
		n3.color = BLACK;

		if (n2 == root) {
			root.color = BLACK;
		} else if (n2.color == RED && n2.parent.color == RED) {
			fixDoubleRed(n2);
		}
	}

	/**
	 * fixes the tree so that it is a red-black tree after a node has been
	 * removed
	 * 
	 * @param toBeRemoved
	 */
	public void fixBeforeRemove(Node toBeRemoved) {
		if (toBeRemoved.color == RED) {
			return;
		}
		if (toBeRemoved.left != null || toBeRemoved.right != null) {// it's no a leaf
			//Color the child black
			if (toBeRemoved.left == null) {
				toBeRemoved.right.color = BLACK;
			} else {
				toBeRemoved.left.color = BLACK;
			}
		} else {
			bubbleUp(toBeRemoved.parent);
		}
	}

	private void bubbleUp(Node parent) {
		if (parent == null) {
			return;
		}
		parent.color++;
		parent.left.color--;
		parent.right.color--;

		if (bubbleUpFix(parent.left)) {
			return;
		}
		if (bubbleUpFix(parent.right)) {
			return;
		}
		if (parent.color == DOUBLE_BLACK) {
			if (parent.parent == null) {
				parent.color = BLACK;
			} else {
				bubbleUp(parent.parent);
			}
		}
	}

	/**
	 * fixes negative red or double red violation
	 * 
	 * @param child
	 *            check for negative red or double red violations
	 * @return true if the tree was fixed
	 */
	private boolean bubbleUpFix(Node child) {
		if (child.color == NEGATIVE_RED) {
			fixNegativeRed(child);
			return true;
		} else if (child.color == RED) {
			if (child.left != null && child.left.color == RED) {
				fixDoubleRed(child.left);
				return true;
			}
			if (child.right != null && child.right.color == RED) {
				fixDoubleRed(child.right);
				return true;
			}
		}
		return false;
	}

	/**
	 * updates the parent's and replacement node's links when this node is
	 * replaced.
	 * updates the root reference if it is replaced;
	 * 
	 * @param toBeReplaced
	 *            ; to be replaced node
	 * @param replacement
	 *            ; replacement node
	 */
	public void replaceWith(Node toBeReplaced, Node replacement) {
		if (toBeReplaced.parent == null) {// is root
			replacement.parent = null;
			root = replacement;
		} else if (toBeReplaced == toBeReplaced.parent.left) {//tBR is a left node
			toBeReplaced.parent.setLeftChild(replacement);
		} else {//tBR is right node
			toBeReplaced.parent.setRightChild(replacement);
		}
	}

	/**
	 * fixes a negative red violation
	 * 
	 * @param negRed
	 */
	private void fixNegativeRed(Node negRed) {
		Node parent = negRed.parent;
		Node child;
		if (parent.left == negRed) {
			Node n1 = negRed.left;
			Node n2 = negRed;
			Node n3 = negRed.right;
			Node n4 = parent;
			Node t1 = n3.left;
			Node t2 = n3.right;
			Node t3 = n4.right;
			n1.color = RED;
			n2.color = BLACK;
			n4.color = BLACK;

			replaceWith(n4, n3);
			n3.setLeftChild(n2);
			n3.setRightChild(n4);
			n2.setLeftChild(n1);
			n2.setRightChild(t1);
			n4.setLeftChild(t2);
			n4.setRightChild(t3);

			child = n1;
		} else // Mirror image
		{
			Node n4 = negRed.right;
			Node n3 = negRed;
			Node n2 = negRed.left;
			Node n1 = parent;
			Node t3 = n2.right;
			Node t2 = n2.left;
			Node t1 = n1.left;
			n4.color = RED;
			n3.color = BLACK;
			n1.color = BLACK;

			replaceWith(n1, n2);
			n2.setRightChild(n3);
			n2.setLeftChild(n1);
			n3.setRightChild(n4);
			n3.setLeftChild(t3);
			n1.setRightChild(t2);
			n1.setLeftChild(t1);

			child = n4;
		}

		if (child.left != null && child.left.color == RED) {
			fixDoubleRed(child.left);
		} else if (child.right != null && child.right.color == RED) {
			fixDoubleRed(child.right);
		}
	}
}