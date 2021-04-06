package photos.brooklyn.practice.codingexercises.java.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(final int val, final TreeNode left, final TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return linearlize(this);
    }

    @Override
    public boolean equals(Object tn) {
        return linearlize(this).equals(linearlize((TreeNode) tn));
    }

    public static TreeNode create(final String valsString) {
        String[] vals = StringUtils.split(valsString, ',');
        return createNode(0, vals);
    }

    private static TreeNode createNode(final int i, final String[] vals) {
        if (i >= vals.length || vals[i].equals("null")) return null;
        return new TreeNode(Integer.parseInt(vals[i]), createNode(2 * i + 1, vals), createNode(2 * i + 2, vals));
    }

    public static String linearlize(TreeNode treeNode) {
        final List<String> strings = new LinkedList<>();
        final LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode top = queue.pop();
            if (top == null) {
                strings.add("null");
            }else {
                strings.add(Integer.toString(top.val));
                queue.add(top.left);
                queue.add(top.right);
            }
        }
        return StringUtils.join(strings, ',').replaceAll("(,null)+$", "");
    }

}
