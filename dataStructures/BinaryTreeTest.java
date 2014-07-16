package dataStructures;

public class BinaryTreeTest {
	public static void main(String[] args) {

		BinaryTree leaf, rr, l1, r1, l2, r2, rl, root;

		leaf = new BinaryTree();
		l1 = new BinaryTree("left 1", leaf, leaf);
		r1 = new BinaryTree("right 1", leaf, leaf);
		rl = new BinaryTree("Root left", l1, r1);
		System.out.println(rl.getData());
		System.out.println(rl.getLeft().getData() + " | "
				+ rl.getRight().getData() + "\n");

		l2 = new BinaryTree("left 2", leaf, leaf);
		r2 = new BinaryTree("right 2", leaf, leaf);
		rr = new BinaryTree("Root right", l2, r2);
		System.out.println(rr.getData());
		System.out.println(rr.getLeft().getData() + " | "
				+ rr.getRight().getData() + "\n");

		root = new BinaryTree("ROOT", rl, rr);
		System.out.println(root.getData());
		System.out.println(rl.getLeft().getData() + " | "
				+ rl.getRight().getData() + "  " + rr.getLeft().getData()
				+ " | " + rr.getRight().getData() + "\n");

		System.out.println(root.getData() + "\n" + root.getLeft().getData()
				+ " | " + root.getRight().getData() + "\n"
				+ root.getLeft().getLeft().getData() + " | "
				+ root.getLeft().getRight().getData() + "  "
				+ root.getRight().getLeft().getData() + " | "
				+ root.getRight().getRight().getData() + "\n");
		
	}
}
