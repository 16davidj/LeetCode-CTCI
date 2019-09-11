/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/palindrome-partitioning/

Description: Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

Solution:


Runtime:

Space Complexity:

*/

public List<List<String>> partition(String s) {
  List<List<String>> result = new ArrayList<List<String>>();
  helper(result, new ArrayList<String>(), s, 0);
  return result;
}

public void helper(List<List<String>> result, List<String> tempList, String s, int start) {
  if(start == s.length()) {
    result.add(new ArrayList<String>(tempList));
  }
  for(int i = start; i < s.length(); i++) {
    String sub = s.substring(start, i + 1);
    if(isPalindrome(sub)) {
      tempList.add(sub);
      helper(result, tempList, s, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}

public boolean isPalindrome(String s) {
  int lo = 0;
  int hi = s.length() - 1;
  while(lo <= hi) {
    if(s.charAt(lo) != s.charAt(hi)) {
      return false;
    }
    lo++;
    hi--;
  }
  return true;
}
