package secondTime.tests;

import firstTime.helpers.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import secondTime.chapter4.*;

public class Chapter4_2 {

    @Test
    public void testBuildOrder() {
        String[] nodes = new String[]{"a","b","c","d","e","f"};
        String[][] dependencies = new String[][]{
                {"a","b"},
                {"b","c"},
                {"c","d"},
                {"c","f"}
        };
        String result = BuildOrder.find(nodes, dependencies);
        Assert.assertEquals("aebcdf", result);
    }

    @Test
    public void testFindAssesor() {
        TreeNode root = createTree();

        TreeNode first = root.right.right.right;
        TreeNode second = root.right.left.right;
        Assert.assertEquals(9, FindAncestor.find(first, second));

        first = root.left.left.right;
        Assert.assertEquals(8, FindAncestor.find(first, second));
    }

    @Test
    public void testFindAssesor2() {
        TreeNode root = createTree();

        TreeNode first = root.right.right.right;
        TreeNode second = root.right.left.right;
        Assert.assertEquals(9, FindAncestor2.find(root, first, second));

        first = root.left.left.right;
        Assert.assertEquals(8, FindAncestor2.find(root, first, second));
    }

    private TreeNode createTree() {
        TreeNode root = new TreeNode(8);
        root.addRight(9).addRight(10).addRight(12);
        root.right.addLeft(11).addRight(13);
        root.addLeft(7).addLeft(6).addLeft(4).parent.addRight(5);
        return root;
    }

    @Test
    public void BSTSequencesTest() {
        TreeNode root = new TreeNode(5);
        root.addRight(8).addRight(9).parent.addLeft(6);
        root.addLeft(2).addRight(3).parent.addLeft(1).addLeft(0);

        BSTSequences.find(root);
    }

    @Test
    public void CheckSubTreeTest() {
        TreeNode root = new TreeNode(5);
        root.addRight(8).addRight(9).parent.addLeft(6);
        root.addLeft(8).addRight(3).parent.addLeft(1).addLeft(0);


        TreeNode t2 = new TreeNode(8);
        t2.addRight(9).parent.addLeft(6);

        Assert.assertTrue(CheckSubTree.check(root, t2));

        root.right.right.addLeft(3);
        Assert.assertFalse(CheckSubTree.check(root, t2));
    }

    private static TreeNode createBigTree() {
        TreeNode root = new TreeNode(8);
        root.addLeft(4).addLeft(2).addLeft(1).parent.addRight(3);
        root.left.addRight(6).addLeft(5).parent.addRight(7);
        root.addRight(12).addLeft(10).addLeft(9).parent.addRight(11);
        root.right.addRight(15).addLeft(13).parent.addRight(16);
        return root;
    }

    @Test
    public void PathSumTest() {
        TreeNode tree = createBigTree();
        Assert.assertEquals(1, PathSum.find(tree, 10));
        Assert.assertEquals(2, PathSum.find(tree, 30));
        Assert.assertEquals(3, PathSum.find(tree, 17));
        Assert.assertEquals(0, PathSum.find(tree, 53));
    }
}
