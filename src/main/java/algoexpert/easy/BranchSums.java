package algoexpert.easy;

import java.util.*;

public class BranchSums {


    // Calculate sum of those 4 branches.
       //    2   \\
      //   5    7   \\
     //  0   44   1  22 \\
    // #1  #2  #3  #4
    public static void main(String[] args) {
        BinaryTree left = new BinaryTree(5);
        BinaryTree right = new BinaryTree(7);
        BinaryTree left2 = new BinaryTree(0);
        BinaryTree right2 = new BinaryTree(44);
        BinaryTree left3 = new BinaryTree(1);
        BinaryTree right3 = new BinaryTree(22);
        left.left = left2;
        left.right = right2;
        right.left = left3;
        right.right = right3;
        BinaryTree root = new BinaryTree(2, left, right);
        System.out.println(branchSums(root));
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        BinaryTree(int value, BinaryTree left, BinaryTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> branchSums = new ArrayList<>();
        int sum = 0;
        calculateBranchSums(branchSums, sum, root);
        return branchSums;
    }

    static void calculateBranchSums(List<Integer> branchSums, int currentSum, BinaryTree currentNode) {
        if (currentNode.left == null && currentNode.right == null) {
            currentSum += currentNode.value;
            System.out.println("added new branch sum" + currentSum);
            branchSums.add(currentSum);
            return;
        }
        currentSum += currentNode.value;
        System.out.println(currentSum);
        if (currentNode.left != null) calculateBranchSums(branchSums, currentSum, currentNode.left);
        if (currentNode.right != null) calculateBranchSums(branchSums, currentSum, currentNode.right);
    }
}
