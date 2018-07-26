package photos.brooklyn.practice.codingexercises.java.hackerrank;

/**
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
 */
public class IsBinaryTree {
    boolean checkBST(Node root) {
        return checkBstSubtree(root.left, -1, root.data) && checkBstSubtree(root.right, root.data, 10_001);
    }
    boolean checkBstSubtree(final Node node, int lowerBound, int upperBound){
        if(node==null) return true;
        if(node.data <= lowerBound || node.data>=upperBound) return false;
        return checkBstSubtree(node.left, lowerBound, node.data) && checkBstSubtree(node.right, node.data, upperBound);
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node(final int data){
        this.data = data;
    }
    Node(final int data, final Node left, final Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
