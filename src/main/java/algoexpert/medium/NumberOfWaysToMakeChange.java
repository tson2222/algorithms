package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfWaysToMakeChange {

    public static void main(String[] args) {
        int[] input = { 1, 5 };
        System.out.println(numberOfWaysToMakeChange(6, input));
    }

    static Set<List<Integer>> uniqueWaysToMakeChange;

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        if(n == 0){
            return 1; //if the target is zero there is just one way. To not give anything back.
        }
        uniqueWaysToMakeChange = new HashSet<>();
        for (int denom : denoms) {
            List<Integer> list = new ArrayList<>();
            Arrays.stream(denoms).forEach(list::add);
            numberOfWaysToMakeChange(n, new ArrayList<>(denom), list);
        }
        return uniqueWaysToMakeChange.size();
    }

    public static void numberOfWaysToMakeChange(int n, List<Integer> current, List<Integer> denoms) {
        for (Integer denom : denoms) {
            if (current.stream().mapToInt(i -> i).sum() + denom == n) {
                List<Integer> way2MakeChange = new ArrayList<>(current);
                way2MakeChange.add(denom);
                Collections.sort(way2MakeChange);
                uniqueWaysToMakeChange.add(way2MakeChange);
            }
            if (current.stream().mapToInt(i -> i).sum() + denom < n) {
                List<Integer> list = new ArrayList<>(current);
                list.add(denom);
                numberOfWaysToMakeChange(n, list, denoms);
            }
        }
    }

}
