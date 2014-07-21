package searching;

import java.util.LinkedList;
import java.util.Queue;
import dataStructures.Tree.Node;

public class BreadthFirstIterator {
	private Queue<Node> q;

	public BreadthFirstIterator(Node root) {
		q = new LinkedList<Node>();
		if (root != null) {
			q.add(root);
		}
	}

	public boolean hasNext() {
		return q.size() > 0;
	}

	public Object next() {
		Node n = q.remove();
		for (Node c : n.children) {
			q.add(c);
		}
		return n.data;
	}
}
