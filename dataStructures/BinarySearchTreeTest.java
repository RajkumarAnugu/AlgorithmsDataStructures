package dataStructures;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add("W");
		bst.add("D");
		bst.add("B");
		bst.add("A");
		bst.add("C");
		bst.add("F");
		bst.add("E");
		bst.add("I");
		bst.add("G");
		bst.add("H");
		bst.add("J");
		bst.print();
		System.out.println(bst.height());
		System.out.println(bst.toString());
		System.out.println();
		bst.add("X");
		bst.add("XX");
		bst.add("XXX");
		bst.print();
		System.out.println(bst.height());
		System.out.println(bst.toString() + "\n");
		System.out.println(bst.remove("D"));
		System.out.println(":" + bst.toString() + "\n");
		System.out.println(bst.remove("XX"));
		System.out.println(":" + bst.toString() + "\n");
	}
}
