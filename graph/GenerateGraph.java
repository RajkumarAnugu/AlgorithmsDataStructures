package graph;


/**
 * This class will generate a Graph from a matrix
 * <p/>
 * getGraph(String filename) : <li>input file must be a matrix <li>and must only contains 0 or 1
 *
 * @author GuoJunjun
 */
public class GenerateGraph {

    /**
     * @return an graph
     */
    public static Node getGraph(String filename) {
        int[][] matrix = new Input(filename).getWeightedUDgraph();
        return getWeightedGraph(matrix);
    }

    /**
     *
     * @param matrix
     * @return an weighted graph
     */
    public static Node getWeightedGraph(int[][] matrix) {
        Node[] list = new Node[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            list[i] = new Node();
            list[i].setValue(i + 1);// node value = node number
        }
        // first node as root node
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    list[i].addChild(list[j]);
                }
            }
        }
        return list[0];
    }
}
