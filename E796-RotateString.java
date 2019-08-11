/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/rotate-string/

Description:
Given a sorted array and a target value, return the index if the target is found. If not, return
the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Solution:
because the string is a rotation at a certain point, you concatenate it to itself, and try
isSubstring on the entire string.

Runtime:
Average and worst case: O(N^2), concatenation takes O(n^2) time because strings are immutable
and adding one character at a time would result in n^2 runtime.
*/
public boolean rotateString(String A, String B) {
  if(A.length != B.length) {
    return false;
  }
  String concat = B + B;
  return concat.contains(A);
}
