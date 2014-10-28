package graph;

import java.util.ArrayList;

/**
 * G = Graph (V, E) Vertex, Edge <li>Node [] V</li> <li>ArrayList(Edge)</li>
 * <p/>
 * Created by GuoJunjun on 26.10.14.
 */
public class G {
    private Node[] V;
    private ArrayList<Edge> E;

    public G(int[][] matrix) {
        V = new Node[matrix.length];
        E = new ArrayList<Edge>();
        for (int i = 0; i < matrix.length; i++) {
            Node v = new Node();
            v.setValue(i);
            V[i] = v;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    E.add(new Edge(i, j, matrix[i][j]));
                }
            }
        }
    }

    /**
     * @return Vertexes as Node [] list
     */
    public Node[] getV() {
        return V;
    }

    /**
     * @return Edges as ArrayList(Edge)
     */
    public ArrayList<Edge> getE() {
        return E;
    }

    /**
     * @param u
     *         {@link graph.Node}
     *
     * @return adjacency {@link graph.Node} to Node n;
     */
    public ArrayList<Node> getAdjacency(Node u) {
        ArrayList<Node> adjacency = new ArrayList<Node>();
        for (Edge e : getE()) {
            if (e.getvA() == u.getValue()) { // Directed graph Node u --> v
                adjacency.add(getV()[e.getvB()]);
            }
        }
        return adjacency;
    }

    /**
     * @param u
     *         int u vertex position
     * @param v
     *         int v vertex position
     *
     * @return weight to edge {u,v}
     */
    public int getWeight(int u, int v) {
        for (Edge e : E) {
            if ((e.getvA() == u && e.getvB() == v)){
                return e.getweight();
            }
        }
        System.out.println("edge {u-"+u+", v-"+v+" not found!");
        return 0;
    }
}
