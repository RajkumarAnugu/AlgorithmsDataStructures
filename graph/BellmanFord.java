package graph;


/**
 * The bellman Ford algorithm returns a boolean value indicating whether or not there is a negative-weight cycle that is
 * reachable from the source ...
 * <p/>
 * The Bellman–Ford algorithm is an algorithm that computes shortest paths from a single source vertex to all of the
 * other vertices in a weighted digraph.
 * <p/>
 * Created by GuoJunjun on 26.10.14.
 */
public class BellmanFord {
    /**
     * @param G
     *         {@link graph.G}
     *
     * @return True if there is a solution and print out the result before the returned value
     */
    public static boolean Bellman_Ford(G G) {
        int s = 1; // start vertex s
        Node path = new Node(); // path is the result path
        G = initializeSingleSource(G, s);
        for (int i = 1; i < G.getV().length - 1; i++) {
            for (Edge e : G.getE()) {
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
                    v.setWeight(w + u.getWeight());
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
     * Bellman Ford algorithm Test
     * <p/>
     * Page 652
     *
     * @param args
     */
    public static void main(String[] args) {
        // figure 244
        int[][] adjacencyMatrix = {
                //1,2, 3, 4, 5
                {0, 6, 0, 0, 7}, //1
                {0, 0, 5, -4, 8},//2
                {0, -2, 0, 0, 0},//3
                {2, 0, 7, 0, 0}, //4
                {0, 0, -3, 9, 0} //5
        };

        G G = new G(adjacencyMatrix);
        System.out.println(BellmanFord.Bellman_Ford(G));
    }
}
