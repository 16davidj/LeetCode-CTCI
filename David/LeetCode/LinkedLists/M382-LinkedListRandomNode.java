/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/linked-list-random-node/

Description:
Given a singly linked list, return a random node's value from the linked list. Each node must have t
the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this
efficiently without using extra space?

Solution:

Runtime:
Space complexity:
Time Complexity:
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class Solution {
     ListNode h;
     Random rand;
     /** @param head The linked list's head.
         Note that the head is guaranteed to be not null, so it contains at least one node. */
     public Solution(ListNode head) {
         h = head;
         rand = new Random();
     }

     /** Returns a random node's value. */
     public int getRandom() {
         ListNode head = h;
         ListNode selected = null;
         int count = 1;
         if(head != null) {
             selected = head;
         }
         while(head.next != null) {
             int r = rand.nextInt(count + 1);
             if(r == count) {
                 selected = head.next;
             }
             count++;
             head = head.next;
         }
         return selected.val;
     }
 }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
