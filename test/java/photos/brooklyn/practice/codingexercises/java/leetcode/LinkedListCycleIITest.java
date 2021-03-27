package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListCycleIITest {

    @Test
    public void detectCycleExampleEmpty() {
        assertNull(new LinkedListCycleII().detectCycle(null));
    }

    @Test
    public void detectCycleExampleSingle() {
        assertNull(new LinkedListCycleII().detectCycle(makeStraightList(1)));
    }

    @Test
    public void detectCycleExampleNonCyclic() {
        assertNull(new LinkedListCycleII().detectCycle(makeStraightList(1, 2, 3)));
    }

    @Test
    public void detectCycleOdd() {
        ListNode start = new ListNode(4);
        assertEquals(start, new LinkedListCycleII().detectCycle(makeCyclic(start,
                new ListNode(2),
                new ListNode(5),
                new ListNode(-9),
                start,
                new ListNode(20),
                new ListNode(12)
                ))
        );
    }

    @Test
    public void detectCycleEven() {
        ListNode start = new ListNode(4);
        assertEquals(start, new LinkedListCycleII().detectCycle(makeCyclic(start,
                new ListNode(2),
                new ListNode(5),
                start,
                new ListNode(-9),
                new ListNode(20),
                new ListNode(12)
                ))
        );
    }

    @Test
    public void detectCycleAllLoop() {
        ListNode start = new ListNode(4);
        assertEquals(start, new LinkedListCycleII().detectCycle(makeCyclic(start,
                start,
                new ListNode(2),
                new ListNode(5),
                new ListNode(-9),
                new ListNode(20),
                new ListNode(12)
                ))
        );
    }

    private ListNode makeCyclic(final ListNode start, final ListNode... nodes) {
        ListNode list = null;
        ListNode prev = null;
        for(ListNode n : nodes) {
            if (list == null) {
                list = n;
            } else {
                prev.next = n;
            }
            prev = n;
        }
        if (prev == null) {
            return null;
        }
        prev.next = start;
        return list;
    }

    private static final ListNode makeStraightList(int first, int... elements) {
        final ListNode list = new ListNode(first);
        ListNode current = list;
        for (int i : elements) {
            current.next = new ListNode(i);
            current = current.next;
        }
        return list;
    }
}