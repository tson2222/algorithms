package algoexpert.easy;

public class Cäsar {

    public static String caesarCypherEncryptor(String str, int key) {
        key = key % 26;
        System.out.println("Move " + key + " chars forward");
        char[] chars = str.toCharArray();
        StringBuilder charsEncry = new StringBuilder();
        // A = 1, Z = 26
        for (char c : chars) {
            int x = (int) c - 96;
            System.out.println("Char value " + c + " with number value: " + x);
            if (x + key > 26) {
                int val = x + key;
                val = val % 26;
                val += 96;
                System.out.println("Value after modulo: " + val);
                charsEncry.append((char) val);
            } else {
                x += key + 96;
                charsEncry.append((char) x);
            }
        }
        return charsEncry.toString();
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 27));
    }
}
