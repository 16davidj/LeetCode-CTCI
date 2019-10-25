/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

Description:

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock
before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

Solution:
Make a dp-array, in this case, [3][prices.length]. The 3 represents that you're allowed a max of
2 transactions. dp[i][j] represents the max profit assuming you have i transactions at the jth
price. Thus, if you can buy and sell a stock at that last price, you would have to find the max
of dp[i-1][k-1] + nums[j] - nums[k] (assuming you bought the stock at k and sold it at j).
You compare this value to dp[i][j-1] (assuming you don't make a transaction at all). dp[i-1][j]
technically makes to sense, but you want to compare it anyways because there can be cases where
the max will be at 1 transaction, but not at 2. This makes it so that you don't need to find the
max of dp[i][nums.length - 1] at the end.

Runtime: O(kn), to populate the DP array.

Space Complexity: O(kn), where k is the # of transactions allowed. In this case, k = 3. n is the
amount of prices.

*/

public int maxProfit(int[] prices) {
  int[][] dp = new int[3][prices.length];
  if(prices.length == 0) {
    return 0;
  }
  for(int i = 0; i < prices.length; i++) {
    dp[0][i] = 0;
  }
  for(int i = 0; i < 3; i++) {
    dp[i][0] = 0;
  }
  for(int i = 1; i < 3; i++) {
    for(int j = 1; j < prices.length; j++) {
      int max = 0;
      for(int k = j - 1; k > 0; k--) {
        max = Math.max(max, dp[i - 1][k - 1] + prices[j] - prices[k]);
      }
      max = Math.max(max, prices[j] - prices[0]);
      dp[i][j] = Math.max(dp[i][j-1], Math.max(max, dp[i-1][j]));
    }
  }
  return dp[2][prices.length - 1];
}
