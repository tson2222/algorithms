package algoexpert.easy;

import java.util.Arrays;

public class  BinarySearch {

    //Binary Search can be applied only on sorted arrays!
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int target, int left, int right) {
        System.out.println(Arrays.toString(array));
        if (left > right) {
            return -1;   //no more subarrays
        }
        int middle = (left + right) / 2;
        int potentialMatch = array[middle];
        if (target == potentialMatch) {
            return middle;
        } else if (target < potentialMatch) {
            return binarySearch(array, target, left, middle - 1);
        }
        return binarySearch(array, target, middle + 1, right);
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1, 5, 23, 111};
        System.out.println(binarySearch(ar, 111));
        System.out.println(Arrays.binarySearch(ar,111));
    }
}
