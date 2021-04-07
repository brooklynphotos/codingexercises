package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;
import photos.brooklyn.practice.codingexercises.java.utils.TreeNode;

import static org.junit.Assert.assertEquals;

public class BST2GreaterTreeTest {

    @Test
    public void convertBSTExample1() {
        final TreeNode root = TreeNode.create("4,1,6,0,2,5,7,null,null,null,3,null,null,null,8");
        assertEquals("30,36,21,36,35,26,15,null,null,null,33,null,null,null,8", BST2GreaterTree.convertBST(root).toString());
    }

    @Test
    public void convertBSTExample2() {
        final TreeNode root = TreeNode.create("0,null,1");
        assertEquals("1,null,1", BST2GreaterTree.convertBST(root).toString());
    }

    @Test
    public void convertBSTExample3() {
        final TreeNode root = TreeNode.create("1,0,2");
        assertEquals("3,3,2", BST2GreaterTree.convertBST(root).toString());
    }

    @Test
    public void convertBSTExample4() {
        final TreeNode root = TreeNode.create("3,2,4,1");
        assertEquals("7,9,4,10", BST2GreaterTree.convertBST(root).toString());
    }
}