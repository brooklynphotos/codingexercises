package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;
import photos.brooklyn.practice.codingexercises.java.leetcode.utils.ListNode;

import static org.junit.Assert.*;

public class MiddleOfLinkedListTest {
    private final MiddleOfLinkedList obj = new MiddleOfLinkedList();

    @Test
    public void middleNode() {
        final int[] arr = {1,2,3,4,5};
        final ListNode list = makeList(arr);
        assertEquals(3, obj.middleNode(list).val);
    }

    private static ListNode makeList(final int[] arr) {
        final ListNode list = new ListNode(arr[0]);
        ListNode prev = list;
        for(int i=1;i< arr.length;i++){
            final int a = arr[i];
            final ListNode next = new ListNode(a);
            prev.next = next;
            prev = next;
        }
        return list;
    }
}