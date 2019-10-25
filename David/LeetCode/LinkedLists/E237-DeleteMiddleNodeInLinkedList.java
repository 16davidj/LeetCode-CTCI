/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/delete-node-in-a-linked-list/

Description:
Write a function to delete a node (except the tail) in a singly linked list, given only access to
that node.

Solution:
Replace the current node with the next node, and then skip over the original next

Runtime: O(1)
*/
public void deleteNode(ListNode node) {
  if(node == null) {
    return;
  }
  node.val = node.next.val;
  node.next = node.next.next;
}
