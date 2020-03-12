package algoexpert.easy;

public class PalindromeCheck {

    public static boolean isPalindrome(String str) {
        if (str.length() % 2 != 0) {
            str = str.substring(0, (str.length() / 2)) + str.substring(str.length() / 2 + 1);
        }
        String front = str.substring(0, str.length() / 2);
        String back = "";
        char[] arr = str.toCharArray();
        for (int i = str.length(); i > str.length() / 2; i--) {
            back = back.concat(arr[i - 1] + "");
        }
        if (front.equals(back)) return true;
        return false;
    }


    public static boolean isPalindromeRecursive(String str) {
        if (str.length() == 2 || str.length() == 3) {
            if (str.charAt(0) == str.charAt(str.length()-1)) return true;
        }
        if (str.charAt(0) == str.charAt(str.length()-1)) {
            return isPalindromeRecursive(str.substring(1,str.length()-1));
        }
        return false;
    }
    public static boolean isPalindromeIterative(String str) {
       for (int i = 0;i<str.length()/2;i++){
           if(str.charAt(i) != str.charAt(str.length()-1-i)){
               return false;
           }
       }
       return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("hannah"));
        System.out.println(isPalindrome("TacocaT"));
        System.out.println(isPalindrome("Not a Palindrome"));

        System.out.println(isPalindromeReverseString("hannah"));
        System.out.println(isPalindromeReverseString("TacocaT"));
        System.out.println(isPalindromeReverseString("Not a Palindrome"));

        System.out.println(isPalindromeIterative("hannah"));
        System.out.println(isPalindromeIterative("TacocaT"));
        System.out.println(isPalindromeIterative("Not a Palindrome"));

        System.out.println(isPalindromeRecursive("hannah"));
        System.out.println(isPalindromeRecursive("TacocaT"));
        System.out.println(isPalindromeRecursive("Not a Palindrome"));

    }

    public static boolean isPalindromeReverseString(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        if (reverse.equals(str)) return true;
        return false;
    }
}
