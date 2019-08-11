/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/palindrome-linked-list/

Description:
Given a singly linked list, determine if it is a palindrome.

Solution:
get the length of each list, pad the shorter one with zeros, use a stack

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
