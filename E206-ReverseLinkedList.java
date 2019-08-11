/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/reverse-linked-list/

Description:
Reverse a linked list.

Solution:
you need to keep next because when you reverse the pointer for the current one, you want to keep
access to the next one. You need to keep prev because thats the head of reversed linked list.

Runtime: O(n)

*/
public ListNode reverseList(ListNode head) {
  ListNode next = null;
  ListNode prev = null;
  while(head != null) {
    next = head.next; //keep the next, as you'll lose it
    head.next = prev; //reverse the link
    prev = head; //go to the head of the reversed linked list
    head = next; //head, the current head of the original list, needs to be iterated
  }
  return prev;
}
