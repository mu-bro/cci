package tasks.secondTime.Chapter4;

import tasks.graphs.Tree;
import tasks.graphs.TreeNode;

public class Successor {

    public static TreeNode find(TreeNode node) {
        if (node.right != null) {
            return findMin(node.right);
        }
//        if (node.parent != null && node.parent.data > node.data) {
//            return node.parent;
//        } else {
            TreeNode someNode = node.parent;
            while (someNode != null && someNode.data < node.data) {
                someNode = someNode.parent;
            }
            if (someNode == null) {
                return null;
            } else {
                return someNode;
            }
//        }
    }

    private static TreeNode findMin(TreeNode node) {
        TreeNode minNode = node;
        while (minNode.left != null) {
            minNode = minNode.left;
        }
        return minNode;
    }
}
