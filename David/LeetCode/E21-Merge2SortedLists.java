/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/merge-two-sorted-lists/

Description:
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing
together the nodes of the first two lists.

Solution:
You don't need to create a new list and then add to it, that's O(N) space complexity. Insetad,
you can take advantage of the fact that its a linked list, and go through each node one by one by
creating a prev node that is the prehead, and point to the current node that is the head of the
list. The prev node will point to the current part of the list you are on. Depending if l1 or l2
's current node is smaller, you will advance that one, and point the prev node to that node, and
then also advance the prev node.

Imagine it almost like connecting the dots, with the node being the dots.


Runtime: O(N)

Space Complexity: O(1)

*/

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode prev = new ListNode(-1);
    ListNode prehead = prev;
    prev.next = l1;
    ListNode currl1 = l1;
    ListNode currl2 = l2;
    while(currl1 != null && currl2 != null) {
      if(currl1.val < currl2.val) {
        prev.next = currl1;
        currl1 = currl1.next;
      } else {
        prev.next = currl2;
        currl2 = currl2.next;
      }
      prev = prev.next;
    }

    if(currl1 == null) {
      prev.next = currl2;
    } else {
      prev.next = currl1;
    }
    return prehead.next;
}
