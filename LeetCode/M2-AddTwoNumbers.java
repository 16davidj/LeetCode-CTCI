/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/add-two-numbers/

Description:
You are given two non-empty linked lists representing two non-negative integers. The digits are
stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Solution:
Basic question: create another linked list, and also use a carry-over variable.

Runtime:
O(N): you go through each node of each list only once
*/
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  int carry = 0;
  ListNode result = new ListNode(-1);
  ListNode head = result;
  while(l1 != null && l2 != null) {
    int sum = l1.val + l2.val + carry;
    carry = sum / 10;
    result.next = new ListNode(sum % 10);
    result = result.next;
    l1 = l1.next;
    l2 = l2.next;
  }
  if(l1 == null) {
    while(l2 != null) {
      result.next = new ListNode((carry + l2.val) % 10);
      carry = (carry + l2.val)/10;
      result = result.next;
      l2 = l2.next;
    }
  } else if(l2 == null) {
    while(l1 != null) {
      result.next = new ListNode((carry + l1.val) % 10);
      carry = (carry + l1.val)/10;
      result = result.next;
      l1 = l1.next;
    }
  }
  if (carry > 0){
    result.next = new ListNode(carry);
  }
  return head.next;
}
