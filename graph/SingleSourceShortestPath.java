package graph;


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Single source shortest paths contains: <li>{@link graph.SingleSourceShortestPath#BellmanFord(G)}</li><li>{@link
 * graph.SingleSourceShortestPath#Dijkstra(G)}</li>
 * <p/>
 * Created by GuoJunjun on 26.10.14.
 */
public class SingleSourceShortestPath {
    /**
     * The bellman Ford algorithm returns a boolean value indicating whether or not there is a negative-weight cycle
     * that is reachable from the source ...
     * <p/>
     * The Bellman–Ford algorithm is an algorithm that computes shortest paths from a single source vertex to all of the
     * other vertices in a weighted digraph.
     * <p/>
     * The Bellman-Ford algorithm runs in time O(VE)
     * <p/>
     *
     * @param G
     *         {@link G}
     *
     * @return True if there is a solution and print out the result before the returned value
     */
    public static boolean BellmanFord(G G) {
        int s = 1; // start vertex s
        Node path = new Node(); // path is the result path
        G = initializeSingleSource(G, s);
        for (int i = 1; i < G.getV().length - 1; i++) { // run time V
            for (Edge e : G.getE()) {                   // run time O ( V * E )
                Node u = G.getV()[e.getvA()];
                Node v = G.getV()[e.getvB()];
                int w = e.getweight();
                if (u.getValue() == 0) {
                    path = u;
                    path.setParent(null);
                    path.setWeight(0);
                }
                if (v.d > u.d + w) {
                    v.setParent(u);
                    u.addChild(v);
                    v.d = w + u.d;
                }
                relax(u, v, w);
            }
        }
        for (Edge e : G.getE()) {
            Node u = G.getV()[e.getvA()];
            Node v = G.getV()[e.getvB()];
            int w = e.getweight();
            if (v.d > u.d + w) {
                return false;
            }
        }

        System.out.println("path weight: \n" + path.bellmanFord(path));
        return true;
    }

    /**
     * @param G
     *         Graph G
     * @param s
     *         int s: the number of vertex start with 1
     */
    public static G initializeSingleSource(G G, int s) {
        for (int i = 0; i < G.getV().length; i++) {
            G.getV()[i].d = Integer.MAX_VALUE;
            G.getV()[i].pi = null;
        }
        G.getV()[s - 1].d = 0;
        return G;
    }

    /**
     * @param u
     * @param v
     * @param w
     */
    public static void relax(Node u, Node v, int w) {
        if (v.d > u.d + w) {
            v.d = u.d + w;
            v.pi = u;
        }
    }

    /**
     * Dijkstra's algorithm
     * <p/>
     * solves the single-source shortest path problem for a graph with non-negative edge path costs, producing a
     * shortest path tree. This algorithm is often used in routing and as a subroutine in other graph algorithms.
     * <p/>
     * Worst case run time: O ( E + V * log V )
     *
     * @param G
     *         {@link graph.G}
     */
    public static Set<Node> Dijkstra(G G) {
        int s = 1;
        initializeSingleSource(G, s);
        Set<Node> S = new HashSet<Node>();
        PriorityQueue<Node> Q = new PriorityQueue<Node>();
        for (Node node : G.getV()) {
            Q.add(node);
        }
        while (Q.size() != 0) {                                 // run time V
            Node u = Q.poll();//return the smallest u.weight
            S.add(u);                                           // worst case log V (for (Node v : G.getAdjacency(u)))
            for (Node v : G.getAdjacency(u)) {                  // run time (getAdjacency = E) E + V * log V
                int w = G.getWeight(u.getValue(), v.getValue());
                relax(u, v, w);
            }
        }
        return S;
    }
}
