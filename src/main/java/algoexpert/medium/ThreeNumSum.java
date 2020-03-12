package algoexpert.medium;

import java.util.*;

public class ThreeNumSum {

    public static List<Integer[]> threeNumberSum(int[] arr, int targetSum) {
        List<Integer[]> multidim = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int y = i + 1; y < arr.length; y++) {
                for (int z = y + 1; z < arr.length; z++) {
                    if (arr[i] + arr[y] + arr[z] == targetSum) {
                        Integer[] res = {arr[i], arr[y], arr[z]};
                        Arrays.sort(res);
                        multidim.add(res);
                    }
                }
            }
        }

        Collections.sort(multidim, (a, b) -> {
            if (!a[0].equals(b[0])) return a[0] - b[0];
            if (!a[1].equals(b[1])) return a[1] - b[1];
            if (!a[2].equals(b[2])) return a[2] - b[2];
            return 0;
        });
     //  Collections.reverse(multidim);
        return multidim;
    }



    public static void main(String[] args) {
        int[] arr = {12, 3, 1, 2, -6, 5, -8, 6};
        threeNumberSum(arr, 0).forEach(x -> System.out.println(Arrays.toString(x)));
    }

}
