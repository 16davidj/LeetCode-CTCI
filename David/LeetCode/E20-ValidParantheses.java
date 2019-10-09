/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/valid-parentheses/

Description: Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

Solution: Valid Parantheses is always a check for the most recent parantheses, so use a stack and
try to go from inside-out as a check.

Runtime: O(n)

Space Complexity: O(n)

*/

class Solution {
    public boolean isValid(String s) {
      Stack<Character> stk = new Stack<Character>();
      char [] arr = s.toCharArray();
      for(char x : arr) {
        if(x == '{' || x == '[' || x == '(') {
          stk.push(x);
        } else if(x == '}') {
          if(stk.empty() || stk.pop() != '{') {
            return false;
          }
        } else if(x == ')') {
          if(stk.empty() || stk.pop() != '(') {
            return false;
          }
      } else if(x == ']') {
        if(stk.empty() || stk.pop() != '[') {
          return false;
        }
      }
    }
    return stk.empty();
}
}
