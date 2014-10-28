package graph;


/**
 * Created by GuoJunjun on 26.10.14.
 */
public class BellmanFord {

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
        System.out.println(SingleSourceShortestPath.BellmanFord(G));
    }
}
