package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by GuoJunjun on 13.12.14.
 */
public class BaseBexpansion {
    private int n, b, q, k;
    private List<Integer> a;

    /**
     * @param n
     *         positive integers
     * @param b
     *         positive integers b > 1
     */
    public BaseBexpansion(int n, int b) {
        if (n < 0 || b < 1) {
            throw new IllegalArgumentException("input: positive integers and b > 1");
        }
        this.n = n;
        this.b = b;
        q = n;
        k = 0;
        a = new ArrayList<Integer>();
        while (q != 0) {
            a.add(k, q % b);
            q = q / b;
            k = k + 1;
        }
    }

    public List<Integer> getA() {
        Collections.reverse(a);
        return a;
    }

    public String toStringList() {
        return "BaseBexpansion:" + getNumber() + " on base: " + getBase() + "\n" + "{" +
                "a=" + getA() +
                '}';
    }

    public String toString() {
        String s = String.format("%s%10d%s%3d%s", "BaseBexpansion:", getNumber(), " on base: ",
                getBase(),
                ": ");
        for (int n : getA()) {
            if (n < 10)
                s += n;
            else {
                s += (char) (((int) 'A') + (n - 10));
            }
        }
        return s;
    }

    public int getNumber() {
        return n;
    }

    public int getBase() {
        return b;
    }

    public static void main(String[] args) {
                System.out.println(new BaseBexpansion(255, 2));
                System.out.println(new BaseBexpansion(255, 8));
                System.out.println(new BaseBexpansion(2024, 16));
                System.out.println(new BaseBexpansion(2024, 32));
                System.out.println(new BaseBexpansion(3024, 64));
                System.out.println(new BaseBexpansion(255, 10));
                System.out.println(new BaseBexpansion(1024, 2));
                System.out.println(new BaseBexpansion(512, 2));
    }
}
