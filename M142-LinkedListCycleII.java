/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/linked-list-cycle-ii/

Description:
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position
(0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the
linked list.

Note: Do not modify the linked list.

Solution:
How to detect there is a linked list: fast and slow pointer. You shouldn't be concernerd that
the fast pointer will jump over the slow pointer, since that would mean a jump is: the fast is at
i+1th node, while the slow is at slow. Well, that means that the step before, the fast was at
(i+1)-2 = i-1, meanwhile, the slow is at i-1.

Part 2: The place where the two pointers intersect should be off by the length of the loop. This
is because it's impossible for the fast pointer to lap over the slow pointer without meeting it
with steps < length of loop (see math above). Therefore, because the two pointers meet, but the
fast is faster than the slow, the difference in travelled steps is how long the loop is (think
about it like a 400 yd dash). Now that we know what the loop length is, we just set the head pointer
back to the head, and the fast pointer (length of loop) steps ahead, and keep iterating until they
meet again, since once the fast pointer travels far enough, where the slow pointer meets it is
the beginning of the loop, since the fast pointer is (length of loop) ahead.

Runtime: O(n), it's linear to the amount of elements there are in a list.
*/

public ListNode detectCycle(ListNode head) {
  ListNode slow = head;
  ListNode fast = head;
  boolean cycle = false;
  int steps = 0;
  while(!cycle && fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    steps++;
    if(slow == fast) {
      cycle = true;
    }
  }
  if(!cycle) {
    return null;
  } else {
    ListNode detect = head;
    while(steps > 0) {
      detect = detect.next;
      steps--;
    }
    while(detect != head) {
      head = head.next;
      detect = detect.next;
    }
    return head;
  }
}
