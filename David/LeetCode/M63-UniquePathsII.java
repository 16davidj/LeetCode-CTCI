/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/unique-paths-ii/

Description: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

Solution: DP, similar solution to M62, but you have to keep in mind you can't add paths from
grid parts where there are obstacles. So, things that change are that you can't add to the top
row or the left side column "1" if they are not accessible if there is an obstacle in the way,
since you can't go left or up (That's why there's a break statement, you leave those cells as 0).

Then, you only add the dp[i][j] from two cells aside if the obstacleGrid is not equal to 1. If it
is equal to 1, then you set it as 0, as all paths that go there die, and there can't be any paths
that come from there.

Runtime: O(m*n)

Space Complexity: O(m*n)

*/

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
  int m = obstacleGrid.length;
  if(m == 0) {
    return 0;
  }
  int n = obstacleGrid[0].length;
  int dp[][] = new int[m][n];
  for(int i = 0; i < m; i++) {
    if(obstacleGrid[i][0] != 1) {
      dp[i][0] = 1;
    } else {
      break;
    }
  }
  for(int i = 1; i < n; i++) {
    if(obstacleGrid[0][i] != 1) {
      dp[0][i] = 1;
    }
    else {
      break;
    }
  }
  for(int i = 1; i < m; i++) {
    for(int j = 1; j < n; j++) {
      if(obstacleGrid[i][j] == 1) {
        dp[i][j] = 0;
      } else {
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
      }
    }
  }
  if(obstacleGrid[0][0] != 1 && obstacleGrid[m-1][n-1] != 1) {
      return dp[m-1][n-1];
  }
  return 0;
}
