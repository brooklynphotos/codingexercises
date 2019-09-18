# https://leetcode.com/problems/reverse-linked-list/

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        curr = head
        prev = None
        while curr:
            tail = curr.next
            curr.next = prev
            prev = curr
            curr = tail
        return prev # last thing updated


def make_list(first, *numbers):
    f = ListNode(first)
    c = f
    for n in numbers:
        c.next = ListNode(n)
        c = c.next
    return f

if __name__ == '__main__':
    llist = make_list(1,2,3)
    rlist = Solution().reverseList(llist)
    print(rlist)