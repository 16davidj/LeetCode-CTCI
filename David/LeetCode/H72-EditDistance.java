/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/edit-distance/

Description:
Given two words word1 and word2, find the minimum number of operations required to convert word1 to
word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

Solution:
DP, since you're checking for the distance between two words, see comments.
Note: The indexing is a little weird because the base case is the empty string for the strings,
it doesn't start at the first character.

Note: i-1, j to i, j and i, j-1 to i, j will always count as a character because you're measuring
DISTANCE between words. This means that to get to i,j then you will always have to add a character
to one word without adding a character to another word, thereby increasing the distance.

Runtime: O(mn): to populate the dp-array

Space Complexity: O(mn): for dp-array

*/

class Solution {
    public int minDistance(String word1, String word2) {
      int dp[][] = new int[word1.length()+1][word2.length()+1];
      //base case to populate the array
      for(int i = 0; i <= word1.length(); i++) {
        dp[i][0] = i;
      }
      for(int j = 0; j <= word2.length(); j++) {
        dp[0][j] = j;
      }
      for(int i = 1; i <= word1.length(); i++) {
        for(int j = 1; j <= word2.length(); j++) {
          if(word1.charAt(i-1) == word2.charAt(j-1)) {
            //if i == j, then the only thing that doesn't cost is i, j
            dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1] - 1, dp[i][j-1]));
          } else {
            dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
          }
        }
      }
      return dp[word1.length()][word2.length()];
    }
}
