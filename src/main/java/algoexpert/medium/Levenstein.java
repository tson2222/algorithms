package algoexpert.medium;


import java.util.List;
import java.util.stream.Collectors;

public class Levenstein {

    public static int levenshteinDistance(String str1, String str2) {
        int[][] edits = new int[str2.length() + 1][str1.length() + 1];
        for (int i = 0; i < str2.length() + 1; i++) {
            for (int j = 0; j < str1.length() + 1; j++) {
                edits[i][j] = j;
            }
            edits[i][0] = i;
        }
        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1]));
                }
            }
        }
        return edits[str2.length()][str1.length()];
    }


    public static void main(String[] args) {
        System.out.println(levenshteinDistance("", ""));
        System.out.println(levenshteinDistance("levent", "leven"));
        System.out.println(levenshteinDistance("abd", "abc"));
        System.out.println(levenshteinDistance("kera", "fag"));
        System.out.println(levenshteinDistance("biting", "mitten"));
        String b ="benyam";
        System.out.println(b.substring(0,0));
        System.out.println(b.substring(0,6));
    }
}
