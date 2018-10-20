package tasks.secondTime.Chapter4;

import tasks.graphs.Tree;
import tasks.graphs.TreeNode;

public class ValidateBalancedTree {

    public static boolean check(Tree tree) {
        return check(tree.root);
    }

    private static boolean check(TreeNode node) {
        if (node == null) return true;
        if (Math.abs(getMaxHeight(node.left) - getMaxHeight(node.right)) > 1) {
            return false;
        } else {
            return check(node.left) && check(node.right);
        }
    }

    private static int getMaxHeight(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;

        return Math.max(getMaxHeight(node.left), getMaxHeight(node.right)) + 1;
    }

}
