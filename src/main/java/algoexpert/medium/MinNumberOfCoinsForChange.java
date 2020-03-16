package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinNumberOfCoinsForChange {


    public static void main(String[] args) {
        int[] arr = {4, 2, 3};
        System.out.println(minNumberOfCoinsForChange(13, arr));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if (n == 0) return 0;
        int[] relevantNums = new int[denoms.length];
        int counter = 0;
        for (int i = 0; i < denoms.length; i++) {
            if (denoms[i] % n == 0) {
                return 1;
            }
            if (denoms[i] > n || denoms[i] < 1) {
                break;
            }
            relevantNums[counter++] = denoms[i];
        }
        return tryAllDenomPermuts(n, relevantNums);
    }

    private static int tryAllDenomPermuts(int n, int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        Arrays.stream(arr).filter(i -> i != 0).forEach(list::add);
        return 0;
    }

}
