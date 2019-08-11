/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Description:
Given a linked list, remove the n-th node from the end of list and return its head.

Solution:
Have two pointers start at a dummy head, so that you will be one node before the actual node you
want to delete. Have a fast pointer be k steps ahead of the slow one. When the last one reaches
the end, the first one will be k elements away from the end. Delete that element, then return
the dummy.next.

Runtime:
Average and worst case: O(n), should be linear in terms of how many elements there are

*/

public ListNode removeNthFromEnd(ListNode head, int n) {
  if(head == null) {
    return null;
  };
  ListNode dummy = new ListNode(0);
  dummy.next = head;
  ListNode slow = dummy;
  ListNode fast = dummy;
  while(n > 0) {
    fast = fast.next;
    n--;
  }
  while(fast.next != null) {
    fast = fast.next;
    slow = slow.next;
  }
  slow.next = slow.next.next;
  return dummy.next;
}
