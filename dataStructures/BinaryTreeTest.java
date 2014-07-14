package dataStructures;

public class BinaryTreeTest {
	public static void main(String[] args) {

		BinaryTree leaf, r, l1, r1;

		leaf = new BinaryTree();
		l1 = new BinaryTree("left 1", leaf, leaf);
		r1 = new BinaryTree("right 1", leaf, leaf);
		r = new BinaryTree("Root", l1,r1);
		System.out.println(r.getData());
		System.out.println(r.getLeft().getData()+" | "+r.getRight().getData());
	}
}
