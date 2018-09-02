package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncreasingOrderSearchTreeTest {

    @Test
    public void increasingBST_example1() {
        TreeNode n = new TreeNode(5);
        n.left = new TreeNode(3);
        n.left.left = new TreeNode(2);
        n.left.right = new TreeNode(4);
        n.left.left.left = new TreeNode(1);
        n.right = new TreeNode(6);
        n.right.right = new TreeNode(8);
        n.right.right.left = new TreeNode(7);
        n.right.right.right = new TreeNode(9);
        TreeNode changed = new IncreasingOrderSearchTree().increasingBST(n);
        assertEquals(changed.val, 1);
        assertEquals(changed.left, null);
        assertEquals(changed.right.val, 2);
        assertEquals(changed.right.right.val, 3);
        assertEquals(changed.right.right.right.val, 4);
    }
}