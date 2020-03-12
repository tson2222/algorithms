package algoexpert.easy;

import java.util.Arrays;
import java.util.LinkedList;

public class Cäsar {

    public static String caesarCypherEncryptor(String str, int key) {
        char[] chars = str.toCharArray();
        StringBuilder charsEncry = new StringBuilder();
        for(char c:chars){
            int x = (int) c;
            System.out.println(x);
            x+=key;
            charsEncry.append((char) x);
        }
        return charsEncry.toString();
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("ABCDEFG",1));
    }
}
