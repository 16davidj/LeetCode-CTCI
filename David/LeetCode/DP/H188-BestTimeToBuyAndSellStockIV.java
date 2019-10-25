/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

Description:
Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before
you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

Solution: This is the same solution as H123, but generalized to k. Also, if k >= prices.length/2,
it means that you can make any number of sells, so just use the greedy algorithm to take advantage
of increasing stock prices.

Runtime: O(kn) to populate the dp array

Space Complexity: O(kn)

*/

public int maxProfit(int k, int[] prices) {
  if(k >= prices.length/2) {
    int profit = 0;
    for(int i = 1; i < prices.length; i++) {
      if(prices[i] > prices[i-1]) {
        profit += prices[i] - prices[i-1];
      }
    }
    return profit;
  }
  int[][] dp = new int[k + 1][prices.length];
  if(prices.length == 0) {
    return 0;
  }
  for(int i = 0; i < prices.length; i++) {
    dp[0][i] = 0;
  }
  for(int i = 0; i < k + 1; i++) {
    dp[i][0] = 0;
  }
  for(int i = 1; i < k + 1; i++) {
    for(int j = 1; j < prices.length; j++) {
      int max = 0;
      for(int f = j - 1; f > 0; f--) {
        max = Math.max(max, dp[i - 1][f - 1] + prices[j] - prices[f]);
      }
      max = Math.max(max, prices[j] - prices[0]);
      dp[i][j] = Math.max(dp[i][j-1], Math.max(max, dp[i-1][j]));
    }
  }
  return dp[k][prices.length - 1];
}
