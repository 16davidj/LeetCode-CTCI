/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/longest-increasing-subsequence/

Description:

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n^2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?

Solution:
This is a dp solution, but still requires a O(n^2), since you need to check every dp[i-1] for
dp[i], since subsequences don't need to be continuous.

Runtime: O(n^2)

Space Complexity: O(n)

*/

public int lengthOfLIS(int[] nums) {
  if(nums.length == 0) {
    return 0;
  }
  int [] dp = new int[nums.length];
  int res = 1;
  dp[0] = 1;
  for(int i = 1; i < nums.length; i++) {
    int max = 1; //subsequence will always be at least 1
    for(int j = i - 1; j >= 0; j--) {
      if(dp[j] >= max && nums[i] > nums[j]) { //check if you can add to a subsequence
        //that is equal to max, and that you can add to it
        max = Math.max(max, 1 + dp[j]);
      }
    }
    dp[i] = max;
    res = Math.max(res, max); //keep track of max as you go
  }
  return res;
}
