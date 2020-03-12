package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinNumberOfCoinsForChange {


    public static void main(String[] args) {
        int[] arr = {1, 5, 10};
        System.out.println(minNumberOfCoinsForChange(4, arr));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if(n == 0) return 0;
        int[] relevantNums = new int[denoms.length];
        int counter = 0;
        for (int i = 0; i < denoms.length; i++) {
            if (denoms[i] % n == 0) {
                return 1;
            }
//            if (n % denoms[i] == 0) {
//                System.out.println(n/denoms[i]);
//                return n/denoms[i];
//            }
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
        Arrays.stream(arr).forEach(list::add);
        Collections.reverse(list);
    //    list.forEach(System.out::println);
        for (Integer i : list) {
            if (i == 0) break;
            int coinsNeeded = findLowestCoinsNeededWithBiggestCoinBeing(n, i, list);
        //    System.out.println("coinsNeeded: " + coinsNeeded);
            if (coinsNeeded < min) {
                min = coinsNeeded;
            }
        }
        return min;
    }

    private static int findLowestCoinsNeededWithBiggestCoinBeing(int n, Integer current, List<Integer> list) {
      //  System.out.println("big coin: " + current);
        List<Integer> copy = new ArrayList<>(list);
        int min = Integer.MAX_VALUE;
        copy.remove(current);
        int currentRemainder = n - current;
        for (Integer i : copy) {
            if (i == 0) {
                break;
            }
      //      System.out.println(currentRemainder  + " div by " + i + " ?");
            if (currentRemainder  % i == 0) {
     //           System.out.println("TEST: " + currentRemainder  / i);
                return 1 + (currentRemainder  / i);
            }
        }
        return min;
    }

}
