package algoexpert.medium;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {

        int[][] input = {
                {-1, 5, 10, 20, 28, 3},
                {26, 134, 135, 15, 17}};

        System.out.println(Arrays.toString(smallestDifference(input[0], input[1])));
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int smallestOne = 0;
        int smallestTwo = 0;
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arrayOne.length; i++) {
            for (int x = 0; x < arrayTwo.length; x++) {
                System.out.println(arrayOne[i] + " " + arrayTwo[x] + "  " + Math.abs(arrayOne[i] - arrayTwo[x]));
                int diff = Math.abs(arrayOne[i] - arrayTwo[x]);
                if (diff < smallestDiff) {
                    smallestDiff = diff;
                    smallestOne = arrayOne[i];
                    smallestTwo = arrayTwo[x];
                }
            }
        }
        return new int[]{smallestOne, smallestTwo};
    }
}
