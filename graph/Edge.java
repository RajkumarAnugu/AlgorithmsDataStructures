package graph;

/**
 * Edge has 3 variables vertex vA(u), vertex vB(v) and weight w
 */
public class Edge implements Comparable<Edge> {
    private int vA, vB, wt;

    // private double wt;

    // private String n1, n2;

    Edge(int v1, int v2, int wt) {
        this.vA = v1;
        this.vB = v2;
        this.wt = wt;
    }

    // Edge(String n1, String n2, int wt) {
    // this.n1 = n1;
    // this.n2 = n2;
    // this.wt = wt;
    // }

    /**
     * @return edge weight
     */
    public int getweight() {
        return wt;
    }

    /**
     * @return the vA
     */
    public int getvA() {
        return vA;
    }

    /**
     * @return the vB
     */
    public int getvB() {
        return vB;
    }

    @Override
    public int compareTo(Edge E) {
        if (E.wt == this.wt)
            return 0;
        return E.wt < this.wt ? 1 : -1;
    }

    @Override
    public String toString() {
        return "v" + vA + " --> v" + vB + " cost:" + wt;

    }
}
