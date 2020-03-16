package algoexpert.medium;

import java.util.Arrays;

public class NonAdjacentSum {

    //DYNAMIC PROGRAMMING, new calculations make use of older calculations
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int[] maxsums = array.clone();
        maxsums[1] = Math.max(maxsums[0], maxsums[1]);
        System.out.println(Arrays.toString(maxsums));
        for (int i = 2; i < array.length; i++) {
            System.out.println(maxsums[i - 1] + " vs " + (maxsums[i - 2] + maxsums[i]));
            maxsums[i] = Math.max(maxsums[i - 1], maxsums[i - 2] + maxsums[i]);
            System.out.println(Arrays.toString(maxsums));
        }
        return maxsums[array.length - 1];
    }

    public static void main(String[] args) {
        int[] input = {75, 105, 120, 75, 90, 135};
        System.out.println(maxSubsetSumNoAdjacent(input));
    }
}
