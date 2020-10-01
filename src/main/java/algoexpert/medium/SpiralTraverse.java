package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraverse {

    static int height, width;

    public static List<Integer> spiralTraverse(int[][] array) {
        height = array.length - 1;
        width = array[0].length - 1;
        List<Integer> result = new ArrayList<>();
        spiralRecursiveFunction(array, 0, 0, result);
        System.out.println(Arrays.toString(result.toArray()));
        return result;
    }

    private static void spiralRecursiveFunction(int[][] matrix, int arrayIndex, int position,
            final List<Integer> result) {
        if (baseCaseCondition(matrix, arrayIndex, position)) {
            result.add(matrix[arrayIndex][position]);
            return;
        }
        while (hasPartOnRightSide(matrix, arrayIndex, position)) {
            System.out.println("Going right");
            result.add(matrix[arrayIndex][position]);
            matrix[arrayIndex][position] = Integer.MIN_VALUE;
            position++;
        }
        while (hasRiverPartOnBottomSide(matrix, arrayIndex, position)) {
            System.out.println("Going down");
            result.add(matrix[arrayIndex][position]);
            matrix[arrayIndex][position] = Integer.MIN_VALUE;
            arrayIndex++;
        }
        while (hasRiverPartOnLeftSide(matrix, arrayIndex, position)) {
            System.out.println("Going left");
            result.add(matrix[arrayIndex][position]);
            matrix[arrayIndex][position] = Integer.MIN_VALUE;
            position--;
        }
        while (hasRiverPartOnTopSide(matrix, arrayIndex, position)) {
            System.out.println("Going top");
            result.add(matrix[arrayIndex][position]);
            matrix[arrayIndex][position] = Integer.MIN_VALUE;
            arrayIndex--;
        }
        spiralRecursiveFunction(matrix, arrayIndex, position, result);
    }

    private static boolean baseCaseCondition(final int[][] matrix, final int arrayIndex, final int position) {
        return (!hasPartOnRightSide(matrix, arrayIndex, position)
                && !hasRiverPartOnLeftSide(matrix, arrayIndex, position)
                && !hasRiverPartOnBottomSide(matrix, arrayIndex, position)
                && !hasRiverPartOnTopSide(matrix, arrayIndex, position));
    }

    private static boolean hasPartOnRightSide(int[][] matrix, final int arrayIndex, final int position) {
        System.out.println("current position" + position + " at array Index: " + arrayIndex);
        if (position + 1 > width) {
            return false;
        }
        return matrix[arrayIndex][position + 1] != Integer.MIN_VALUE;
    }

    private static boolean hasRiverPartOnLeftSide(int[][] matrix, int arrayIndex, int position) {
        System.out.println("current position" + position + " at array Index: " + arrayIndex);
        if (position - 1 < 0) {
            return false;
        }
        return matrix[arrayIndex][position - 1] != Integer.MIN_VALUE;
    }

    private static boolean hasRiverPartOnBottomSide(int[][] matrix, int arrayIndex, int position) {
        System.out.println("current position" + position + " at array Index: " + arrayIndex);
        if (arrayIndex + 1 > height) {
            return false;
        }
        return matrix[arrayIndex + 1][position] != Integer.MIN_VALUE;
    }

    private static boolean hasRiverPartOnTopSide(int[][] matrix, int arrayIndex, int position) {
        System.out.println("current position" + position + " at array Index: " + arrayIndex);
        if (arrayIndex - 1 < 0) {
            return false;
        }
        return matrix[arrayIndex - 1][position] != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        var input =
                new int[][] {
                        { 1, 2, 3, 4 },
                        { 12, 13, 14, 5 },
                        { 11, 16, 15, 6 },
                        { 10, 9, 8, 7 },
                };
        spiralTraverse(input);
    }

}
