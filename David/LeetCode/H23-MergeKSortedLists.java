/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/merge-k-sorted-lists/description/

Description: Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

Solution:
(see E21 to see how to merge two sorted lists).

Runtime: O(N log k): Each merge operation takes O(N), and there are O(log k) merge operations

Space Complexity: O(1), no new space is needed, unless you're keeping track of the recursive stack,
then O(log k)

*/

public ListNode mergeKLists(ListNode[] lists) {
  if(lists.length == 0) {
    return null;
  }
  return merge(lists, 0, lists.length - 1);
}

public ListNode merge(ListNode[] lists, int start, int end) {
  if(start == end) {
    return lists[start];
  }
  ListNode left = merge(lists, start, (start + end)/2);
  ListNode right = merge(lists,  ((start + end)/2)+1, end);
  return merge2Lists(left, right);
}

public ListNode merge2Lists(ListNode l1, ListNode l2) {
  ListNode preHead = new ListNode(-1);
  ListNode result = preHead;
  if(l1 == null && l2 == null) {
    return null;
  } else if(l1 == null) {
    return l2;
  } else if(l2 == null) {
    return l1;
  }

  while(l1 != null && l2 != null) {
    preHead.next = (l1.val <= l2.val ? l1 : l2);
    if(preHead.next == l1) {
      l1 = l1.next;
    } else {
      l2 = l2.next;
    }
    preHead = preHead.next;
  }

  if(l1 == null && l2 != null) {
    preHead.next = l2;
  } else if(l1 != null & l2 == null) {
    preHead.next = l1;
  }
  return result.next;
}
