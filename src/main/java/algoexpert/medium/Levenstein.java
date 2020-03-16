package algoexpert.medium;


import java.util.List;
import java.util.stream.Collectors;

public class Levenstein {

    public static int levenshteinDistance(String str1, String str2) {
        int edits = 0;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int arr1length = arr1.length;
        int arr2length = arr2.length;
        List<Character> chars = str2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for (char c : arr1) {
           System.out.print(c);
            if (chars.contains(c)) {
                System.out.println(1);
                chars.remove(new Character(c)); //remove matching char
                if(chars.contains(c)){
                    edits++;
                }
                continue;
            }
            if (arr1length > arr2length) {
                System.out.println(2);
                edits++;                    //remove
                arr1length--;
                continue;
            }
            if (arr1length < arr2length) {
                System.out.println(3);
                chars.add(c);
                edits++;                  //add
                arr1length++;
                continue;
            }
           else{
                System.out.println(4);
                chars.add(c);           //substit
                edits++;
            }
        }
 //      System.out.println(arr1length + " " + arr2.length);

        edits += Math.abs(arr1length - arr2.length); //add inserts and deletes
        return edits;
    }

    public static void main(String[] args) {
//        System.out.println(levenshteinDistance("", "abc"));
//        System.out.println(levenshteinDistance("levent", "leven"));
//        System.out.println(levenshteinDistance("abd", "abc"));
//        System.out.println(levenshteinDistance("kera", "fag"));
        System.out.println(levenshteinDistance("biting", "mitten"));

    }
}
