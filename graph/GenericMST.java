package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Introduction to Algorithms Third Edition
 * 23.1 Growing a minimum spanning tree
 * to Java code
 * 
 * @author GuoJunjun
 *
 */

public class GenericMST {
	private int[][] wgraph; // G weighted undirected graph
	private List<Edge> edges;
	private Set<Edge> A; // a set of edges subset of MST
	private Set<Integer> vertex;
	private HashMap<Integer, ArrayList<Edge>> forest;
	private Forest F;

	public GenericMST(int[][] wgraph) {
		this.wgraph = wgraph;
		F = new Forest(wgraph);
		forest = F.getForest();
		init();
	}

	private void init() {
		edges = new ArrayList<Edge>();
		for (int i = 0; i < wgraph.length; i++) {
			for (int j = 0; j < wgraph.length; j++) {
				int weight = wgraph[i][j];
				if (weight != 0) {
					Edge edge = new Edge(i, j, weight);
					edges.add(edge);
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
		ArrayList<Edge> ce = new ArrayList<Edge>(edges);
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
		boolean stop = false;
		while (!stop) {
			Edge least = null;
			int lc = 9999;
			Iterator<Integer> ite = vertex.iterator();
			while (ite.hasNext()) {
				int v = ite.next();
				Edge lv = findleastcost(v);
				if (lv != null && lv.getweight() < lc) {
					lc = lv.getweight();
					least = lv;
				}
			}
			if (least != null) {
				A.add(least);
				vertex.add(least.getvA());
				vertex.add(least.getvB());
			}
			if (A.size() == forest.size() - 1) {
				stop = true;
			}
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

	/**
	 * 
	 * @param vertex
	 * @return Edge
	 */
	private Edge findleastcost(int vertex) {
		updateForest(vertex);
		int cost = 9999;
		Edge leastEdge = null;
		Iterator<Edge> ite = forest.get(vertex).iterator();
		while (ite.hasNext()) {
			Edge edge = ite.next();
			if (edge.getweight() < cost) {
				cost = edge.getweight();
				leastEdge = edge;
			}
		}
		return leastEdge;
	}

	private void updateForest(int vertex) {
		Iterator<Edge> ite = forest.get(vertex).iterator();
		while (ite.hasNext()) {
			Edge edge = ite.next();
			if (!isEdgesafe(edge)) {
				// remove edges that is already in vertexInA
				ite.remove();
			}
		}
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
	public List<Edge> getEdges() {
		return edges;
	}

	/**
	 * @return the forest
	 */
	public HashMap<Integer, ArrayList<Edge>> getForest() {
		return forest;
	}

	public int getMinimumCost() {
		int sum = 0;
		for (Edge e : A) {
			sum += e.getweight();
		}
		return sum;
	}
}
