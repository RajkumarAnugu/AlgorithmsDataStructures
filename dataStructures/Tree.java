package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	private Node root;

	class Node {
		public Object data;
		public List<Node> children;

		public int size() {
			int sum = 0;
			for (Node child : children) {
				sum += child.size();
			}
			return 1 + sum;
		}

		public String tString() {
			relation++;
			System.out.println("relation: " + relation);
			String s = "";
			for (Node child : root.children) {
				s += relation + " " + (String) child.data + "\n";
					s += child.tString();
			}
			return s;

		}

		public Object getObject() {
			return data;
		}

		public List<Node> getChildren() {
			return children;
		}

	}

	public int getSize() {
		return root.size();
	}

	public Tree(Object rootData) {
		root = new Node();
		root.data = rootData;
		root.children = new ArrayList<Node>();
	}

	public void addSubtree(Tree subtree) {
		root.children.add(subtree.root);
	}

	private int relation;

	public String toString() {
		relation = 0;
		String s = relation + " " + root.data + "\n";
		return s + root.tString();
	}

	public Node getNode() {
		return root;
	}
}
