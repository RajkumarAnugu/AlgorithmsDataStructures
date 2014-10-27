package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * G = Graph (V, E) Vertex, Edge
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

    @Override
    public String toString() {
        String stringV="";
        for (Node n : V) {
            stringV+=n.showG()+" | ";
        }
        return "G{\n" +
                "V=" +stringV+
                "\nE=" + E +
                "\n}";
    }
}
