package secondTime.chapter4;

import firstTime.helpers.Queue;
import firstTime.helpers.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

//
public class BSTSequences {

    public static void find(TreeNode root) {
        List<List<Integer>> variants = new ArrayList<>();
        int depth = 0;

        find(root, depth, variants);

        print(variants, 0, "");


    }

    private static void print(List<List<Integer>> variants, int depth, String prefix) {

        for (Integer variant : variants.get(depth)) {
            String s = prefix + variant.toString();
            if (depth == variants.size() - 1) {
                System.out.println(s);
            } else {
                print(variants, depth + 1, s);
            }
        }
    }

    private static void find(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() <= depth || result.get(depth) == null) {
            result.add(depth, new ArrayList<>());
        }
        result.get(depth).add(node.data);


        find(node.left, depth + 1, result);
        find(node.right, depth + 1, result);
    }
}
