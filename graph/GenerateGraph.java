package graph;

/**
 * This class will generate a Graph from a matrix
 * <p>
 * GenerateGraph(String filename) :
 * <li>input file must be a matrix
 * <li>and must only contains 0 or 1
 * 
 * 
 * @author GuoJunjun
 *
 */
public class GenerateGraph {

	/**
	 * 
	 * @return
	 *         an graph <br>
	 * <br>
	 *         input matrix must only contains 0 or 1
	 */
	public static Node getGraph(String filename) {
		int[][] matrix = new Input(filename).getWeightedUDgraph();

		// build node
		Node[] list = new Node[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			list[i] = new Node();
			list[i].setValue(i + 1);// node value = node number
		}
		// first node as root node
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 1) {
					list[i].addChild(list[j]);
				}
			}
		}
		return list[0];
	}
}
