package tasks.secondTime.Chapter4;

import tasks.graphs.Tree;
import tasks.graphs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {

    public static ArrayList<LinkedList<Integer>> find(Tree tree) {
        ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
        find(tree.root, lists, 0);
        return lists;
    }

    public static void find(TreeNode node, ArrayList<LinkedList<Integer>> lists, int level) {
        if (node == null) return;

        LinkedList<Integer> list;
        if (lists.size() < (level + 1) || lists.get(level) == null) {
            list = new LinkedList<>();
            lists.add(level, list);
        } else {
            list = lists.get(level);
        }
        list.add(node.data);
        find(node.left, lists, level + 1);
        find(node.right, lists, level + 1);
    }
}
