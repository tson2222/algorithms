package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleCycleCheck {

    public static void main(String[] args) {
        System.out.println(hasSingleCycle(new int[] { 1,-1,1,-1}));
    }

    public static boolean hasSingleCycle(int[] array) {
        List<Integer> list = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        Arrays.stream(array).forEach(list::add);
        int counter = 0;
        int currentIndex = 0;
        Set<Integer> preventCycle = new HashSet<>();
        while (counter < array.length) {
            visited.add(list.get(currentIndex));
            if(list.get(currentIndex) == 0 && counter != array.length -1){
                return false;
            }
            int calc = calculateIndex(currentIndex, list.get(currentIndex), list.size());
            preventCycle.add(calc);
            System.out.println("calculated index: " + calc);
            currentIndex = calc;
            counter++;
        }
        return list.containsAll(visited) && currentIndex == 0 && preventCycle.size() == list.size();
    }

    public static int calculateIndex(int currentIndex, int jumps, int size) {
        System.out.println("Calculate Index for current Index: " + currentIndex + " jumps " + jumps + " and size " + size);
        //If in bounds just return currentIndex + Jumps
        if (currentIndex + jumps < size && currentIndex + jumps >= 0) {
            System.out.println("Index in bounds");
            return currentIndex + jumps;
        }
        //mod the jumps to get true jump value
        int neededJumps = jumps % size;
        if (currentIndex + neededJumps < 0) {
            System.out.println("Negative overflow");
            return size + (currentIndex + neededJumps);
        } else {
            System.out.println("Positive overflow");
            return (currentIndex + neededJumps) % size;
        }
    }

}
