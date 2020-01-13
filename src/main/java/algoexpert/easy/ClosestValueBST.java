package algoexpert.easy;

public class ClosestValueBST {

    public static void main(String[] args) {
        BST rootBst = new BST(100);
        rootBst.left = new BST(5);
        rootBst.left.left = new BST(2);
        rootBst.left.left.left = new BST(1);

        rootBst.left.right = new BST(5);
        rootBst.right = new BST(15);
        rootBst.right.right = new BST(22);
        rootBst.right.right.right = new BST(33);
        System.out.println(findClosestValueInBst(rootBst, 88, Integer.MAX_VALUE));
    }


    public static int findClosestValueInBst(BST tree, int target, int currentClosest) {
        System.out.println("closest: " + currentClosest);
        System.out.println("abs 1 " + Math.abs(target - tree.value) + " abs 2 " + Math.abs(currentClosest - tree.value));
        if (Math.abs(target - tree.value) < Math.abs(currentClosest - target)) {
            System.out.println("set" + tree.value);
            currentClosest = tree.value;
        }
        //only look left if the target value is lower than the current value. Else its an unnecessary calculation!
        if (target < tree.value && tree.left != null) return findClosestValueInBst(tree.left, target, currentClosest);
        //only look right if the target value is greater than the current value. Else its an unnecessary calculation!
        if (target > tree.value && tree.right != null) return findClosestValueInBst(tree.right, target, currentClosest);
        System.out.println("closest: " + currentClosest);
        return currentClosest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
