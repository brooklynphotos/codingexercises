package photos.brooklyn.practice.codingexercises.java.leetcode;

import photos.brooklyn.practice.codingexercises.java.leetcode.utils.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-95/problems/middle-of-the-linked-list/
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        final List<Integer> list = new LinkedList<>();
        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return get(head, count/2);
    }

    private static ListNode get(final ListNode head, final int pos) {
        ListNode current = head;
        for(int i=0;i<pos;i++){
            current = current.next;
        }
        return current;
    }
}
