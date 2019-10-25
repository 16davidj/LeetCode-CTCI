/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Description: Given a string containing digits from 2-9 inclusive, return all possible letter
combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does
not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Solution: Basic backtracking solution


Runtime: O(N * 4^N): There are a max of 4 characters for a specific character. This causes the
recursion to split into 4 different subtrees, but for N characters

Space Complexity: O(3^N * 4^M): This is the max amount of solutions, where there are n characters
and m characters with 4 letters.

*/

Map<Character, String> dict = new HashMap<>();

public List<String> letterCombinations(String digits) {
  dict.put('2', "abc");
  dict.put('3', "def");
  dict.put('4', "ghi");
  dict.put('5', "jkl");
  dict.put('6', "mno");
  dict.put('7', "pqrs");
  dict.put('8', "tuv");
  dict.put('9', "wxyz");
  List<String> result = new ArrayList<>();
  if(digits.length() == 0) {
    return result;
  }
  helper(result, "", digits, 0);
  return result;
}

public void helper(List<String> results, String s, String digits, int index) {
  if(s.length() == digits.length()) {
    results.add(s);
  } else {
    for(char c : dict.get(digits.charAt(index)).toCharArray()) {
      String combine = s + c;
      helper(results, combine, digits, index + 1);
    }
  }
}
