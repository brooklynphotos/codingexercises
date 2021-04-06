package photos.brooklyn.practice.codingexercises.java.other;

import photos.brooklyn.practice.codingexercises.java.utils.TreeNode;

/**
 * Convert a BST to a DLL in place, where the head is the left most node an InOrder traversal
 * see:
 */
public class Bst2Dll {

    public static TreeNode binTree2List(TreeNode node) {
        return buildList(node).head;
    }

    /**
     * the node's left becomes previous and right becomes next for the Double Linked List
     *
     * @param node
     * @return
     */
    private static DoubleLinkList buildList(final TreeNode node) {
        if (node == null) {
            return null;
        }
        DoubleLinkList leftLL = buildList(node.left);
        DoubleLinkList rightLL = buildList(node.right);
        TreeNode head;
        if (leftLL == null) {
            head = node;
        } else {
            head = leftLL.head;
            leftLL.tail.right = node;
            node.left = leftLL.tail;
        }
        TreeNode tail;
        if (rightLL == null) {
            tail = node;
        } else {
            tail = rightLL.tail;
            node.right = rightLL.head;
            rightLL.head.left = node;
        }
        return new DoubleLinkList(head, tail);
    }

    private static class DoubleLinkList {
        private final TreeNode head;

        public DoubleLinkList(final TreeNode head, final TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }

        private final TreeNode tail;
    }
}
