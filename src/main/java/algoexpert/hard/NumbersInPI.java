package algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class NumbersInPI {

    public static void main(String[] args) {
        //"3|1|4|1|592|65|35|8|9793|2384626|4|3|3|83279" 13 spaces!
        System.out.println(numbersInPi("3141592653589793238462643383279", new String[] {
                "3",
                "1",
                "4",
                "592",
                "65",
                "55",
                "35",
                "8",
                "9793",
                "2384626",
                "83279"
        }));
    }

    static Map<String, Integer> hashmap;

    static List<Integer> counts;

    static int count;

    public static int numbersInPi(String pi, String[] numbers) {
        hashmap = new HashMap<>();
        counts = new ArrayList<>();
        Arrays.stream(numbers).forEach(
                number -> {
                    if (pi.contains(number)) {
                        hashmap.put(number, pi.indexOf(number));
                    }
                });
        //hashmap.forEach((key, value) -> System.out.println(key + " -> " + value.start + "," + value.end));
        List<Map.Entry> indices = hashmap.entrySet().stream().filter(entry -> entry.getValue() == 0).collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : indices) {
            count = 0;
            System.out.println("KEY: " + entry.getKey());
            List<String> nums = new CopyOnWriteArrayList<>(numbers);
           // nums.remove(entry.getKey());
            String[] arr = nums.toArray(new String[nums.size()]);
            String piVal = pi.replaceFirst(entry.getKey(), "");
            count++;
            numbersInPiRecursive(piVal, arr);
        }
        if(!counts.isEmpty()){
            return Collections.min(counts);
        }
        return -1;
    }

    public static void numbersInPiRecursive(String pi, String[] numbers) {
        hashmap = new HashMap<>();
        System.out.println("Current PI value: " + pi);
        System.out.println(pi.length());
        if (pi.length() == 0) {
            System.out.println("WAH!");
            counts.add(count -1);
        }
        Arrays.stream(numbers).forEach(
                number -> {
                    if (pi.contains(number)) {
                        hashmap.put(number, pi.indexOf(number));
                    }
                });
        hashmap.forEach((key, value) -> System.out.println(key + " -> " + value));
        List<Map.Entry> indices = hashmap.entrySet().stream().filter(entry -> entry.getValue() == 0).collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : indices) {
            System.out.println("KEY: " + entry.getKey());
            List<String> nums = new CopyOnWriteArrayList<>(numbers);
            //nums.remove(entry.getKey());
            String[] arr = nums.toArray(new String[nums.size()]);
            String piVal = pi.replaceFirst(entry.getKey(), "");
            count++;
            numbersInPiRecursive(piVal, arr);
        }
    }

}
