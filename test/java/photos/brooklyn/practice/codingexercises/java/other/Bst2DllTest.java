package photos.brooklyn.practice.codingexercises.java.other;

import org.junit.Test;
import photos.brooklyn.practice.codingexercises.java.utils.TreeNode;

import static org.junit.Assert.*;

public class Bst2DllTest {

    @Test
    public void binTree2List() {
        TreeNode node = TreeNode.create("10,12,15,25,30,36,null");
        TreeNode dll = Bst2Dll.binTree2List(node);
        assertEquals("25,12,30,10,36,15,", dllToString(dll));
    }

    private static String dllToString(TreeNode node) {
        final StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            sb.append(",");
            node = node.right;
        }
        return sb.toString();
    }
}