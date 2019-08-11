/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Description:
Given a sorted linked list, delete all duplicates such that each element appear only once.

Solution:
Keep a fast and slow pointer, with the fast moving forward to look at duplicates and telling
the slow pointer to move when all the duplicates have been exhausted

Runtime: O(N)
Average and worst case: O(N): you would only need to iterate on each value once

*/
public ListNode deleteDuplicates(ListNode head) {
  if(head == null) {
    return null;
  }
  if(head.next == null) {
    return head;
  }
  ListNode slow = head;
  ListNode fast = head.next;
  while(fast != null) {
    if(fast.val == slow.val) {
      fast = fast.next;
      slow.next = fast;
    } else {
      slow = fast;
      fast = fast.next;
    }
  }
  return head;
}
