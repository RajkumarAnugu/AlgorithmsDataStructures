package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * form an undirect graph to a forest
 * 
 * @author GuoJunjun
 *
 */
public class Forest {
	// Key: vertex; value: edges
	private HashMap<Integer, ArrayList<Edge>> forest;

	public Forest(int[][] wgraph) {
		forest = new HashMap<Integer, ArrayList<Edge>>();
		// Each tree set stores the known vertices reachable from it
		for (int i = 0; i < wgraph.length; i++) {
			ArrayList<Edge> tree = new ArrayList<Edge>();
			for (int j = 0; j < wgraph.length; j++) {
				int weight = wgraph[i][j];
				if (weight != 0) {
					Edge edge = new Edge(i, j, weight);
					tree.add(edge);
				}
			}
			forest.put(i, tree);
		}
	}

	/**
	 * @return the forest
	 */
	public HashMap<Integer, ArrayList<Edge>> getForest() {
		return forest;
	}

	public int getForestSize() {
		int s = 0;
		for (ArrayList<Edge> tree : forest.values()) {
			s += tree.size();
		}
		return s;
	}

	public void removeEdgefromForest(Edge e) {
		for (int i = 0; i < forest.size(); i++) {
			Iterator<Edge> ite = forest.get(i).iterator();
			while (ite.hasNext()) {
				if (ite.next().equals(e)) {
					ite.remove();
				}
			}
		}
	}
}
