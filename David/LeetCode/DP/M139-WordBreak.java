/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/word-break/

Description: Given a non-empty string s and a dictionary wordDict containing a list of non-empty
words, determine if s can be segmented into a space-separated sequence of one or more dictionary
words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

Solution: use a dp array to indicate that up to the ith index, you can wordBreak. This is because
you don't have to keep track what words make up which index, you just have to check if up to
that index, it works, and then you can check the rest as a substring. It's kind of like best time
to buy and sell stock parts III and IV.

Runtime: O(n^2)

Space Complexity: O(n): dp array

*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] dp = new boolean [s.length()];
        String first = s.substring(0, 1);
        dp[0] = wordDict.contains(first);

        for(int i = 1; i < s.length(); i++) {
          for(int j = i; j >= 0; j--) {
            String sub = s.substring(j, i + 1);
            if(j == 0) {
              dp[i] = wordDict.contains(sub);
            } else if(dp[j - 1] && wordDict.contains(sub)) {
              dp[i] = true;
              break;
            }
          }
        }
        return dp[s.length() - 1];
    }
}
