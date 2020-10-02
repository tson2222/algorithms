package algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumSum {

    public static void main(String[] args) {
        List<Integer[]> output = fourNumberSum(new int[] { 7, 6, 4, -1, 1, 2 }, 16);
        List<Integer[]> quadruplets = new ArrayList<Integer[]>();
        quadruplets.add(new Integer[] { 7, 6, 4, -1 });
        quadruplets.add(new Integer[] { 7, 6, 1, 2 });
        System.out.println(output);
    }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        Map<Integer, List<Tuple>> tupleMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                tupleMap.computeIfAbsent(array[i] + array[j], k -> new ArrayList<>())
                        .add(new Tuple(array[i], array[j]));
            }
        }

        tupleMap.forEach((key, value) -> {
            int temp = targetSum - key;
            System.out.println("Look up HashTable KEY:" + temp);
            if (tupleMap.get(temp) != null) {
                for (Tuple t1 : value) {
                    for (Tuple t2 : tupleMap.get(temp)) {
                        if (result.isEmpty() || !alreadyContainsSolution(result, t1, t2)) {
                            addToResult(result, t1, t2);
                        }
                    }
                }
            }

        });
        return result;
    }

    private static boolean alreadyContainsSolution(final List<Integer[]> result, Tuple t1, Tuple t2) {
        for (Integer[] arr : result) {
            List<Integer> list = Arrays.asList(arr);
            if (list.contains(t1.a) && list.contains(t1.b) && list.contains(t2.a) && list.contains(t2.b)) {
                return true;
            }
        }
        return false;
    }

    private static void addToResult(final List<Integer[]> result, final Tuple t1, final Tuple t2) {
        System.out.println("Found a solution:" + t1.a + "" + t1.b + "" + t2.a + "" + t2.b);
        if(t1.a == t2.a || t1.a == t2.b || t1.b == t2.a || t1.b == t2.b){
            return;
        }
        Integer[] quadruplet = { t1.a, t1.b, t2.a, t2.b };
        result.add(quadruplet);
    }

    private static class Tuple {
        int a, b;

        public Tuple(final int a, final int b) {
            this.a = a;
            this.b = b;
        }

    }

}
