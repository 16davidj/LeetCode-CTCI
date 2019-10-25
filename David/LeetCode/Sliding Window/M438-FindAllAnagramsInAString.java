/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/

Description: Given a string s and a non-empty string p, find all the start indices of p's anagrams
in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not
be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Solution:
This is similar to window sliding. The trick behind this is keeping track of the number of
occurrences that the window has relative to the current substring you have. See comments for more
details

Runtime: O(n)

Space Complexity: O(n)

*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      Map<Character, Integer> map = new HashMap<>();
      for(char c : p.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      } //the beginning map with the amount of occurrences

      int begin = 0;
      int end = 0;
      int counter = 0;
      List<Integer> result = new ArrayList<>();

      while(end < s.length()) {
        char c = s.charAt(end);
        map.put(c, map.getOrDefault(c, 0) - 1);
        if(map.get(c) < 0) {//note it is not != 0 because if you have 2 occurrences of a char
          //but you just ran into one, it doesn't mean there is something wrong
          counter++; //counts the number of off you have. If it is less than 0, then you have
          //just added a number at the end that doesn't belong, or has occurred too many times
        }
        end++;

        while(begin < s.length() && counter > 0) {
          char c2 = s.charAt(begin);
          map.put(c2, map.get(c2) + 1);
          if(map.get(c2) == 0) {
            counter--; //subtract from counter because you have just removed a number that
            //originally caused a problem (it was less than 0, now it is 0)
          }
          begin++;
        }
        //add if it satisfies constraints
        if(counter == 0 && end - begin == p.length()) {
          result.add(begin);
        }
      }
      return result;
    }
}
