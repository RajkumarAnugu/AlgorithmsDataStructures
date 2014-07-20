package dataStructures;

public class Visitation extends Tree {

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
		v.init();
		preorder(root, v);
	}

	private static void postorder(Node n, Visitor v) {
		if (n == null) {
			return;
		}
		for (Node c : n.children) {
			postorder(c, v);
		}
		v.visit(n.data);
	}

	public void postorder(Visitor v) {
		v.init();
		postorder(root, v);
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

		t3.addSubtree(new Visitation("Jacob"));
		t3.addSubtree(to);
		t3.addSubtree(new Visitation("Therese"));

		tt.addSubtree(new Visitation("Simon"));
		tt.addSubtree(new Visitation("William"));
		tt.addSubtree(new Visitation("Filip"));

		class TraversalV implements Visitor {
			public int counter = 0;
			public String s;

			public TraversalV() {
				init();
			}

			public void init() {
				s = "";
			}

			public void visit(Object data) {
				s += data.toString() + ", ";
				if (data.toString().length() <= 5) {
					counter++;
				}
			}
		}
		TraversalV v = new TraversalV();
		t.preorder(v);
		System.out.println("Short names: " + v.counter);
		System.out.println("Perorder:	" + v.s);
		t.postorder(v);
		System.out.println("Postorder:	" + v.s);
		System.out.println("Inorder:    only in Binary tree!");
	}
}
