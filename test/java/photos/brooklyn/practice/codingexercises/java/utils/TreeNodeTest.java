package photos.brooklyn.practice.codingexercises.java.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNodeTest {

    @Test
    public void create() {
        TreeNode n = TreeNode.create("4,1,6,0,2,5,7,null,null,null,3,null,null,null,8");
        assertEquals(4, n.val);
        assertEquals(1, n.left.val);
        assertEquals(6, n.right.val);
        assertEquals(0, n.left.left.val);
        assertEquals(2, n.left.right.val);
        assertEquals(5, n.right.left.val);
        assertEquals(7, n.right.right.val);
        assertNull(n.left.left.left);
        assertNull(n.left.left.right);
        assertNull(n.left.right.left);
        assertEquals(3, n.left.right.right.val);
        assertNull(n.right.left.left);
        assertNull(n.right.left.right);
        assertNull(n.right.right.left);
        assertEquals(8, n.right.right.right.val);
    }

    @Test
    public void linearlize() {
        TreeNode left = new TreeNode(1);
        TreeNode rightRight = new TreeNode(7);
        TreeNode right = new TreeNode(6, null, rightRight);
        TreeNode root = new TreeNode(4, left, right);
        assertEquals("4,1,6,null,null,null,7", TreeNode.linearlize(root));
    }

    @Test
    public void equalsComp() {
        TreeNode left = new TreeNode(1);
        TreeNode rightRight = new TreeNode(7);
        TreeNode right = new TreeNode(6, null, rightRight);
        TreeNode root = new TreeNode(4, left, right);
        assertEquals(TreeNode.create("4,1,6,null,null,null,7"), root);
    }
}