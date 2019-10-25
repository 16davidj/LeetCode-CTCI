/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/climbing-stairs/

Description: You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Solution: Recursively, this problem is pretty intuitive. You have your basic base cases at n <= 0
and n = 1, then you want to recursively add tripleStep(n - 1), tripleStep(n - 2), tripleStep(n -
3). However, because there are n levels with 3 branches, that is 3^n. We want to use dynamic
programming. Create an array with n length, n[x] represents the amount of ways you can get to the x
stair. n[x] will be equal to n[x-1] + n[x-2] + n[x-3]. Obviously set the base cases in the DP array.

Runtime: O(n)

Space Complexity: O(n) for the DP array
*/

public int climbStairs(int n) {
  int[] dp = new int[n + 1];
  dp[0] = 1;
  dp[1] = 1;

  for(int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
  }
  return dp[n];
}
