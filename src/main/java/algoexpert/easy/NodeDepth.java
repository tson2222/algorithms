package algoexpert.easy;

class NodeDepth {

    static int result = 0;

    public static void main(String[] args) {
        BinaryTree btree = new BinaryTree(0);
        BinaryTree left = new BinaryTree(2);
        BinaryTree right = new BinaryTree(3);
        BinaryTree left2 = new BinaryTree(4);
        BinaryTree right2 = new BinaryTree(5);
        BinaryTree left3 = new BinaryTree(6);
        BinaryTree right3 = new BinaryTree(7);
        BinaryTree left4 = new BinaryTree(8);
        BinaryTree right4 = new BinaryTree(9);
        //id 1
        btree.left = left;
        btree.right = right;

        //id 2
        left.left = left2;
        left.right = right2;

        //id 3
        right.left = left3;
        right.right = right3;

        //id 4
        left2.left = left4;
        left2.right = right4;

        System.out.println(nodeDepths(btree));
    }

    public static int nodeDepths(BinaryTree root) {
        if (root == null) {
            return -1;
        }
        if (root.left != null) {
            nodeDepths(root.left, 1);
        }
        if (root.right != null) {
            nodeDepths(root.right, 1);
        }
        return result;
    }

    public static void nodeDepths(BinaryTree node, int level) {
        System.out.println("Currently at level: " + level + " with node id " + node.value);
        incrementResult(level);
        ++level;
        if (node.left != null) {
            nodeDepths(node.left, level);
        }
        if (node.right != null) {
            nodeDepths(node.right, level);
        }
    }

    private static void incrementResult(final int level) {
        System.out.println("Increment Result by " + level);
        result += level;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            result = 0;
            this.value = value;
            left = null;
            right = null;
        }
    }

}
