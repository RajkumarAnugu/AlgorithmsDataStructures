package searching;

import dataStructures.Tree;

public class BDSearchesTest {

	public static void main(String[] args) {
		Tree t = new Tree("grandpa");

		Tree t2 = new Tree("father");
		t.addSubtree(t2);

		Tree t3 = new Tree("mother");
		t.addSubtree(t3);

		Tree tt = new Tree("Tro");
		Tree to = new Tree("Ole");
		t2.addSubtree(tt);
		t2.addSubtree(to);
		t2.addSubtree(new Tree("Kari"));

		t3.addSubtree(new Tree("Jacob"));
		t3.addSubtree(to);
		t3.addSubtree(new Tree("Therese"));

		tt.addSubtree(new Tree("Simon"));
		tt.addSubtree(new Tree("William"));
		tt.addSubtree(new Tree("Fillip"));

		BDSearches bds = new BDSearches(t, "Therese");
		System.out.println(bds.getBreadFirstS());
		System.out.println(bds.breadFirst("Filli"));
		System.out.println(bds.depthFirst("Therese"));
		System.out.println(bds.depthFirst("KK"));
		System.out.println("\n" + "BreadthFirstIterator:");
		BreadthFirstIterator bfi = new BreadthFirstIterator(t.getNode());
		while (bfi.hasNext()) {
			System.out.println(bfi.next());
		}
		System.out.println("\n" + "DepthFirstIterator:");
		DepthFirstIterator dfi = new DepthFirstIterator(t.getNode());
		boolean found = false;
		String s = "";
		while (!found && dfi.hasNext()) {
			Object obj = dfi.next();
			s += obj.toString() + ", ";
			if (obj == "Fillip") {
				found = true;
			}
		}
		System.out.println(s);
	}
}
