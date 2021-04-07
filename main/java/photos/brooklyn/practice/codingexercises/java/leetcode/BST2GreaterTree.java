package photos.brooklyn.practice.codingexercises.java.leetcode;

import photos.brooklyn.practice.codingexercises.java.utils.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class BST2GreaterTree {
    public static TreeNode convertBST(TreeNode root) {

        final Stack<TreeNode> inOrderStack = new Stack<>();
        pushInorder(root, inOrderStack);
        int prevValue = 0;
        while (!inOrderStack.isEmpty()) {
            TreeNode node = inOrderStack.pop();
            node.val += prevValue;
            prevValue = node.val;
        }
        return root;
    }

    private static void pushInorder(final TreeNode node, final Stack<TreeNode> stack) {
        if (node == null) {
            return;
        }
        pushInorder(node.left, stack);
        stack.push(node);
        pushInorder(node.right, stack);
    }
}
