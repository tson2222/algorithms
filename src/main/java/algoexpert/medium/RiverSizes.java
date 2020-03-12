package algoexpert.medium;

import java.util.*;

public class RiverSizes {

    static int accumulator;

    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1},};

        int[][] input2 = {
                { 1, 0, 0, 1, 0 },
                { 1, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 0 } };
        riverSizes(input).forEach(System.out::println);
        riverSizes(input2).forEach(System.out::println);
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        System.out.println("Trying to find all rivers for matrix");

        for (int arrayIndex = 0; arrayIndex < matrix.length; arrayIndex++) { //for each matrix
            printMatrix(matrix);
            for (int position = 0;
                 position < matrix[arrayIndex].length; position++) { //for each riverpart in this matrix
                int riversize = findAllRiverParts(matrix, arrayIndex, position, 0);
                if (riversize > 0) {
                    printMatrix(matrix);
                    System.out.println("Found a river with size: " + riversize);
                    res.add(riversize);
                    accumulator = 0;
                }
            }
        }
        return res;
    }

    private static int findAllRiverParts(int[][] matrix, int arrayIndex, int position, int riversize) {
        //if there is a river part on the right or bottom of the current part
        if (position < matrix[arrayIndex].length) {
            if (matrix[arrayIndex][position] == 1) {
                matrix[arrayIndex][position] = 0;
                riversize++;
                riverRecursion(matrix, arrayIndex, position);
                {
                }
            }
        }
        riversize += accumulator;
        System.out.println(
                "Riversize " + riversize + " for array number: " + (arrayIndex + 1) + " at position " + (position + 1));
        return riversize;
    }

    private static void riverRecursion(int[][] matrix, int arrayIndex, int position) {
        if (hasRiverPartOnRightSide(matrix[arrayIndex], position)) {
            accumulator++;
            riverRecursion(matrix, arrayIndex, position + 1);
        }
        if (hasRiverPartOnLeftSide(matrix[arrayIndex], position)) {
            accumulator++;
            riverRecursion(matrix, arrayIndex, position - 1);
        }
        if (hasRiverPartOnBottomSide(matrix, arrayIndex, position)) {
            accumulator++;
            riverRecursion(matrix, arrayIndex + 1, position);
        }
        if (hasRiverPartOnTopSide(matrix, arrayIndex, position)) {
            accumulator++;
            riverRecursion(matrix, arrayIndex - 1, position);
        }
    }

    private static boolean hasRiverPartOnRightSide(final int[] matrix, final int position) {
        if (position + 1 < matrix.length && matrix[position + 1] == 1) {
            matrix[position + 1] = 0;
            return true;
        }
        return false;
    }

    private static boolean hasRiverPartOnLeftSide(final int[] matrix, final int position) {
        if (position - 1 >= 0 && matrix[position - 1] == 1) {
            matrix[position - 1] = 0;
            return true;
        }
        return false;
    }

    private static boolean hasRiverPartOnBottomSide(int[][] matrix, int arrayIndex, int position) {
        if (arrayIndex == matrix.length - 1) {
            return false;
        }
        if (position < matrix[arrayIndex + 1].length) {
            if (matrix[arrayIndex + 1][position] == 1) {
                matrix[arrayIndex + 1][position] = 0;
                return true;
            }
        }
        return false;
    }

    private static boolean hasRiverPartOnTopSide(int[][] matrix, int arrayIndex, int position) {
        if (arrayIndex == 0) {
            return false;
        }
        if (position < matrix[arrayIndex - 1].length) {
            if (matrix[arrayIndex - 1][position] == 1) {
                matrix[arrayIndex - 1][position] = 0;
                return true;
            }
        }
        return false;
    }

    private static void printMatrix(final int[][] matrix) {
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
