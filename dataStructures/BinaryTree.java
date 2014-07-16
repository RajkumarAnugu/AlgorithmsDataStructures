package dataStructures;

public class BinaryTree {
	private Node root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(Object rootData, BinaryTree left, BinaryTree right) {
		root = new Node();
		root.data = rootData;
		root.left = left.root;
		root.right = right.root;
	}

	class Node {
		public Object data;
		public Node left;
		public Node right;
		
		public Node getLeft(){
			return left;
		}
		public Node getRight(){
			return right;
		}
		public Object getData(){
			return data;
		}
	}
	public Node getLeft(){
		return root.getLeft();
	}
	public Node getRight(){
		return root.getRight();
	}
	private static int height(Node n) {
		if (n == null) {
			return 0;
		} else {
			return 1 + Math.max(height(n.left), height(n.right));
		}
	}
	public int height(){
		return height(root);
	}
	public Object getData(){
		return (String) root.getData();
	}
}
