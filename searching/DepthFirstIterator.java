package searching;

import java.util.Stack;
import dataStructures.Tree.Node;

public class DepthFirstIterator {
	private Stack<Node> s;

	public DepthFirstIterator(Node root) {
		s = new Stack<Node>();
		if (root != null) {
			s.add(root);
		}
	}

	public boolean hasNext() {
		return s.size() > 0;
	}

	public Object next() {
		Node n = s.pop();
		for (int i = n.children.size() - 1; i >= 0; i--) {
			s.add(n.children.get(i));
		}
		return n.data;
	}
}
