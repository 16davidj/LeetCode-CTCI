/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/add-two-numbers-ii/

Description:
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Solution:
get the length of each list, pad the shorter one with zeros, use a stack

Runtime:
O(N): you go through each node of each list only once
O(N): space, you have to create two stacks of N size
*/

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  Stack<Integer> s1 = new Stack<Integer>();
  Stack<Integer> s2 = new Stack<Integer>();
  ListNode result = new ListNode(-1);

  while(l1 != null) {
    s1.push(l1.val);
    l1 = l1.next;
  }

  while(l2 != null) {
    s2.push(l2.val);
    l2 = l2.next;
  }

  int carry = 0;
  while(!s1.isEmpty() && !s2.isEmpty()) {
    int sum = s1.pop() + s2.pop() + carry;
    carry = sum / 10;
    result.val = sum % 10;
    ListNode temp = new ListNode(-1);
    temp.next = result;
    result = temp;
  }
  if(s1.isEmpty()) {
    while(!s2.isEmpty()) {
      int sum = carry + s2.pop();
      carry = sum/10;
      result.val = sum % 10;
      ListNode temp = new ListNode(-1);
      temp.next = result;
      result = temp;
    }
  } else if(s2.isEmpty()) {
    while(!s1.isEmpty()) {
      int sum = carry + s1.pop();
      carry = sum/10;
      result.val = sum % 10;
      ListNode temp = new ListNode(-1);
      temp.next = result;
      result = temp;
    }
  }
  if (carry > 0){
    result.val = carry;
    ListNode temp = new ListNode(-1);
    temp.next = result;
    result = temp;
  }
  return result.next;
}
