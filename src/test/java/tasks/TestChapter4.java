package tasks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tasks.firstTime.Chapter4;
import tasks.graphs.Graph;
import tasks.graphs.GraphNode;
import tasks.graphs.Tree;
import tasks.graphs.TreeNode;
import tasks.secondTime.Chapter4.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TestChapter4 {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void depthFirstSearchTest() {
        Assert.assertEquals("567289103111241", Chapter4.depthFirstSearch(getGraph()));
    }

    @Test
    public void breadthFirstSearchTest() {
        Assert.assertEquals("123456789101112", Chapter4.breadthFirstSearch(getGraph()));
    }

    private Graph getGraph() {
        Graph graph = new Graph("1");
        graph.root.add("2");
        graph.root.add("3");
        graph.root.add("4");
        graph.root.nodes.get(0).add("5");
        graph.root.nodes.get(0).add("6");
        graph.root.nodes.get(0).add("7");

        graph.root.nodes.get(1).add("8");
        graph.root.nodes.get(1).add("9");
        graph.root.nodes.get(1).add("10");

        graph.root.nodes.get(2).add("11");
        graph.root.nodes.get(2).add("12");
        return graph;
    }

    private Tree getTree() {
        Tree tree = new Tree(8);
        tree.root.addLeft(4);
        tree.root.addRight(15);
        tree.root.left.addLeft(2);
        tree.root.left.addRight(6);
        tree.root.right.addLeft(14);
        tree.root.right.addRight(20);
        return tree;
    }

    @Test
    public void isTreeBalancedTest() {
        Tree tree = getTree();
        Assert.assertTrue(Chapter4.isTreeBalanced(tree));

        tree.root.right.right.addRight(24);
        tree.root.right.right.right.addRight(30);
        Assert.assertFalse(Chapter4.isTreeBalanced(tree));
    }

    @Test
    public void isPathExistTest() {
        Graph graph = getGraph();
        GraphNode end = new GraphNode("13");
        Assert.assertFalse(Chapter4.isPathExist(graph, graph.root, end));

        graph = getGraph();
        graph.root.nodes.get(0).nodes.get(0).nodes.add(end);
        Assert.assertTrue(Chapter4.isPathExist(graph, graph.root, end));
    }

    @Test
    public void binarySearchTree() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Tree tree = Chapter4.sortedArrayToTree(arr);
        System.out.println(tree);
    }

    @Test
    public void binaryTreeToListOfLinkedListsTest() {
        Tree tree = getTree();
        tree.root.right.right.addRight(24);
        tree.root.right.right.right.addRight(30);
        List result = Chapter4.binaryTreeToListOfLinkedLists(tree);
        Assert.assertEquals(5, result.size());
    }

    @Test
    public void findNextNodeTest() {
        Tree tree = getTree();
        TreeNode newElem = new TreeNode(7);
        tree.root.left.right.addRight(newElem);
        Assert.assertEquals(8, Chapter4.findNextNode(newElem).data);

        newElem = new TreeNode(9);
        tree.root.right.left.addLeft(newElem);
        Assert.assertEquals(9, Chapter4.findNextNode(tree.root).data);

        Assert.assertEquals(14, Chapter4.findNextNode(newElem).data);
    }

    @Test
    public void findFirstAncestorTest() {
        Tree tree = getTree();
        tree.root.left.right.addRight(7);
        Assert.assertEquals(tree.root.left, Chapter4.findFirstAncestor(tree.root, tree.root.left.left, tree.root.left.right.right));
    }

    @Test
    public void isSubtreeTest() {
        Tree treeBig = getTree();
        treeBig.root.right.left.addLeft(9);

        Tree treeSmall = new Tree(15);
        treeSmall.root.addLeft(14);
        treeSmall.root.addRight(20);
        treeSmall.root.left.addLeft(9);

        Assert.assertTrue(Chapter4.isSubtree2(treeBig.root, treeSmall.root));
        treeSmall.root.right.addRight(22);
        Assert.assertFalse(Chapter4.isSubtree2(treeBig.root, treeSmall.root));
    }

    @Test
    public void findSumPathsTest() {
        Tree tree = getTree();
        tree.root.right.left.addLeft(9);
        Chapter4.findSumPaths(tree.root, 23, new ArrayList<>(), 0);
    }

    // SecondTime //

    @Test
    public void breadthFirstSearchTest2() {
        Assert.assertEquals("123456789101112", GraphTraverse.breadthFirstTraverse(getGraph()));
    }

    @Test
    public void depthFirstSearchTest2() {
        Assert.assertEquals("567289103111241", GraphTraverse.depthFirstTraverse(getGraph()));
    }

    @Test
    public void isPathExistTest2() throws ExecutionException, InterruptedException {
        Graph graph = getGraph();
        GraphNode end = new GraphNode("13");
        Assert.assertFalse(RouteBetweenNodes.findFast(graph.root, end));

        graph = getGraph();
        graph.root.nodes.get(0).nodes.get(0).nodes.add(end);
        Assert.assertTrue(RouteBetweenNodes.findFast(graph.root, end));
    }


    @Test
    public void binarySearchTree2() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Tree tree = SortedArrayToTree.apply(arr);
        Assert.assertEquals("6{3{2{1},5{4}},9{8{7},10}}", tree.toString());
        System.out.println(tree);
    }

    @Test
    public void binaryTreeToListOfLinkedListsTest2() {
        Tree tree = getTree();
        tree.root.right.right.addRight(24);
        tree.root.right.right.right.addRight(30);
        List result = ListOfDepths.find(tree);
        Assert.assertEquals(5, result.size());
    }

    @Test
    public void isTreeBalancedTest2() {
        Tree tree = getTree();
        Assert.assertTrue(ValidateBalancedTree.check(tree));

        tree.root.right.right.addRight(24);
        tree.root.right.right.right.addRight(30);
        Assert.assertFalse(ValidateBalancedTree.check(tree));
    }

    @Test
    public void ValidateBSTTest2() {
        Tree tree = getTree();
        Assert.assertTrue(ValidateBST.validate2(tree));

        tree.root.right.left.addRight(16);
        Assert.assertFalse(ValidateBST.validate2(tree));

        tree.root.right.left.right = null;
        tree.root.right.left.addLeft(12);
        Assert.assertTrue(ValidateBST.validate2(tree));

        tree.root.right.left.right = null;
        tree.root.right.right.addRight(19);
        Assert.assertFalse(ValidateBST.validate2(tree));
    }

    @Test
    public void FindSuccessor() {
        Tree tree = getTree();
        TreeNode newElem = new TreeNode(7);
        tree.root.left.right.addRight(newElem);
        Assert.assertEquals(8, Successor.find(newElem).data);

        newElem = new TreeNode(9);
        tree.root.right.left.addLeft(newElem);
        Assert.assertEquals(9, Successor.find(tree.root).data);

        Assert.assertEquals(14, Successor.find(newElem).data);
    }
}

