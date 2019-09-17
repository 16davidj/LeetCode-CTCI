/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Description:
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock
before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
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
This solution is greedy. The thing to note is that you want to abuse peaks and valleys. You want
to buy a stock at a valley, then sell it off at its highest peak. What this means is that if a
current stock price is greater than the previous price, it's still increasing, so you can add to
the total money you would make using the difference. Once it decreases (the if-statement won't be
satisfied), then you start again and buy a new one, then see if its increasing.

Runtime: O(n)

Space Complexity: O(1)

*/

public int maxProfit(int[] prices) {
  int total = 0;
  for(int i = 1; i < prices.length; i++) {
    if(prices[i] > prices[i - 1]) {
      total += (prices[i] - prices[i - 1]);
    }
  }
  return total;

}
