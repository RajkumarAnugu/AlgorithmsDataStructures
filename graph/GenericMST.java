package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Introduction to Algorithms Third Edition
 * Page 627: 23.1 Growing a minimum spanning tree
 * to Java code
 * 
 * @author GuoJunjun
 *
 */

public class GenericMST {
	private int[][] wgraph; // G weighted undirected graph
	private Set<Edge> edges; // E a set of edges from graph
	private List<Edge> kant;
	private Set<Edge> A; // a set of edges subset of MST
	private Set<Integer> vertex;
	private HashMap<Integer, ArrayList<Edge>> forest;
	private Forest F;

	public GenericMST(int[][] wgraph) {
		this.wgraph = wgraph;
		edges = new HashSet<Edge>();
		kant = new ArrayList<Edge>();
		F = new Forest(wgraph);
		forest = F.getForest();
		init();
	}

	/**
	 * initial edges from graph
	 * 
	 * &
	 * 
	 * forest: contains all the trees in graph
	 */
	private void init() {
		for (int i = 0; i < wgraph.length; i++) {
			for (int j = 0; j < wgraph.length; j++) {
				int weight = wgraph[i][j];
				if (weight != 0) {
					Edge edge = new Edge(i, j, weight);
					edges.add(edge);
					kant.add(edge);
				}
			}
		}
	}

	/**
	 * init A: form A to a Spanning tree
	 */
	private void initA() {
		A = new HashSet<Edge>();
		vertex = new HashSet<Integer>();
		// copy edges:
		ArrayList<Edge> ce = new ArrayList<Edge>(kant);
		int cost = ce.get(0).getweight();
		Edge anedge = ce.get(0);
		// 1. find a least cost edge and insert to A as first Edge
		for (Edge E : ce) {
			if (E.getweight() < cost) {
				cost = E.getweight();
				anedge = E;
			}
		}
		if (isEdgesafe(anedge)) {
			A.add(anedge);
			vertex.add(anedge.getvA());
			vertex.add(anedge.getvB());
			ce.remove(anedge);
		}
		while (!isAaSpanningTree()) {
			Edge lv = null;
			int lc = 9999;
			for (int v : vertex) {
				lv = findleastcost(v);
				System.out.println("lv = findleastcost(v): " + lv.getweight());
				if (lv != null && lv.getweight() < lc) {
					lc = lv.getweight();
					System.out.println("lc:" + lc);
				}
			}
			if (lv != null) {
				A.add(lv);
				vertex.add(lv.getvA());
				vertex.add(lv.getvB());
			}
			System.out.println("vertexInA.size() : " + vertex.size());
		}
	}

	/**
	 * 
	 * @return Minimum spanning tree
	 */
	public Set<Edge> getMST() {
		initA();
		return A;
	}

	/**
	 * Is edge (c, d) safe?
	 * Let S ⊂ V be any set of vertices that includes c but not d (so that d is
	 * in V − S).
	 * In any MST, there has to be one edge (at least) that connects S with V −
	 * S.
	 * Edges that connect vertices in S with vertices in V-S: (c,d), (b,c),
	 * (b,h), (a,h), (d,f), (e,f).
	 * Choose the edge with minimum weight, (c, d).
	 * (c, d) is minimum edge that connects S and V-S, so is safe.
	 */
	private boolean isEdgesafe(Edge e) {
		int a = e.getvA();// vertex c
		int b = e.getvB();// vertex d
		if (vertex.contains(a) && vertex.contains(b)) {
			return false;
		}
		return true;
	}

	private Edge findleastcost(int vertex) {
		int cost = 9999;
		Edge leastEdge = null;
		for (Edge edge : forest.get(vertex)) {
			System.out.println(edge.toString());
			if (edge.getweight() < cost) {
				cost = edge.getweight();
				leastEdge = edge;
			}
			if (!isEdgesafe(edge)) {
				// remove edges that is already in vertexInA
				System.out.println("forest.size(): " + forest.size());
				F.removeEdgefromForest(edge);
				System.out.println("forest.size(): " + forest.size());
			}
		}
		return leastEdge;
	}

	private boolean isAaSpanningTree() {
		if (A.size() == vertex.size()) return true;
		return false;
	}

	/**
	 * @return the wgraph
	 */
	public int[][] getWgraph() {
		return wgraph;
	}

	/**
	 * @return the edges
	 */
	public Set<Edge> getEdges() {
		return edges;
	}

	/**
	 * @return the kant
	 */
	public List<Edge> getKant() {
		return kant;
	}

}
