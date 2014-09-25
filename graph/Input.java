package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * This class have build in methods which parser input
 * to undriect graph(weight and unweight)
 * 
 * Input must be n*n adjacency matrix!
 * 
 * @author GuoJunjun
 *
 */
public class Input {
	private String file;
	private BufferedReader in;

	/**
	 * 
	 * @param file
	 *            name
	 *
	 */
	public Input(String file) {
		if (file.contains("/")) {
			this.file = "";
		} else {
			this.file =
					"/Users/junjun/Dropbox/ntnu2014/algoritmerDatastrukturer/TDT4120/src/graph/";
		}
		if (file.contains(".txt")) {
			this.file = this.file + file;
		} else {
			this.file = this.file + file + ".txt";
		}
		try {
			// System.out.println(this.file);
			in = new BufferedReader(new FileReader(this.file));
		} catch (FileNotFoundException e) {
			System.out.println("can not open file ERROR:\n" + e);
			return;
		}
	}

	/**
	 * build a undirected graph with weight(double) represent by an adjacency
	 * matrix
	 * 6 //matrix size
	 * 0 1 1 0 0 0 // each position is a double,
	 * 0 0 0 1 0 0 // there is a space between each double
	 * 0 0 0 1 1 0
	 * 0 0 0 0 0 21
	 * 0 1 0 1 0 1.1
	 * 0 0 0 1 0 0
	 * 
	 * 
	 */
	public int[][] getWeightedUDgraph() {
		try {
			// first line matrix size = n
			int n = Integer.parseInt(in.readLine());
			// build an n * n adjacency matrix
			int[][] adjacencyMatrix = new int[n][n];

			// build a undirected graph represent by an adjacency matrix
			String adjacentrow;
			for (int i = 0; i < n; i++) {
				adjacentrow = in.readLine();
				String[] rowTable = adjacentrow.split("	");
				if (rowTable.length != n) {
					throw new IllegalArgumentException(
							"ERROR: Matrix size must n * n");
				} else {
					for (int j = 0; j < rowTable.length; j++) {
						String s = rowTable[j];
						if (s != "0") {
							adjacencyMatrix[i][j] = Integer.parseInt(s);
						}
					}
				}
			}
			return adjacencyMatrix;
		} catch (Exception e) {
			System.err.println("getUDgraphWeighted ERROR:\n" + e);
			return null;
		}
	}

	/**
	 * build a undirected graph represent by an (boolean) adjacency matrix
	 * 6 matrix size
	 * 011000 // 1 true; 0 false
	 * 000100 // no space in between
	 * 000110
	 * 000001
	 * 010101
	 * 000100
	 * 
	 * 
	 */
	public boolean[][] getUDgraph() {
		try {
			// first line matrix size = n
			int n = Integer.parseInt(in.readLine());
			// build an n * n adjacency matrix
			boolean[][] adjacencyMatrix = new boolean[n][n];

			// build a undirected graph represent by an adjacency matrix
			String adjacentrow;
			for (int i = 0; i < n; i++) {
				adjacentrow = in.readLine();
				for (int j = 0; j < n; j++)
					if (adjacentrow.charAt(j) == '1')
						adjacencyMatrix[i][j] = true;
			}
			return adjacencyMatrix;
			// String linje = in.readLine();
			// while (linje != null && linje.length() > 0) {
			// int startnode = Integer.parseInt(linje);
			// // System.out.println(subgraftetthet(adjacencyMatrix,
			// // startnode));
			// linje = in.readLine();
			// }
		} catch (Exception e) {
			System.err.println("getUDgraph ERROR:\n" + e);
			return null;
		}
	}
}
