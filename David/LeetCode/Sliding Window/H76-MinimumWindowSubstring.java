/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/minimum-window-substring/

Description:
Given a string S and a string T, find the minimum window in S which will contain all the characters
in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum
window in S.

Solution:
This is a sliding window problem, see comments for more details

Runtime: O(n)

Space Complexity: O(n)

*/

class Solution {
    public String minWindow(String s, String t) {
      int min = Integer.MAX_VALUE;
      int begin = 0;
      int end = 0;
      int counter = 0;
      int min_begin = begin;

      Map<Character, Integer> map = new HashMap<Character, Integer>();
      for(char c : t.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1); // frequency of each character
      }

      while(end < s.length()) {
        char c = s.charAt(end);
        if(map.containsKey(c)) {
          map.put(c, map.get(c) - 1);
          if(map.get(c) == 0) { //you don't want to increment counter everytime, as then
          //abbc = aabc, as counter will not be able to determine the difference. You use == 0
          //so it counts the amount of unique characters you've completed
            counter++;
          }
        }
        end++;

        //counter = map.size meaning that it has gotten rid of every unique value to 0
        while(begin < s.length() && counter == map.size()) {
          char c2 = s.charAt(begin);
          if(map.containsKey(c2)) {
            map.put(c2, map.get(c2) + 1);
            if(map.get(c2) > 0) { //has to go from 0 to 1, that means that there are less of that
                //chars in the substring than the og. If it goes from -1 to 0, that just means that 
                //you had two occurrences of the character (AA) when there is only one
                //occurrence, and you still have another to get rid of, as you just got rid of the
                //first
                counter--; //this means that a unique character has been put back, not satsifying
                //the condition
            }
          }
          if(end - begin < min) {
            //do this before incrementing begin
            min_begin = begin;
            min = end - begin;
          }
          begin++;
        }
      }
      return min == Integer.MAX_VALUE ? "" : s.substring(min_begin, min_begin + min);
    }
}
