/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

Description: Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Solution: This is an example of the sliding window problem for a substring. You have a begin and
an end to the window, the maxLength of the window so far, and whether the window still matches
the constraints. Then, you go character by character with the end pointer, and you put them in a
map to keep track of their occurrences. However, once the constraint is not fulfilled, then you
move begin up until it satisfies the constraint again, also removing the characters from the map
for their occurrences. You update max everytime you iterate.

Runtime: O(n)

Space Complexity: O(n)

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
      int begin = 0;
      int end = 0;
      int counter = 0;
      int max = 0;

      Map<Character, Integer> map = new HashMap<>();

      while(end < s.length()) {
        char c = s.charAt(end);
        map.put(c, map.getOrDefault(c, 0) + 1); //increment occurrences everytime you see one
        if(map.get(c) > 1) {
          counter++;
        }
        end++;

        while(counter > 0) {
          char c2 = s.charAt(begin);
          if(map.get(c2) > 1) {
            counter--; //if you find the violation, decrement counter
          }
          map.put(c2, map.get(c2) - 1); //update the counter in the map
          begin++;
        }
        max = Math.max(max, end - begin); //update max everytime
      }
      return max;
    }
  }
