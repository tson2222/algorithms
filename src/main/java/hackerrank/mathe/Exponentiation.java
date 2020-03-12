package hackerrank.mathe;

public class Exponentiation {
    int[][][] _3d = new int[3][3][3];

    //standard recursion
    public static int exponent(int base, int exp) {
        if (exp == 0) return 1;
        return base * exponent(base, exp - 1);
    }

    //divide and conquer, divide exp by two and then just multiply it.
    public static int exponentDQ(int base, int exp) {
        if (exp == 0) return 1;
        int half = exponent(base, exp/2);
        int full = half*half;
        if(exp%2 == 0) return full;
        return full*base;
    }

    public static void main(String[] args) {
        System.out.println(exponent(3, 9));
        System.out.println(exponentDQ(3,9));
    }
}
