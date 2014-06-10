package sorting;


public class InsertionSort {
    
    public static void main(String[] args) {
        int LENGTH = 5;
        //        int[] sort = { 5, 4, 3, 2, 1 };
        int[] sort = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            sort[i] = (int) (Math.random() * 40);
        }

        String s = "";
        for (int nr : sort) {
            s += nr + " ";
        }
        System.out.println("sorting table: " + s);
        for (int i = 1; i < sort.length; i++) {
            int key = sort[i];
            int j = i - 1;
            while (j >= 0 && sort[j] > key) {
                sort[j + 1] = sort[j];
                j -= 1;
            }
            sort[j + 1] = key;
        }
        String ss = "";
        for (int nr : sort) {
            ss += nr + " ";
        }
        System.out.println("sorted table: " + ss);
    }
}


