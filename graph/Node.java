package graph;


import java.util.ArrayList;
import java.util.Stack;

/**
 * Node class with
 * <p/>
 * <li> private Node parent; <li> private ArrayList<Node> children; <li> private String color; <li> private String
 * value; <li> private int weight;<br>
 *
 * @author GuoJunjun
 */
public class Node {
    private Node parent; // predecessor
    private ArrayList<Node> children;
    private int value;
    private int weight;
    public String color = "WHITE";
    public int distance = Integer.MAX_VALUE;
    public int d = Integer.MAX_VALUE;
    public Object pi = null;

    public Node() {
        this.parent = null;
        children = new ArrayList<Node>();
        this.value = 0;
        this.weight = 0;
    }

    /**
     * @param parent
     * @param children
     * @param value
     * @param weight
     */
    public Node(Node parent, ArrayList<Node> children, int value, int weight) {
        this.parent = parent;
        this.children = children;
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
     *         the parent to set
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
     *         the children to set
     */
    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    /**
     * @param child
     *         add a child to the children list
     */
    public void addChild(Node child) {
        this.children.add(child);
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value
     *         the value to set
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
     *         the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "[ " + showValue() + " color=" + color + ", distance=" + distance + " ]";

        // return "Node [parent=" + parent + ", children=" + children +
        // ", color="
        // + color + ", value=" + value + ", weight=" + weight + "]";
    }

    /**
     * @return Node size
     */
    public int size() {
        int sum = 0;
        for (Node child : children) {
            sum += child.size();
        }
        return 1 + sum;
    }

    public String showValue() {
        if (parent == null) {
            return "parent: null - child: " + getValue();
        }
        return "parent: " + parent.getValue() + " - child: " + getValue();
    }

    public String showG() {
        return "v:" + value + "; d:" + d + "; Pi:" + pi;
    }

    public String bellmanFord(Node n) {
        String s = "";
        if (n.color == "WHITE") {
            n.color = "GRAY";
        }
        for (Node child : n.children) {
            if (child.color == "WHITE") {
                s += "v:" + child.getValue() + " w:" + child.getWeight() + "\n"+bellmanFord(child);
            }
        }
        return s;
    }
}
