package dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * A tree for decoding Huffman codes.
 */
public class HuffmanTree {
	private Node root;

	/**
	 * Constructs a Huffman tree from given character frequencies.
	 * 
	 * @param frequencies
	 *            a map whose keys are the characters to be encoded
	 *            and whose values are the frequencies of the characters
	 */
	public HuffmanTree(Map<Character, Integer> frequencies) {
		/**
		 * wikipedia: priority queue
		 * 
		 * In computer science/data structures, a priority queue is an abstract
		 * data type which is like a regular queue or stack data structure, but
		 * where additionally each element has a "priority" associated with it.
		 * In a priority queue, an element with high priority is served before
		 * an element with low priority. If two elements have the same priority,
		 * they are served according to their order in the queue.
		 * 
		 * While priority queues are often implemented with heaps, they are
		 * conceptually distinct from heaps. A priority queue is an abstract
		 * concept like "a list" or "a map"; just as a list can be implemented
		 * with a linked list or an array, a priority queue can be implemented
		 * with a heap or a variety of other methods.
		 * 
		 * Huffman coding requires one to repeatedly obtain the two
		 * lowest-frequency trees. A priority queue makes this efficient.
		 */
		PriorityQueue<Node> nodes = new PriorityQueue<Node>();
		for (char ch : frequencies.keySet()) {
			Node newNode = new Node();
			newNode.character = ch;
			newNode.frequency = frequencies.get(ch);
			nodes.add(newNode);
		}
		System.out.println("PriorityQueue: " + nodes.toString());
		while (nodes.size() > 1) {//reduce queue to node set last node to root
			Node smallest = nodes.remove();//remove the head of this queue
			Node nextSmallest = nodes.remove();
			Node newNode = new Node();
			newNode.frequency = smallest.frequency + nextSmallest.frequency;
			newNode.left = smallest;
			newNode.right = nextSmallest;
			System.out.println("    PriorityQueue" + nodes.toString());
			nodes.add(newNode);
			System.out.println("  PriorityQueue" + nodes.toString());
		}
		System.out.println("PriorityQueue = root =" + nodes.toString());
		root = nodes.remove();
	}

	/**
	 * Decodes an encoded string.
	 * 
	 * @param input
	 *            a string made up of 0 and 1
	 */
	public String decode(String input) {
		String result = "";
		Node n = root;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '0') { // 0:left; 1:right
				n = n.left;
			} else {
				n = n.right;
			}
			if (n.left == null) // n is a leaf == n.right ==null;
			{
				result = result + n.character;
				n = root;
				System.out.println("decode result: " + result);
			}
		}
		return result;
	}

	public Map<Character, String> getEncodingMap() {
		Map<Character, String> map = new HashMap<Character, String>();
		if (root != null) {
			root.fillEncodingMap(map, "");
		}
		return map;
	}

	class Node implements Comparable<Node> {
		public char character;
		public int frequency;
		public Node left;
		public Node right;

		public int compareTo(Node other) {
			return frequency - other.frequency;
		}

		//fill tree with 0 1
		public void fillEncodingMap(Map<Character, String> map, String prefix) {
			if (left == null) // it's a leaf
			{
				map.put(character, prefix);
			} else {
				left.fillEncodingMap(map, prefix + "0");
				right.fillEncodingMap(map, prefix + "1");
			}
		}

		public String toString() {
			return character + "-" + frequency;
		}
	}
}
