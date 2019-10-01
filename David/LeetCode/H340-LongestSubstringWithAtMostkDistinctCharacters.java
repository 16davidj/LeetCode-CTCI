/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

Description:
Given a string, find the length of the longest substring T that contains at most k distinct
characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.

Solution:
This is the same solution as H159-LongestSubstringWithAtMost2DistinctCharacters, just generalize to
k.

Runtime: O(n)

Space Complexity: O(k), the HashMap will have at most k characters

*/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      int max = 0;
      int begin = 0;
      int end = 0;
      Map<Character, Integer> map = new HashMap<>();

      while(end < s.length()) {
        char c = s.charAt(end);
        map.put(c, map.getOrDefault(c, 0) + 1);
        end++;
        while(begin < s.length() && map.size() > k) {
          char c2 = s.charAt(begin);
          if(map.get(c2) == 1) {
            map.remove(c2);
          } else {
            map.put(c2, map.get(c2) - 1);
          }
          begin++;
        }
        if(map.size() <= k) {
          max = Math.max(max, end - begin);
        }
      }
      return max;
    }
}
