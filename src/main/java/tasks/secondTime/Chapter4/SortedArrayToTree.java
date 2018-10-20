package tasks.secondTime.Chapter4;

import tasks.graphs.Tree;
import tasks.graphs.TreeNode;

import java.util.Arrays;


// O ( log N)
public class SortedArrayToTree {

    public static Tree apply(int[] input) {
        TreeNode root = subTree(input);
        return new Tree(root);
    }

    private static TreeNode subTree(int[] input) {
        if (input.length == 1) {
            return new TreeNode(input[0]);
        }
        int middle = (input.length / 2);
        int pivot = input[middle];
        TreeNode tree = new TreeNode(pivot);
        if (0 < middle) {
            tree.left = subTree(Arrays.copyOfRange(input, 0, middle));
        }
        if (middle < input.length - 1) {
            tree.right = subTree(Arrays.copyOfRange(input, middle + 1, input.length));
        }
        return tree;
    }
}
