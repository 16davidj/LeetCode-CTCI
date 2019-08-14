/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/intersection-of-two-linked-lists/

Description:
Write a program to find the node at which the intersection of two singly linked lists begins.

Solution:
you can tell if they intersect if the last node is equal by reference. You can check which node
intersects by making both lists the same length, and then pad the front until the first reference
is equal (pad the shorter list).

Runtime: O(n), it's linear to the amount of elements there are in a list.

*/

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
  int lengthA = 0;
  int lengthB = 0;
  ListNode currA = headA;
  ListNode currB = headB;
  while(currA != null && currA.next != null) {
    currA = currA.next;
    lengthA++;
  }
  while(currB != null && currB.next != null) {
    currB = currB.next;
    lengthB++;
  }
  if(currA != currB) {
    return null;
  }

  int diff = 0;
  if(lengthA < lengthB) {
    diff = lengthB - lengthA;
    while(diff > 0) {
      headB = headB.next;
      diff--;
    }
  } else if (lengthB < lengthA) {
    diff = lengthA - lengthB;
    while(diff > 0) {
      headA = headA.next;
      diff--;
    }
  }
  while(headA != headB) {
    headA = headA.next;
    headB = headB.next;
  }
  return headA;
}
