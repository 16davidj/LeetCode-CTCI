/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

Description:
Given a singly linked list where elements are sorted in ascending order, convert it to a height
balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
he two subtrees of every node never differ by more than 1.

Solution:
The solution is analogous to the array version (E108), but is a little trickier because of the
linked list. You want to use a slow (reg) and fast pointer, so that when the fast pointer gets to
the  end, the slow pointer will be in the middle. Then, you create a TreeNode of the slow pointer,
with  the right being the recursive call of slow (middle)'s next. The left half, since is a singly
linked list, is gotten by having a pointer that is one slower than the slow pointer, so that you
can set it's next to null when it gets one before the middle, and then call the recursive function
on the left half using head.

Runtime:
Space complexity: O(log n) for recursive levels
Time Complexity: O(log n) times you split the list up, and each time, it takes N/2 to find the
middle, so O(n log n).
*/

public TreeNode sortedListToBST(ListNode head) {
  if(head == null) {
    return null;
  }
  if(head.next == null) {
    return new TreeNode(head.val);
  }
  ListNode reg = head;
  ListNode fast = head;
  ListNode before = new ListNode(-1);
  before.next = head;

  while(fast != null && fast.next != null) {
    reg = reg.next;
    before = before.next;
    fast = fast.next.next;
  }

  TreeNode root = new TreeNode(reg.val);
  root.right = sortedListToBST(reg.next);
  before.next = null;
  root.left = sortedListToBST(head);
  return root;
}
