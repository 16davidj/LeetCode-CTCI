/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

Description:
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
numbers from the original list.

Solution:
dummy head to keep track of start
pre is the pre before every unique value, pre can move around, as long as it take dummys next
with it. pre moves in two scenarios: 1) if pre.next == curr, that means there were no dups,
meaning that pre should iterate one node, and curr should iterate one node. if its not, then
there was a duplicate, meaning that we skip all the node sin between, and pre.next == curr.next
curr is self explanatory, should start at each unique value every iteration

Runtime:
Average and worst case: O(n), should be linear in terms of how many elements there are

*/
public ListNode deleteDuplicates(ListNode head) {
  if(head == null) {
    return null;
  }
  if(head.next == null) {
    return head;
  }
  ListNode pre = new ListNode(0);
  pre.next = head;
  ListNode curr = pre.next;
  ListNode start = pre;

  while(curr != null) {
    while(curr.next != null && curr.val == curr.next.val) {
      curr = curr.next;
    }
    if(pre.next == curr) {
      pre = pre.next;
    } else {
      pre.next = curr.next;
    }
    curr = curr.next;
  }
  return start.next;
}
