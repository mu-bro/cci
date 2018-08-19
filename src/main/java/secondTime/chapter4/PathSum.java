package secondTime.chapter4;

import firstTime.helpers.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public static int find(TreeNode root, int givenNumber) {
        return preOrderTraverse(root, givenNumber, new ArrayList<>());
    }

    public static int preOrderTraverse(TreeNode node, int givenNumber, List<Integer> ancestors) {
        if (node == null) return 0;

        ArrayList<Integer> list = new ArrayList<>(ancestors);
        list.add(node.data);

        int paths = checkThePath(list, givenNumber);
        if (paths > 0) return paths;

        int leftPath = preOrderTraverse(node.left, givenNumber, list);
        if (leftPath > 0) {
            return leftPath;
        }
        int rightPart = preOrderTraverse(node.right, givenNumber, list);
        if (rightPart > 0) {
            return rightPart;
        }
        return 0;
    }

    private static int checkThePath(ArrayList<Integer> list, int givenNumber) {
        int sum;
        for (int i = 0; i < list.size() - 1; i++) {
            sum = list.get(i);
            if (sum >= givenNumber) return 0;
            for (int j = i + 1; j < list.size() && sum < givenNumber; j++) {
                sum += list.get(j);
                if (sum == givenNumber) {
                    return j - i;
                }
            }
        }
        return 0;
    }


}
