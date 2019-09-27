/*
Difficulty: Mediium
Problem Link: https://leetcode.com/problems/longest-common-subsequence/

Description:

Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some
characters(can be none) deleted without changing the relative order of the remaining characters.
(eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings
is a subsequence that is common to both strings.

If there is no common subsequence, return 0.

Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.

Solution: Regular dp problem. If i == j at the cell, then you can take the max of 1+dp[i-1][j-1]
because the characters match, so you add to the subsolution of i-1, j-1, and you compare it to
i-1,j and i,j-1. If they don't match, then you just compare i-1, j and i, j-1 because you want
to compare the longest subsequence if you include one character or another for the most information.

Runtime: O(mn)

Space Complexity: O(mn)

*/

public int longestCommonSubsequence(String text1, String text2) {
  int [][] dp = new int[text1.length() + 1][text2.length() + 1];
  for(int i = 0; i <= text1.length(); i++) {
    dp[i][0] = 0;
  }
  for(int j = 0; j <= text2.length(); j++) {
    dp[0][j] = 0;
  }
  for(int i = 1; i <= text1.length(); i++) {
    for(int j = 1; j <= text2.length(); j++) {
      if(text1.charAt(i-1) == text2.charAt(j-1)) {
        dp[i][j] = Math.max(1+dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
      } else {
        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
      }
    }
  }
  return dp[text1.length()][text2.length()];
}
