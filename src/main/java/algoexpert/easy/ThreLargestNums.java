package algoexpert.easy;

import java.util.Arrays;

public class ThreLargestNums {

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] three = new int[3];

        for (int i = 2; i >= 0; i--) {
            three[i] = findBigggestNum(array);
        }
        return three;
    }

    private static int findBigggestNum(int[] array) {
        int biggest = Integer.MIN_VALUE;
        int index = 0;
        for (int i=0;i<array.length;i++) {
            System.out.println(array[i]+ " "+ biggest + "" +(array[i] > biggest));
            if (array[i] > biggest) {
                biggest = array[i];
                index = i;
            }
        }
        array[index] = Integer.MIN_VALUE; //remove the biggest!
        return biggest;
    }

    public static void main(String[] args) {
        int[] sample = {-1,-2,-3,-7,-17,-27,-18,-541,-8,-7,7};
        Arrays.stream(findThreeLargestNumbers(sample)).forEach(System.out::println);
    }

}
