package algoexpert.easy;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        int[] result = new int[2];
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            System.out.println(num);
            for (int j = i + 1; j < array.length; j++) {
                if (num + array[j] == targetSum) {
                    result[0] = num;
                    result[1] = array[j];
                    System.out.println(num + " and " + array[j] + " sum up to the target numer " + targetSum + "!");
                    return result;
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 6, 23, 4, 3};
        twoNumberSum(ar, 26);
    }
}
