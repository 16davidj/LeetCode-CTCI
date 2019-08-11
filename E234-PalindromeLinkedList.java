/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/palindrome-linked-list/

Description:
Given a singly linked list, determine if it is a palindrome.

Solution:
go to the halfway point. It doesn't matter if the length of the list is odd or even (draw out both
scenarios). Then compare the head with the new reversed list based on the reversed list's length.

Runtime:

*/

public boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode rev = reverse(slow);
    while(rev != null) {
      if(rev.val != head.val) {
        return false;
      }
      rev = rev.next;
      head = head.next;
    }
    return true;
}

public ListNode reverse(ListNode head) {
  ListNode next = null;
  ListNode prev = null;
  while(head != null) {
    next = head.next;
    head.next = prev;
    prev = head;
    head = next;
  }
  return prev;
}
