package algoexpert.medium;

import java.util.*;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int helper = array.size();
        List newList = new ArrayList<Integer>();
        for (int i = 0; i < array.size(); i++) {
            int c = array.get(i);
            if (c != toMove) {
                newList.add(c);
                helper--;
            }
        }
        for (int i = 0; i < helper; i++) {
            newList.add(toMove);
        }
        return newList;
    }

}

