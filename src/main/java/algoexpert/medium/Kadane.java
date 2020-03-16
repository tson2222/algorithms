package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kadane {
//
//    public static int kadanesAlgorithm(int[] array) {
//        List<int[]> subarrays = findSubArrays(array);
//        subarrays.forEach(a -> System.out.println(Arrays.toString(a)));
//        int[] biggestSub = subarrays.stream().max((arr, arr2) -> get(arr, arr2)).get();
//        return Arrays.stream(biggestSub).sum();
//    }
//
//    private static int get(int[] arr, int[] arr2) {
//        return Arrays.stream(arr).sum() - Arrays.stream(arr2).sum();
//    }
//
//    private static List<int[]> findSubArrays(int[] array) {
//        List<int[]> subarrays = new ArrayList<>();
//        boolean bool = true;
//        while (bool) {
//            int[] currentSubarray = new int[array.length];
//            for (int i = 0; i < array.length; i++) {
//                if (i == 0) {
//                    currentSubarray[i] = array[i];
//                    continue;
//                }
//                System.out.println("current val: " + array[i] + " subarr sum " + Arrays.stream(currentSubarray).sum() + " i: " + i);
//                System.out.println((array[i] + Arrays.stream(currentSubarray).sum()) <= 0);
//                if (!(array[i] < 0 && (array[i] + Arrays.stream(currentSubarray).sum()) < 0 )){ //if the number is positive or the number is negative yet the sum of current + this number isnt smaller than 0
//                    currentSubarray[i] = array[i];
//                    if (i >= array.length - 1) {
//                        subarrays.add(currentSubarray);
//                        bool = false;
//                        break;
//                    }
//                } else {
//                    subarrays.add(currentSubarray);
//                    currentSubarray = new int[array.length];
//                }
//            }
//        }
//        return subarrays;
//    }

    //this solution is much better because no subarrays must be stored, only the maxSoFar value. Also only one iteration needed. So O(n).
    //biggest subarray sum gets saved into maxEndingHere, so there is no need to check if the values afterwards might
    public static int clem(int[] array) {
        int maxEndingHere = array[0],maxSoFar = array[0];
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            System.out.println("maxsofar " + maxSoFar + " num: " + num + " maxendinghere: " + maxEndingHere + " sum:"+ (maxEndingHere + num));
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] test = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(clem(test));
    }

}
