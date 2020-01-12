package algoexpert;

import java.util.*;

public class Knapsack {

    public static void main(String[] args) {
        // Item = {value,weight}
        // Item number     #0      #1      #2      #3
        int[][] items = {{1, 2}, {3, 4}, {6, 6}, {11, 8}};
        List<List<Integer>> result = knapsackProblem(items, 10);
        // print out the value + the indices of the items
        System.out.println("Maximum worth of Knapsack without exceeding capacity is " + result.get(0) +
                " by adding items with number " + result.get(1));
    }

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] knapsackValues = new int[items.length + 1][capacity + 1];
        for (int i = 1; i < items.length + 1; i++) {
            int currentweight = items[i - 1][1];
            int currentvalue = items[i - 1][0];
            for (int c = 0; c < capacity + 1; c++) {
                if (currentweight > c) knapsackValues[i][c] = knapsackValues[i - 1][c];
                else knapsackValues[i][c] =
                        Math.max(
                                knapsackValues[i - 1][c],
                                knapsackValues[i - 1][c - currentweight] + currentvalue);
            }
        }
        return getKnapsackItems(knapsackValues, items, knapsackValues[items.length][capacity]);
    }

    public static List<List<Integer>> getKnapsackItems(int[][] knapsackValues, int[][] items, int weight) {
        List<List<Integer>> sequence = new ArrayList<>();
        List<Integer> totalWeight = new ArrayList<>();
        totalWeight.add(weight);
        sequence.add(totalWeight);
        sequence.add(new ArrayList<>());
        int i = knapsackValues.length - 1;
        int c = knapsackValues[0].length - 1;
        while (i > 0) {
            if (knapsackValues[i][c] == knapsackValues[i - 1][c]) {
                i--;
            } else {
                sequence.get(1).add(0, i - 1);
                c -= items[i - 1][1];
                i--;
            }
            if (c == 0) {
                break;
            }
        }
        return sequence;
    }
}
