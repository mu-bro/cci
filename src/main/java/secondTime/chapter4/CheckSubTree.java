package secondTime.chapter4;

import firstTime.helpers.TreeNode;

public class CheckSubTree {

    public static boolean check(TreeNode t1, TreeNode t2) {
        return findT2(t1, t2);
    }

    private static boolean findT2(TreeNode node, TreeNode t2) {
        if (node == null) return false;

        if (node.data == t2.data) {
            if (checkIfSubTree(node, t2)) return true;
        }
        return findT2(node.left, t2) || findT2(node.right, t2);
    }

    private static boolean checkIfSubTree(TreeNode node, TreeNode t2) {
        if (node == null && t2 == null) return true;
        if (node == null || t2 == null) return false;
        if (node.data != t2.data) return false;

        return checkIfSubTree(node.left, t2.left) && checkIfSubTree(node.right, t2.right);
    }
}
