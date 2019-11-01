/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/split-array-largest-sum/

Description: Given an array which consists of non-negative integers and an integer m, you can split
the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum
among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

Solution:
f(i, j) = the maximum split-sum for i splits up to the jth index (including the jth index)

You want to return f(m, nums.length);

Base case:
f(0, j) = 0 splits, 0
f(0, 0) = 0
f(anything with more splits with index) = -1, it doesn't really matter, it's impossible

f(i, j) = min(for all k, max(f(i-1, k), nums[k - 1]... nums[j-1]), which is one less split, since
you're extra split here comes from summing from k to the end (j),.

Runtime: O(m * n^2)

Space Complexity: O(mn)

*/

class Solution {
    public int splitArray(int[] nums, int m) {
        int dp[][] = new int[m + 1][nums.length];
        for(int i = 0; i < nums.length; i++) {
          dp[0][i] = 0;
        }
        int sm = 0;
        for(int i = 0; i < nums.length; i++) {
            sm += nums[i];
            dp[1][i] = sm;
        }
        for(int i = 2; i < m + 1; i++) {
          for(int j = 1; j < nums.length; j++) {
            if(i > j + 1) {
              dp[i][j] = -1;
            } else {
              int sum = 0;
              int minSum = Integer.MAX_VALUE;
              for(int k = j; k > 0; k--) {
                sum += nums[k];
                minSum = Math.min(minSum, Math.max(sum, dp[i-1][k-1]));
              }
              dp[i][j] = minSum;
            }
          }
        }
        return dp[m][nums.length - 1];
    }
}
