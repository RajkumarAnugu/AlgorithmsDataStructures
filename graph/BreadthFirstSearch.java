package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS page 595
 * 
 * @author GuoJunjun
 * 
 */
public class BreadthFirstSearch {
	private Node graph;

	public BreadthFirstSearch(String filename) {
		graph = GenerateGraph.getGraph(filename);
	}

	/**
	 * @return the graph
	 */
	public Node getGraph() {
		return graph;
	}

	/**
	 * 
	 * @return tree
	 *         <p>
	 *         transform a cycle & undirected graph into to a tree
	 */
	public Node getTree() {
		Node root = getGraph();
		root.color = "GRAY";
		root.distance = 0;
		root.setParent(null);
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (q.size() != 0) {
			Node u = q.remove();
			// System.out.println(u);
			// copy children to a array list
			ArrayList<Node> children = u.getChildren();
			/*
			 * delete children from parent; if one children has more than one
			 * parent tree will become a graph again(may cycle again)
			 */
			u.setChildren(new ArrayList<Node>());
			for (int i = 0; i < children.size(); i++) {
				Node v = children.get(i);
				if (v.color == "WHITE") {
					v.color = "GRAY";
					v.distance = u.distance + 1;
					v.setParent(u);
					u.addChild(v);
					q.add(v);
					System.out.println(v);
				}
			}
			u.color = "BLACK";
			System.out.println(u);
		}
		return root;
	}

	/**
	 * 
	 * @param tree
	 *            <p>
	 *            use a recursion method to print every node of the tree
	 */
	public static void printTree(Node tree) {
		// if (tree.getChildren().size() == 0) return;
		System.out.println(tree);
		for (Node v : tree.getChildren()) {
			printTree(v);
		}
	}

	/**
	 * 
	 * @param tree
	 *            <p>
	 *            use a queue to help to check all the node of the tree
	 */
	public static void printTreeQ(Node tree) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(tree);
		while (q.size() != 0) {
			Node u = q.remove();
			System.out.println(u);
			for (Node n : u.getChildren()) {
				System.out.println("n" + n);
				q.add(n);
			}
		}
	}

	/**
	 * 
	 * @param args
	 * 
	 *            main method to run test
	 */
	public static void main(String[] args) {
		BreadthFirstSearch bfs = new BreadthFirstSearch("figure221c");
		Node tree = bfs.getTree();
		System.out.println("\n ----------- \nTree size: " + tree.size());
		printTree(tree);
	}
}
