/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

Description: Given a string s , find the length of the longest substring t  that contains at most 2
distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.

Solution:
This is a sliding window problem. There is no counter, the way you indicate if the constraint is
no longer fulfilled is if map.size() > 2. You still have to keep track of a map with frequency b.c
if you have 2 characters that are not near each other, and begin removes the first occurrence
at say, index 0, you don't also want to remove the one at index j, as it still is in the string.
You can only remove a key from the map if it has 0 occurrences.

Runtime: O(n)

Space Complexity: O(1), since the hashMap will have at most 3 elements.

*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        int begin = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(end < s.length()) {
          char c = s.charAt(end);
          map.put(c, map.getOrDefault(c, 0) + 1);
          end++;
          while(begin < s.length() && map.size() > 2) {
            char c2 = s.charAt(begin);
            if(map.get(c2) == 1) {
              map.remove(c2);
            } else {
              map.put(c2, map.get(c2) - 1);
            }
            begin++;
          }
          if(map.size() <= 2) {
            max = Math.max(max, end - begin);
          }
        }
        return max;
    }
}
