/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/

Description:
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If
there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:

Input: nums = [1, -1, 5, -2, 3], k = 3
Output: 4
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example 2:

Input: nums = [-2, -1, 2, 1], k = 1
Output: 2
Explanation: The subarray [-1, 2] sums to 1 and is the longest.
Follow Up:
Can you do it in O(n) time?

Solution:
solution is that you can find the sum between i, j in O(n) time by creating a sum array that
is like dp, which represents the sum from 0, i for sum[i]. Then, you can find the sum from i to j
with sum[j] - sum[i-1]. Then, you put these sums into a hashMap as the keys, and the indices are
the values, and then you try to find the max from there (it's like a 2-sum problem from there).

Runtime: O(n)

Space Complexity: O(n)

*/

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0;
        if(nums.length == 0) {
          return 0;
        }
        int [] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
          sum[i] = sum[i-1] + nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < sum.length; i++) {
          if(sum[i] == k) {
            maxLen = Math.max(maxLen, i + 1);
          }
          int target = sum[i] - k; //you want the difference in the sums to be k
          if(map.containsKey(target)) {
            maxLen = Math.max(maxLen, i - map.get(target));
          } else if(!map.containsKey(sum[i])){ //don't put the key unless it's already in there
            map.put(sum[i], i);
          }
        }
        return maxLen;
    }
}
