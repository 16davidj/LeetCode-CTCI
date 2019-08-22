/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/unique-binary-search-trees/

Description:
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Solution:
Dynamic programming question. Essentially, create a dp array up to the nth index. This represents
how many numTrees you can have with n, for every n index. dp[0] = 1 because of null node and
dp[1] = 1 for obvious reasons. Then, we populate the rest of the array.

DP: OPT[n] = sum of F(i, n) from 1 to n, where F(i, n) = dp[i - 1] * dp(n - i). For example,
F(3, 7) is when the root node is at 3, but there are 7 nodes, so you do dp[2]*dp[4]. You want
to start the sum at 1 because it makes no sense to start at 0, where that is the null node, which
can't be the root node.

The first for loop is to populate dp. The inner for loop is to do calculate dp[i] given the
subproblems.

Runtime:
Space complexity: O(n): dp array with n values
Time Complexity: O(n^2), because of the loop to populate the array.
*/


public int numTrees(int n) {
  int[] dp = new int[n + 1];
  dp[0] = 1;
  dp[1] = 1;
  for(int i = 2; i <= n; i++) {
    for(int j = 1; j <= i; j++) {
      dp[i] += dp[j - 1] * dp[i - j];
    }
  }
  return dp[n];
}
