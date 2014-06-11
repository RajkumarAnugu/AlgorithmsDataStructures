package sorting;

public abstract class Sorting {
    
    protected int[] sort;
    
    public Sorting(int LENGTH) {
        this.sort = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            sort[i] = (int) (Math.random() * LENGTH * 2);
        }
    }
    
    public int[] getSort() {
        return sort;
    }
    
    public void sorted(int[] sort) {
        this.sort = sort;
    }
    public String toString() {
        String s = "";
        for (int nr : sort) {
            s += nr + " ";
        }
        return s;
    }
}
