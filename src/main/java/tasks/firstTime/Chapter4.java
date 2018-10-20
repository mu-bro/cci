package tasks.firstTime;

import tasks.graphs.*;
import tasks.queues.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Chapter4 {

    public static StringBuilder inOrderTraversal(TreeNode node) {
        StringBuilder builder = new StringBuilder();
        if (node != null) {
            builder.append(inOrderTraversal(node.left));
            builder.append(node.data);
            builder.append(inOrderTraversal(node.right));
        }
        return builder;
    }

    public static StringBuilder preOrderTraversal(TreeNode node) {
        StringBuilder res = new StringBuilder();
        if (node != null) {
            res.append(node.data);
            res.append(preOrderTraversal(node.left));
            res.append(preOrderTraversal(node.right));
        }
        return res;
    }

    public static StringBuilder postOrderTraversal(TreeNode node) {
        StringBuilder builder = new StringBuilder();
        if (node != null) {
            builder.append(postOrderTraversal(node.left));
            builder.append(postOrderTraversal(node.right));
            builder.append(node.data);
        }
        return builder;
    }

    public static String depthFirstSearch(Graph graph) {
        StringBuilder output = new StringBuilder();
        String result = depthFirstSearch(graph.root, output);
        return result;
    }

    private static String depthFirstSearch(GraphNode node, StringBuilder result) {
        for (GraphNode adjacentNode : node.nodes) {
            if (adjacentNode.visited == false) {
                depthFirstSearch(adjacentNode, result);
            }
        }
        node.visited = true;
        result.append(node.data);
        return result.toString();
    }

    public static String breadthFirstSearch(Graph graph) {
        Queue queue = new Queue();
        queue.push(graph.root);
        StringBuilder output = new StringBuilder();

        while (!queue.isEmpty()) {
            GraphNode node = (GraphNode) queue.pull();
            node.visited = true;
            for (GraphNode adjacentNode : node.nodes) {
                if (adjacentNode.visited == false) {
                    queue.push(adjacentNode);
                }
            }
            output.append(node.data);
        }
        return output.toString();
    }

    public static boolean isTreeBalanced(Tree tree) {
        return (maxDepth(tree.root) - minDepth(tree.root)) <= 1;
    }

    private static int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }

    private static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    public static boolean isPathExist(Graph graph, GraphNode start, GraphNode end) {
        Queue queue = new Queue();
        queue.push(start);
        while (!queue.isEmpty()) {
            GraphNode currentNode = (GraphNode) queue.pull();
            if (currentNode != null) {
                for (GraphNode node : currentNode.nodes) {
                    if (!node.visited) {
                        if (node == end) {
                            return true;
                        } else {
                            queue.push(node);
                            node.visited = true;
                        }
                    }
                }
                currentNode.visited = true;
            }
        }
        return false;
    }

    public static Tree sortedArrayToTree(int[] array) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = addToTree(array, 0, array.length - 1);
        return tree;
    }

    private static TreeNode addToTree(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode n = new TreeNode(array[middle]);
        n.left = addToTree(array, start, middle - 1);
        n.right = addToTree(array, middle + 1, end);
        return n;
    }

    public static List binaryTreeToListOfLinkedLists(Tree tree) {
        int level = 0;
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(tree.root);
        result.add(level, list);

        while (true) {
            list = new LinkedList<>();
            for (int i = 0; i < result.get(level).size(); i++) {
                TreeNode n = result.get(level).get(i);
                if (n != null) {
                    if (n.left != null) {
                        list.add(n.left);
                    }
                    if (n.right != null) {
                        list.add(n.right);
                    }
                }
            }
            if (list.size() == 0) {
                break;
            }
            result.add(++level, list);
        }
        return result;
    }

    public static TreeNode findNextNode(TreeNode node) {
        if (node.right != null) {
            return findMin(node.right);
        }
        TreeNode firstLeft = findFirstLeft(node);
        if (firstLeft != null) {
            return firstLeft.parent;
        }
        return null;
    }

    private static TreeNode findMin(TreeNode node) {
        if (node.left != null) {
            return findMin(node.left);
        }
        return node;
    }

    private static TreeNode findFirstLeft(TreeNode node) {
        if (node == node.parent.right) {
            return findFirstLeft(node.parent);
        }
        return node;
    }

    public static TreeNode findFirstAncestor(TreeNode root, TreeNode first, TreeNode second) {
        if (covers(root.left, first) && covers(root.left, second)) {
            return findFirstAncestor(root.left, first, second);
        }
        if (covers(root.right, first) && covers(root.right, second)) {
            return findFirstAncestor(root.right, first, second);
        }
        return root;
    }

    private static boolean covers(TreeNode root, TreeNode find) {
        if (root == null) return false;
        if (root == find) return true;
        return covers(root.left, find) || covers(root.right, find);
    }

    public static boolean isSubtree(TreeNode main, TreeNode sub) {
        StringBuilder preOrderMain = preOrderTraversal(main);
        StringBuilder preOrderSub = preOrderTraversal(sub);
        if (preOrderMain.toString().contains(preOrderSub.toString())) {
            StringBuilder inOrderMain = inOrderTraversal(main);
            StringBuilder inOrderSub = inOrderTraversal(sub);
            if (inOrderMain.toString().contains(inOrderSub.toString())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSubtree2(TreeNode main, TreeNode sub) {
        if (main == null) {
            return false;
        }
        if (main.data == sub.data) {
            if (matchTrees(main, sub)) return true;
        }
        return (isSubtree2(main.left, sub)) || (isSubtree2(main.right, sub));
    }

    private static boolean matchTrees(TreeNode main, TreeNode sub) {
        if (main == null && sub == null) return true;
        if (main == null || sub == null) return false;
        if (main.data != sub.data) return false;
        return matchTrees(main.left, sub.left) && matchTrees(main.right, sub.right);
    }

    public static void findSumPaths(TreeNode node, int value, List<Integer> buffer, int level) {
        if (node == null) return;

        buffer.add(node.data);
        int tmp = value;
        for (int i = level; i >= 0; i--) {
            tmp -= buffer.get(i);
            if (tmp == 0) {
                print(buffer, level, i);
            }
        }

        findSumPaths(node.left, value, new ArrayList<>(buffer), level + 1);
        findSumPaths(node.right, value, new ArrayList<>(buffer), level + 1);

    }

    private static void print(List<Integer> buffer, int start, int end) {
        for (int i = start; i >= end; i--) {
            System.out.print(buffer.get(i) + " ");
        }
        System.out.println();
    }


}
