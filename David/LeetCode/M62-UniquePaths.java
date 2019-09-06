/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/unique-paths/

Description: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the
diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the
bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Solution: DP. DP[i][j] represents the amount of unique paths to i, j. Base case is every cell on
the leftside wall and rightside wall is filled with 1, because there's only one way to get there.
dp[i][j] = dp[i-1][j] + dp[i][j-1] because that's the only way you can get to those cells.

Runtime: O(mn): To fill in the dp array

Space Complexity: O(1)

*/

public int uniquePaths(int m, int n) {
  int dp[][] = new int[m][n];
  for(int i = 0; i < m; i++) {
    dp[i][0] = 1;
  }
  for(int i = 0; i < n; i++) {
    dp[0][i] = 1;
  }
  for(int i = 1; i < m; i++) {
    for(int j = 1; j < n; j++) {
      dp[i][j] = dp[i-1][j] + dp[i][j-1];
    }
  }
  return dp[m-1][n-1];
}
