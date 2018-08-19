package secondTime.chapter4;

import firstTime.helpers.TreeNode;

public class FindAncestor2 {

    public static int find(TreeNode root, TreeNode first, TreeNode second) {
        if (!contains(root, second) || !contains(root, first)) return Integer.MIN_VALUE;

        return findAncestor(root, first, second);
    }

    private  static int findAncestor(TreeNode root, TreeNode first, TreeNode second) {
        boolean contFirst = contains(root.left, first);
        boolean contSecond = contains(root.left, second);

        if (contFirst && contSecond) {
            return findAncestor(root.left, first, second);
        } else if (!contFirst && !contSecond) {
            return findAncestor(root.right, first, second);
        } else return root.data;
    }


    private static boolean contains(TreeNode dynamic, TreeNode staticNode) {
        if (dynamic == null) return false;
        if (dynamic.left == null && dynamic.right == null) return false;
        if (dynamic.left != null && dynamic.left.equals(staticNode)) return true;
        if (dynamic.right != null && dynamic.right.equals(staticNode)) return true;

        return contains(dynamic.left, staticNode) || contains(dynamic.right, staticNode);
    }
}
