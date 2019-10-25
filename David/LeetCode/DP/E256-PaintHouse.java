/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/paint-house/

Description: There are a row of n houses, each house can be painted with one of the three colors:
red, blue or green. The cost of painting each house with a certain color is different. You have to
paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For
example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of
painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Solution: DP. dp[house #n][color] is built off the min of the previous house, but a different
color. You make the dp build down for all 3 colors, and you take the min of all 3 colors at the
last house, which represents the sequence which ends in a certain color house.


Runtime: O(n)

Space Complexity: O(m*n)

*/

public int minCost(int[][] costs) {
    if(costs.length == 0) {
      return 0;
    }
    int n = costs.length;
    for(int i = 1; i < n; i++) {
      costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
      costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
      costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
    }
    int lastIdx = costs.length - 1;
    return Math.min(costs[lastIdx][0], Math.min(costs[lastIdx][1], costs[lastIdx][2]));
}
