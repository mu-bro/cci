package secondTime.chapter4;

import firstTime.helpers.TreeNode;

public class FindAncestor {

    public static int find(TreeNode first, TreeNode second) {
        if (contains(first, second)) return first.data;
        if (contains(second, first)) return second.data;

        if (depth(first) < depth(second)) {
            return findAssesor(first.parent, second);
        } else {
            return findAssesor(second.parent, first);
        }
    }

    private static int depth(TreeNode node) {
        int depth = 0;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    private static int findAssesor(TreeNode dynamic, TreeNode staticNode) {
        while (!contains(dynamic, staticNode)) {
            dynamic = dynamic.parent;
            if (dynamic == null) return Integer.MIN_VALUE;
        }
        return dynamic.data;
    }

    private static boolean contains(TreeNode dynamic, TreeNode staticNode) {
        if (dynamic == null) return false;
        if (dynamic.left == null && dynamic.right == null) return false;
        if (dynamic.left != null && dynamic.left.equals(staticNode)) return true;
        if (dynamic.right != null && dynamic.right.equals(staticNode)) return true;

        return contains(dynamic.left, staticNode) || contains(dynamic.right, staticNode);
    }
}
