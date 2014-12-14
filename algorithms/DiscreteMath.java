package algorithms;

import java.util.Arrays;

/**
 * Created by GuoJunjun on 13.12.14.
 */
public class DiscreteMath {
    /**
     * @param a
     *         dividend or numerator
     * @param d
     *         divisor or denominator
     *
     * @return [q, r] q = (a divided by d) is the quotient, r = (a mod d) is the remainder
     */
    public static long[] divisionAgorithm(long a, long d) {
        long q = 0;
        long r = Math.abs(a);
        while (r >= d) {
            r -= d;
            q += 1;
        }
        if (a < 0 && r > 0) {
            r = d - r;
            q = -(q + 1);
        }
        return new long[]{q, r};
    }

    public static void divisionAgorithmTest() {
        long startTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(divisionAgorithm(9, 2)));
        System.out.println(Arrays.toString(divisionAgorithm(999, 7)));
        System.out.println(Arrays.toString(divisionAgorithm(912345, 5)));
        System.out.println(Arrays.toString(divisionAgorithm(7485692699999987654L, 2000000000)));
        System.out.println(Arrays.toString(divisionAgorithm(458986099, 21)));
        System.out.println(Arrays.toString(divisionAgorithm(245298749, 3)));
        long endTime = System.currentTimeMillis();
        System.out.println(startTime - endTime);
    }

    /**
     * Euclidean algorithm:  finding the greatest common divisor
     *
     * @param a
     *         positive integer
     * @param b
     *         positive integer
     *
     * @return gcd(a, b)
     */
    public static int gcd(int a, int b) {
        int x = a, y = b, r;
        while (y != 0) {
            r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    public static void gcdTest() {
        System.out.println(gcd(9, 33));
        System.out.println(gcd(12345, 1578));
        System.out.println(gcd(34 * 23 * 59 * 97, 5 * 79 * 97));
        System.out.println(gcd(39, 27));
        System.out.println(gcd(49, 5));
        System.out.println(gcd(9876543 * 31, 23 * 31));
    }

    /**
     * Recursive Algorithm for Computing n!
     *
     * @param n
     *         non negative integer
     *
     * @return n!
     */
    public static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static void factorialTest() {
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
        System.out.println(factorial(6));
        System.out.println(factorial(7));
        System.out.println(factorial(8));
        System.out.println(factorial(9));
    }

    /**
     * Recursive Algorithm for Computing gcd(a, b).
     *
     * @param a
     *         a > 0 & a is integer
     * @param b
     *         b > 0 & b is integer
     *
     * @return gcd (a,b)
     */
    public static int gcdR(int a, int b) {
        if (a < 0 || b < 0)
            throw new IllegalArgumentException("non negative integer!");
        else if (a > b)
            return gcdr(a, b);
        else
            return gcdr(b, a);
    }

    private static int gcdr(int a, int b) {
        if (a == 0)
            return b;
        else
            return gcdr(b % a, a);
    }

    public static void gcdRTest() {
        System.out.println(gcdR(35, 5));
        System.out.println(gcdR(51, 7));
        System.out.println(gcdR(19, 19 * 19));
        System.out.println(gcdR(31, 62));
        System.out.println(gcdR(121, 11));
    }

    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void fibonacciTest() {
        for (int i = 0; i <= 19; i++) {
            System.out.println(String.format("%s%3d%s%5d", "nr.: ", i, " ", fibonacci(i)));
        }
    }

    public static void main(String[] args) {
        //        divisionAgorithmTest();
        //        gcdTest();
        //        factorialTest();
        //        gcdRTest();
        fibonacciTest();
    }
}
