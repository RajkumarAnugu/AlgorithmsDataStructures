package graph;


/**
 * Created by GuoJunjun on 26.10.14.
 */
public class DijkstrasAlgorithm {

    /**
     * Dijkstra's algorithm Test
     * <p/>
     * Page 658 (Introduction to algorithms 3rd)
     *
     * @param args
     */
    public static void main(String[] args) {
        // figure 24.6
        int[][] adjacencyMatrix = {
                //0,1, 2, 3, 4,
                {0, 10, 0, 0, 5},//0
                {0, 0, 1, 0, 2}, //1
                {0, 0, 0, 4, 0}, //2
                {7, 0, 6, 0, 0}, //3
                {0, 3, 9, 2, 0} //4
        };

        G G = new G(adjacencyMatrix);
        for (Node node : SingleSourceShortestPath.Dijkstra(G)) {
            System.out.println(node.toStringDijkstra());
        }
    }
}
