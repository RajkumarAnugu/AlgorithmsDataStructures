package searching;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import dataStructures.Tree;
import dataStructures.Tree.Node;

/**
 * 
 * 21. jul. 2014
 * 
 * @author GuoJunjun
 *         Breadth First treeSearch
 *         &
 *         Depth First Search
 *
 */
public class BDSearches {
	private Node root;
	private DataListener v;
	private String breadFirst, depthFirst;
	private Object searchData;

	public BDSearches(Tree tree) {
		root = tree.getNode();
	}

	public BDSearches(Tree tree, Object searchData) {
		root = tree.getNode();
		v = new DataListener(searchData);
		this.searchData = searchData;
	}

	public String breadFirst(Object searchData) {
		v = new DataListener(searchData);
		this.searchData = searchData;
		return getBreadFirstS();
	}

	public void breadFirst() {
		breadFirst = "Bread-First-Search: ";
		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		boolean found = false;
		while (!found && q.size() > 0) {
			Node n = q.remove();
			found = v.visit(n.data);
			breadFirst += n.data.toString() + ", ";
			if (!found) {
				for (Node c : n.children) {
					q.add(c);
				}
			}
		}
		if (!found && q.size() == 0) {
			breadFirst += "\n" + "Sorry!" + this.searchData + " NOT Found!! !";
		} else {
			breadFirst += "\n" + "Found: " + this.searchData;
		}
	}

	public String depthFirst(Object searchData) {
		this.searchData = searchData;
		v = new DataListener(searchData);
		return getDepthFirstS();
	}

	public void depthFirst() {
		depthFirst = "Depth-First-Search: ";
		if (root == null) {
			return;
		}
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		boolean found = false;
		while (!found && s.size() > 0) {
			Node n = s.pop();
			found = v.visit(n.data);
			depthFirst += n.data.toString() + ", ";
			if (!found) {
				for (int i = n.children.size() - 1; i >= 0; i--) {
					s.add(n.children.get(i));
				}
			}
		}
		if (!found && s.size() == 0) {
			depthFirst += "\n" + "Sorry! " + this.searchData + " NOT Found!!";
		} else {
			depthFirst += "\n" + "Found: " + this.searchData;
		}
	}

	public String getBreadFirstS() {
		breadFirst();
		return breadFirst;
	}

	public String getDepthFirstS() {
		depthFirst();
		return depthFirst;
	}
}
