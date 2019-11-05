/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/longest-repeating-substring/

Description: 1062. Longest Repeating Substring
Medium

80

4

Favorite

Share
Given a string S, find out the length of the longest repeating substring(s). Return 0 if no
repeating substring exists.



Example 1:

Input: "abcd"
Output: 0
Explanation: There is no repeating substring.
Example 2:

Input: "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
Example 3:

Input: "aabcaabdaab"
Output: 3
Explanation: The longest repeating substring is "aab", which occurs 3 times.
Example 4:

Input: "aaaaa"
Output: 4
Explanation: The longest repeating substring is "aaaa", which occurs twice.


Note:

The string S consists of only lowercase English letters from 'a' - 'z'.
1 <= S.length <= 1500

Solution: DP solution where you only rely on dp[i-1][j-1] to continue your longest seen subsequence


Runtime: O(n^2)

Space Complexity: O(n^2)

*/

class Solution {
    public int longestRepeatingSubstring(String S) {
        int[][] dp = new int[S.length() + 1][S.length() + 1];
        for(int i = 0; i < S.length() + 1; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        int max = 0;

        for(int i = 1; i < S.length() + 1; i++) {
            for(int j = 1; j < S.length() + 1; j++) {
                if(S.charAt(i-1) == S.charAt(j-1) && i != j) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
