/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/wildcard-matching/

Description:
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for
'?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring
"dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false

Solution: This is similar to H72, edit-distance. There are a few cases to consider. The base cases
are trivial, so go over that just by looking at the code. isAllStar means that in order to match
the empty string in s, p must be empty or all stars.
dp[i][j] is set differently depending on what the character is. If the characters don't
match, and are not wildcards, then you just set it to false, because those are the last
characters in the strings, so it can't match. If the characters do match, then you set
dp[i][j] = dp[i-1][j-1]. dp[i-1][j] and dp[i][j-1] don't matter because it doesn't matter that the
characters match. If the characters match, then the entire pattern and string at i-1, j-1 must
match for it to be true. The others, you end up with misalignment. Then, if it is "?", it's the
same as the characters being equal, because ? takes up a character slot, so both have to go back
1 to i-1, j-1. If it is *, because it is a sequence that can be empty, you can add as many
characters as u want to s, as long as i, j-1 is true, or it can be treated as a ?, so OR i-1, j-1,
or because * can be empty, OR i-1, j.

Runtime: O(mn), to populate the dp array

Space Complexity: O(mn), to populate the dp array

*/

class Solution {
  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for(int i = 1; i <= s.length(); i++) {
      dp[i][0] = false;
    }
    boolean isAllStar = true;
    for(int j = 1; j <= p.length(); j++) {
      if(p.charAt(j - 1) != '*') {
        isAllStar = false;
      }
      dp[0][j] = isAllStar;
    }
    for(int i = 1; i <= s.length(); i++) {
      for(int j = 1; j <= p.length(); j++) {
        char sc = s.charAt(i - 1);
        char pc = p.charAt(j - 1);
        if(sc == pc) {
          dp[i][j] = dp[i-1][j-1];
        } else if(pc == '?') {
          dp[i][j] = dp[i-1][j-1];
        } else if(pc == '*') {
          dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1];
        } else {
          dp[i][j] = false;
        }
      }
    }
    return dp[s.length()][p.length()];
  }
}
