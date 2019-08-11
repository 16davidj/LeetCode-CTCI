/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/partition-list/

Description:
Given a linked list and a value x, partition it such that all nodes less than x come before nodes
greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Solution:
Create two different lists, one for the left side of the partition, one on the right side.
Iterate through each element of the list, and add to either list, then merge at the end.
(see M86-PartitionList)

Runtime: O(n), it's linear to the amount of elements there are in a list.

*/

public ListNode partition(ListNode head, int x) {
  ListNode less = null;
  ListNode ge = null;
  ListNode modHead = less;
  ListNode geHead = ge;
  while(head != null) {
    if(head.val < x) {
      if(less == null) {
        less = new ListNode(head.val);
        modHead = less;
      } else {
        less.next = new ListNode(head.val);
        less = less.next;
      }
    } else {
      if(ge == null) {
        ge = new ListNode(head.val);
        geHead = ge;
      } else {
        ge.next = new ListNode(head.val);
        ge = ge.next;
      }
    }
    head = head.next;
  }
  if(less == null) {
    return geHead;
  } else {
    less.next = geHead;
  }
  return modHead;
}
