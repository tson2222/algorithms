package algoexpert.easy;

public class ClosestValueBST {

    public static void main(String[] args) {
        var root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        var expected = 13;
        var actual = findClosestValueInBst(root, -1);
        System.out.println(actual);
    }

    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, target,10000000); //dont use Integer.MAX or it will cause overflow when the value is negative!
    }

    public static int findClosestValueInBst(BST tree, int target, int currentClosest) {
        System.out.println("closest: " + currentClosest);
        System.out.println("abs 1 " + Math.abs(target - tree.value) + " abs 2 " + Math.abs(currentClosest - target));

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
