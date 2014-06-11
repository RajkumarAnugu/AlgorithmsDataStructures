package sorting;


public class SelectionSort extends Sorting {
    
    public SelectionSort(int LENGTH) {
        super(LENGTH);
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort(10);
        System.out.println(ss.toString());
        for (int i = 0; i < ss.sort.length; i++) {
            int min = ss.sort[i];
            int nr = 0;
            boolean changed = false;
            for (int j = i + 1; j < ss.sort.length; j++) {
                if (ss.sort[j] < min) {
                    min = ss.sort[j];
                    nr = j;
                    changed = true;
                }
            }
            if (changed) {
            ss.sort[nr] = ss.sort[i];
                ss.sort[i] = min;
            }
            ss.sorted(ss.sort);
        }
        ss.sorted(ss.sort);
        System.out.println(ss.toString());
    }
}
