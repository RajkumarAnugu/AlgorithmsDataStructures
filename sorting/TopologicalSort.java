package sorting;

/*
 * a topological ordering is just a valid sequence for the tasks.
 * 
 * A topological ordering is possible if and only if the graph has no directed
 * cycles, that is, if it is a directed acyclic graph (DAG).
 * 
 * Any DAG has at least one topological ordering, and algorithms are known for
 * constructing a topological ordering of any DAG in linear time.
 */
public class TopologicalSort {

	private final int MAX_NODE = 20;

	private Node NodeList[]; // list of Node / vertices

	private int matrix[][]; // adjacency matrix

	private int numNodes; // current number of Node / vertices

	private char sortedArray[];

	public TopologicalSort() {
		NodeList = new Node[MAX_NODE];
		matrix = new int[MAX_NODE][MAX_NODE];
		numNodes = 0;
		for (int i = 0; i < MAX_NODE; i++)
			for (int j = 0; j < MAX_NODE; j++)
				matrix[i][j] = 0;
		sortedArray = new char[MAX_NODE]; // sorted Node labels
	}

	class Node {// inner class Node
		public char label;

		public Node(char lab) {
			label = lab;
		}
	}

	public int arrayLength() {
		return numNodes;
	}

	/**
	 * 
	 * @param lab
	 *            add node lab to nodelist
	 */
	public void addVertex(char lab) {
		NodeList[numNodes++] = new Node(lab);
	}

	public void addEdge(int start, int end) {
		matrix[start][end] = 1;
	}

	public char displayVertex(int v) {
		if (v >= 0 || v < numNodes) {
			return NodeList[v].label;
		} else {
			throw new IllegalArgumentException("Error input!");
		}
	}

	public int vertexPosition(char vertex) {
		for (int i = 0; i < NodeList.length; i++) {
			if (vertex == NodeList[i].label) {
				return i;
			}
		}
		return -1;
	}

	public String displayAdjacency(char vertex) {
		String s = "";
		if (hasVertex(vertex)) {
			int pos = vertexPosition(vertex);
			for (int i = 0; i < NodeList.length; i++) {
				int adjacency = matrix[pos][i];
				if (adjacency > 0) {
					s += vertex + "-->" + displayVertex(i) + "; ";
				}
			}
		}
		return s;
	}

	/**
	 * 
	 * @param vertex
	 * @return true if vertex exist
	 */
	private boolean hasVertex(char vertex) {
		for (Node node : NodeList) {
			if (vertex == node.label) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return topological sorted vertexes string
	 */
	public String topoligicalSort() {

		int orig_nVerts = numNodes;

		while (numNodes > 0) {// while vertices remain,
			// get a vertex with no successors, or -1
			int currentVertex = noSuccessors();
			if (currentVertex == -1) {// must be a cycle
				return "ERROR: Graph has cycles";
			}
			// insert vertex label in sorted array (start at end)
			sortedArray[numNodes - 1] = NodeList[currentVertex].label;
			System.out.println("sortedArray[numNodes - 1] : "
					+ sortedArray[numNodes - 1]);
			deleteVertex(currentVertex); // delete vertex
		}
		String display = "Topologically sorted order: " + "\n";
		// vertices all gone; display sortedArray
		for (int j = 0; j < orig_nVerts; j++)
			display += sortedArray[j];
		return display;
	}

	/**
	 * 
	 * @return vertex with no successors (or -1 if no such vertex)
	 */
	public int noSuccessors() {
		boolean isEdge; // edge from row to column in adjMat
		for (int row = 0; row < numNodes; row++) {
			isEdge = false; // check edges
			for (int col = 0; col < numNodes; col++) {
				if (matrix[row][col] > 0) {// if edge exist ,
					isEdge = true;
					break; // this vertex has a successor try another
				}
			}
			if (!isEdge) {// if no edges, has no successors
				System.out.println("no edges: " + row);
				return row;
			}
		}
		return -1; // is a cycle
	}

	public void deleteVertex(int delVert) {
		// if not last vertex, delete from NodeList
		if (delVert != numNodes - 1) {
			System.out.println("delvert: " + delVert);
			for (int j = delVert; j < numNodes - 1; j++)
				NodeList[j] = NodeList[j + 1];

			for (int row = delVert; row < numNodes - 1; row++)
				moveRowUp(row, numNodes);

			for (int col = delVert; col < numNodes - 1; col++)
				moveColLeft(col, numNodes - 1);
		}
		numNodes--; // one less vertex
	}

	private void moveRowUp(int row, int length) {
		for (int col = 0; col < length; col++)
			matrix[row][col] = matrix[row + 1][col];
	}

	private void moveColLeft(int col, int length) {
		for (int row = 0; row < length; row++)
			matrix[row][col] = matrix[row][col + 1];
	}

	public static void main(String[] args) {
		TopologicalSort ts = new TopologicalSort();
		ts.addVertex('A'); // 0
		ts.addVertex('B'); // 1
		ts.addVertex('C'); // 2
		ts.addVertex('D'); // 3
		ts.addVertex('E'); // 4
		ts.addVertex('F'); // 5
		ts.addVertex('G'); // 6
		ts.addVertex('H'); // 7

		ts.addEdge(0, 3); // AD
		ts.addEdge(0, 4); // AE
		ts.addEdge(1, 4); // BE
		ts.addEdge(2, 5); // CF
		ts.addEdge(3, 6); // DG
		ts.addEdge(4, 6); // EG
		ts.addEdge(5, 7); // FH
		ts.addEdge(6, 7); // GH

		System.out.println(" .  Display all vertexes: ");
		for (int i = 0; i < ts.arrayLength(); i++) {
			System.out.print(ts.displayVertex(i) + "-");
		}
		System.out.println("\n .  vertexes and it's adjacency: ");
		for (int i = 0; i < ts.arrayLength(); i++) {
			System.out.println(ts.displayAdjacency(ts.displayVertex(i)));
		}
		System.out.println(ts.topoligicalSort()); // do the sort

		TopologicalSort dag = new TopologicalSort();
		dag.addVertex('0');
		dag.addVertex('1');
		dag.addVertex('2');
		dag.addVertex('3');
		dag.addVertex('4');
		dag.addVertex('5');
		dag.addVertex('6');

		dag.addEdge(0, 5);
		dag.addEdge(0, 1);
		dag.addEdge(0, 2);
		dag.addEdge(3, 6);
		dag.addEdge(3, 5);
		dag.addEdge(3, 4);
		dag.addEdge(5, 4);
		dag.addEdge(6, 4);
		dag.addEdge(6, 0);
		dag.addEdge(3, 2);
		dag.addEdge(1, 4);

		System.out.println("\n .. " + "\n"
				+ " .  vertexes and it's adjacency: ");
		for (int i = 0; i < dag.arrayLength(); i++) {
			System.out.println(dag.displayAdjacency(dag.displayVertex(i)));
		}
		System.out.println(dag.topoligicalSort()); // do the sort
	}
}
