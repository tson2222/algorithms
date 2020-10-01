package algoexpert.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MonotonicArray {

    public static void main(String[] args) {
        int[] test = { -1, -5, -10, -1100, -1101, -1102, -9001 };
        System.out.println(isMonotonic(test));
    }

    public static boolean isMonotonic(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return true;
        }
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        if (checkMonotonicIncreasing(list) || checkMonotonicDecreasing(list)) {
            return true;
        }
        return false;
    }

    private static boolean checkMonotonicIncreasing(final List<Integer> list) {
        Integer current = list.get(0);
        for (Integer inty : list) {
            if (inty >= current) {
                current = inty;
                continue;
            }
            System.out.println("not increasing!");
            return false;
        }
        return true;
    }

    private static boolean checkMonotonicDecreasing(final List<Integer> list) {
        Integer current = list.get(0);
        for (Integer inty : list) {
            if (inty <= current) {
                current = inty;
                continue;
            }
            System.out.println("not decreasing!");
            return false;
        }
        return true;
    }

}
