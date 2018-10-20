package tasks.secondTime.Chapter4;

import tasks.graphs.Tree;
import tasks.graphs.TreeNode;


public class ValidateBST {

    // O (N * log N)
    public static boolean validate(Tree tree) {
        return check(tree.root);
    }

    private static boolean check(TreeNode node) {
        if (node == null) return true;
        if (getMax(node.left) > node.data || getMin(node.right) < node.data) {
            return false;
        } else {
            return check(node.left) && check(node.right);
        }
    }

    private static int getMax(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        if (node.left == null && node.right == null) return node.data;

        int maxSubtree = Math.max(getMax(node.left), getMax(node.right));
        return Math.max(node.data, maxSubtree);
    }

    private static int getMin(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null && node.right == null) return node.data;

        int minSubtree = Math.min(getMin(node.left), getMin(node.right));
        return Math.min(node.data, minSubtree);
    }


    // O (N)
    public static boolean validate2(Tree tree) {
        return checkBTS(tree.root, null, null);
    }

    private static boolean checkBTS(TreeNode node, Integer min , Integer max) {
        if (node == null) return true;

        if (min != null && min > node.data || max != null && max < node.data) {
            return false;
        }

        if (!checkBTS(node.left, min, node.data) || !checkBTS(node.right, node.data, max)) {
            return false;
        }
        return true;
    }
}
