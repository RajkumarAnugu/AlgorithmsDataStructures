package graph;

import com.sun.tools.javac.jvm.Gen;

/**
 * The bellman Ford algorithm returns a boolean value indicating whether or not there is a negative-weight cycle that is
 * reachable from the source ...
 * <p/>
 * Created by GuoJunjun on 26.10.14.
 */
public class BellmanFord {
    public static final int MAX_VALUE = java.lang.Integer.MAX_VALUE;
    private G G;
    public BellmanFord(G G){
        this.G=G;
    }
    public boolean Bellman_Ford() {
        int s = 1; // start vertex s
        G = initializeSingleSource(G, s);
        for (int i = 1; i < G.getV().length - 1; i++) {
            for (Edge e : G.getE()) {
                Node u = G.getV()[e.getvA()];
                Node v = G.getV()[e.getvB()];
                int w = e.getweight();
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
        return true;
    }

    /**
     * @param G
     *         Graph G
     * @param s
     *         int s: the number of vertex start with 1
     */
    public G initializeSingleSource(G G, int s) {
        for (int i = 0; i < G.getV().length; i++) {
            G.getV()[i].d = MAX_VALUE;
            G.getV()[i].pi = null;
        }
        G.getV()[s - 1].d = 0;
        return G;
    }

    public void relax(Node u, Node v, int w) {
        if (v.d > u.d + w) {
            v.d = u.d + w;
            v.pi = u;
        }
    }

    /**
     * Bellman Ford algorithmer Test
     * <p/>
     * Page 652
     *
     * @param args
     */
    public static void main(String[] args) {
        // figure 244
        int n = 5;
        int[][] adjacencyMatrix = {
                //1,2, 3, 4, 5
                {0, 6, 0, 0, 7}, //1
                {0, 0, 5, -4, 8},//2
                {0, -2, 0, 0, 0},//3
                {2, 0, 7, 0, 0}, //4
                {0, 0, -3, 9, 0} //5
        };

        G G = new G(adjacencyMatrix);
        System.out.println(new BellmanFord(G).Bellman_Ford());
    }
}
