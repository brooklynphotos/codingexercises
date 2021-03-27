package photos.brooklyn.practice.codingexercises.java.leetcode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * Using Floyd algorithm
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode rabbit = head;
        while (rabbit != null) {
            tortoise = tortoise.next;
            rabbit = rabbit.next;
            if (rabbit == null) {
                return null;
            }
            rabbit = rabbit.next;
            if (tortoise == rabbit) break;
        }
        if(rabbit==null) return null;
        // phase 2
        tortoise = head;
        while (tortoise != rabbit) {
            tortoise = tortoise.next;
            rabbit = rabbit.next;
        }
        return tortoise;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
