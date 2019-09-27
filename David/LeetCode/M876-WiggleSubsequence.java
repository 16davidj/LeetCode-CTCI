/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/wiggle-subsequence/

Description:

A sequence of numbers is called a wiggle sequence if the differences between successive numbers
strictly alternate between positive and negative. The first difference (if one exists) may be
either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are
alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle
sequences, the first because its first two differences are positive and the second because its last
difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle
sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero)
from the original sequence, leaving the remaining elements in their original order.

Example 1:

Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
Example 2:

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
Example 3:

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?

Solution:
This is a DP solution, with two dp-arrays. This is because a dp solution is technically how
much the longest subsequence is up to a certain index. However, you also need to know another
dimension. Was the last index going up or down? Therefore, you need two arrays to keep track
of if an array is going up or down. you can't have one-dp array and set a boolean variable to
true or false (if its going up or down) because then it's N^2, because when you add a value, you
have to see which subsequence of the original array you're adding to, and if its bigger than
i-1. Keeping two dp arrays would allow you to keep track of the possible solutions.

Runtime: O(n)
Space Complexity: O(n)

*/

public int wiggleMaxLength(int[] nums) {
  int[] up = new int[nums.length];
  int[] down = new int[nums.length];
  if(nums.length == 0) {
    return 0;
  }
  up[0] = 1;
  down[0] = 1;
  for(int i = 1; i < nums.length; i++) {
    if(nums[i] > nums[i-1]) {
      up[i] = down[i] + 1;
      down[i] = down[i-1];
    } else if(nums[i] < nums[i-1]) {
      down[i] = up[i-1] + 1;
      up[i] = up[i-1];
    } else {
      down[i] = down[i-1];
      up[i] = up[i-1];
    }
  }
  return Math.max(up[nums.length - 1], down[nums.length - 1]);
}
