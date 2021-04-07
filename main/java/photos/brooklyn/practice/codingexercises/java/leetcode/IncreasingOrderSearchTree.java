package photos.brooklyn.practice.codingexercises.java.leetcode;

import photos.brooklyn.practice.codingexercises.java.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-100/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        final List<Integer> list = toList(root);
        return toRightTree(list.toArray(new Integer[0]), 0);
    }

    private static TreeNode toRightTree(final Integer[] list, int index) {
        if(index==list.length) return null;
        final TreeNode n = new TreeNode(list[index]);
        n.right = toRightTree(list, index + 1);
        return n;
    }

    private static List<Integer> toList(final TreeNode root) {
        final List<Integer> l = root.left==null ? new LinkedList<>() : toList(root.left);
        l.add(root.val);
        if(root.right != null)
            l.addAll(toList(root.right));
        return l;
    }
}
