package hackerrank.algo.recursion.powersum;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the powerSum function below.
    static int powerSum(int value, int exponent) {
        return powerSum(value, exponent, 1);
    }

    static int powerSum(int value, int exponent, int base) {
        int currentPower = (int) Math.pow(base, exponent);
        System.out.println("currentpower:" + currentPower);
        int valueRemaining = value - currentPower;
        System.out.println("valueRemaining:" + valueRemaining);
        // exceeded the num we're trying to match, so return 0 and stop creating new recursive branches
        if (currentPower > value) return 0;
            // matched our num, we've found one way to do it, the stack can be popped
        else if (currentPower == value) {
            return 1;
        }

        // first recursive call is trying to see if the current base was a part of the solution
        // second recursive call is exploring the path that the current base was not a part of the solution
        return powerSum(value, exponent, base + 1) +
                powerSum(valueRemaining, exponent, base + 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);
        System.out.println(result);
        scanner.close();
    }
}
