package dataStructures;

public class InorderTraversal {
	private Node root;

	public InorderTraversal() {
		root = null;
	}

	public InorderTraversal(Object rootData, InorderTraversal left,
			InorderTraversal right) {
		root = new Node();
		root.data = rootData;
		root.left = left.root;
		root.right = right.root;
	}

	class Node {
		public Object data;
		public Node left;
		public Node right;
	}

	private static void inorder(Node n, Visitor v) {
		if (n == null) {
			return;
		}
		inorder(n.left, v);
		v.visit(n.data);
		inorder(n.right, v);
	}

	public void inorder(Visitor v) {
		inorder(root, v);
	}

	public static void main(String[] args) {

		InorderTraversal leaf, simon, fillip, tro, kari, father, jacob, therese, mother, grandpa;
		leaf = new InorderTraversal();
		simon = new InorderTraversal("Simon", leaf, leaf);
		fillip = new InorderTraversal("Fillip", leaf, leaf);
		tro = new InorderTraversal("Tro", simon, fillip);
		kari = new InorderTraversal("Kari", leaf, leaf);
		father = new InorderTraversal("Father", tro, kari);
		jacob = new InorderTraversal("Jacob", leaf, leaf);
		therese = new InorderTraversal("Therese", leaf, leaf);
		mother = new InorderTraversal("Mother", jacob, therese);
		grandpa = new InorderTraversal("Grandpa", father, mother);
		class TV implements Visitor {

			public String s;

			public TV() {
				init();
			}

			public void init() {
				s = "Inorder: ";
			}

			public void visit(Object data) {
				s += data.toString() + ", ";
			}
		}
		TV v = new TV();
		grandpa.inorder(v);
		System.out.println(v.s);
	}
}
