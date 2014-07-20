package dataStructures;

public class Visitation extends Tree {
	//private Node root;

	public Visitation(Object rootData) {
		super(rootData);
	}

	private static void preorder(Node n, Visitor v) {
		if (n == null) {
			return;
		}
		v.visit(n.data);
		for (Node c : n.children) {
			preorder(c, v);
		}
	}

	public void preorder(Visitor v) {
		preorder(root, v);
	}

	public static void main(String[] args) {
		Visitation t = new Visitation("grandpa");

		Visitation t2 = new Visitation("father");
		t.addSubtree(t2);

		Visitation t3 = new Visitation("mother");
		t.addSubtree(t3);

		Visitation tt = new Visitation("Tro");
		Visitation to = new Visitation("Ole");
		t2.addSubtree(tt);
		t2.addSubtree(to);
		t2.addSubtree(new Visitation("Kari"));

		t3.addSubtree(tt);
		t3.addSubtree(to);
		t3.addSubtree(new Visitation("Therese"));

		tt.addSubtree(new Visitation("Simon"));
		tt.addSubtree(new Visitation("William"));
		tt.addSubtree(new Visitation("Filip"));

		class ShortName implements Visitor {
			public int counter = 0;
			public String s = "Preorder: ";

			public void visit(Object data) {
				s += data.toString() + ", ";
				if (data.toString().length() <= 5) {
					counter++;
				}
			}
		}
		ShortName v = new ShortName();
		t.preorder(v);
		System.out.println("Short names: " + v.counter);
		System.out.println(v.s);
	}
}
