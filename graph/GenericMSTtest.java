package graph;

/**
 * Introduction to Algorithms Third Edition
 * Page 627: 23.1 Growing a minimum spanning tree
 * 
 * @author GuoJunjun
 *
 */
public class GenericMSTtest {
	public static void main(String[] args) {
		int[][] wgraph = new Input("GenericMST").getWeightedUDgraph();
		GenericMST gmst = new GenericMST(wgraph);
		for (Edge e : gmst.getMST()) {
			System.out.println(e.toString());
		}

		System.out.println("Minimum Cost: " + gmst.getMinimumCost());

		// for (Edge ee : gmst.getEdges()) {
		// System.out.println("ee.toString() : " + ee.toString());
		// }
		// gmst.getMST();
		// System.out.println("\nA size: " + gmst.getMST().size());

		// HashSet<Integer> hs = new HashSet<Integer>();
		// hs.add(1);
		// // prinths(hs);
		// hs.add(2);
		// // prinths(hs);
		// hs.add(1);
		// // prinths(hs);

		// test forest
		// HashMap<Integer, ArrayList<Edge>> forest = gmst.getForest();
		// for (ArrayList<Edge> tree : forest.values()) {
		// for (Edge edge : tree) {
		// System.out.println(edge.toString());
		// if (edge.getweight() == 1) {
		// System.out.println(gmst.getForestSize());
		// gmst.removeEdgefromForest(edge);
		// // System.out.println(gmst.getForestSize());
		// }
		// }
		// }
	}

	// public static void prinths(HashSet<Integer> hs) {
	// for (Integer i : hs) {
	// System.out.println(i);
	// }
	// System.out.println("H s size: " + hs.size() + "\n");
	// }
}
