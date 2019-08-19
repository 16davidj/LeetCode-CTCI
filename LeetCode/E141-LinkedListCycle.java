/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/linked-list-cycle/

Description:
Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position
(0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the
linked list.

Solution:
How to detect there is a linked list: fast and slow pointer. You shouldn't be concernerd that
the fast pointer will jump over the slow pointer, since that would mean a jump is: the fast is at
i+1th node, while the slow is at slow. Well, that means that the step before, the fast was at
(i+1)-2 = i-1, meanwhile, the slow is at i-1.

Runtime: O(n), it's linear to the amount of elements there are in a list.
*/

public boolean hasCycle(ListNode head) {
  ListNode slow = head;
  ListNode fast = head;
  while(fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if(fast == slow) {
      return true;
    }
  }
  return false;
}
