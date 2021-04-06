package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-94/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return areSame(getLeaves(root1), getLeaves(root2));
    }

    private static boolean areSame(final List<Integer> leaves1, final List<Integer> leaves2) {
        if(leaves1.size() != leaves2.size()) return false;
        for(int i=0;i<leaves1.size();i++){
            if(!leaves1.get(i).equals(leaves2.get(i))) return false;
        }
        return true;
    }

    private static List<Integer> getLeaves(final TreeNode root) {
        final List<Integer> leaves = new LinkedList<>();
        getLeaves(root, leaves);
        return leaves;
    }

    private static void getLeaves(final TreeNode root, final List<Integer> leaves) {
        if(root.left==null && root.right==null) {
            leaves.add(root.val);
            return;
        }
        if(root.left != null) getLeaves(root.left, leaves);
        if(root.right != null) getLeaves(root.right,leaves);
    }
}
