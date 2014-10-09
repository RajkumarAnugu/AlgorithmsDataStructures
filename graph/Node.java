package graph;

import java.util.ArrayList;

/**
 * Node class with
 * <p>
 * <li>
 * private Node parent;
 * <li>
 * private ArrayList<Node> children;
 * <li>
 * private String color;
 * <li>
 * private String value;
 * <li>
 * private int weight;<br>
 * 
 * @author GuoJunjun
 *
 */
public class Node {
	private Node parent;
	private ArrayList<Node> children;
	private String color;
	private int value;
	private int weight;

	public Node() {
		children = new ArrayList<Node>();
	}

	/**
	 * @param parent
	 * @param children
	 * @param color
	 * @param value
	 */
	public Node(Node parent, ArrayList<Node> children, String color, int value) {
		this.parent = parent;
		this.children = children;
		this.color = color;
		this.value = value;
	}

	/**
	 * @param parent
	 * @param children
	 * @param color
	 * @param value
	 * @param weight
	 */
	public Node(Node parent, ArrayList<Node> children, String color, int value,
			int weight) {
		this.parent = parent;
		this.children = children;
		this.color = color;
		this.value = value;
		this.weight = weight;
	}

	/**
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public ArrayList<Node> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}

	/**
	 * 
	 * @param child
	 * 
	 *            add a child to the children list
	 */
	public void addChild(Node child) {
		this.children.add(child);
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		if (parent == null) {
			weight = 0;
		}
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
