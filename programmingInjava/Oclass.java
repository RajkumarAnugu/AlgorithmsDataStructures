package programmingInjava;

public class Oclass {
	private Node root;

	public class Node {
		Object data;
		Node next;
	}

	public Oclass(Object o) {
		root = new Node();
		root.data = o;
	}

	public void setChildren(Object child) {
		root.next.data = (Node) child;
	}

	public Object getChild() {
		return root.next.data;
	}

	public static void main(String[] args) {
		Oclass o = new Oclass("Grandpa");
		o.setChildren((Object) "father");
		o.setChildren((Object) "child");
		System.out.println(o.getChild());
	}
}
