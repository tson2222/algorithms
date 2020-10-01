package algoexpert.easy;

import java.util.List;

public class ValidateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        if (sequence.size() > array.size()) {
            return false;
        }
        for (Integer inty : sequence) {
            if (!array.contains(inty)) {
                return false;
            }
        }
        array.removeIf(inty -> !sequence.contains(inty)); //items that dont appear in the sequence can be removed! It doesnt change the order
        for (Integer inty : sequence) {
            if (sequence.indexOf(inty) != array.indexOf(inty)) {
                return false;
            }
        }
        return sequence.size() <= array.size();
    }

}


