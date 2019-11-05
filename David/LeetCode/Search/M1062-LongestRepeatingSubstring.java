/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/longest-repeating-substring/

Description: 1062. Longest Repeating Substring
Medium

80

4

Favorite

Share
Given a string S, find out the length of the longest repeating substring(s). Return 0 if no
repeating substring exists.

Example 1:

Input: "abcd"
Output: 0
Explanation: There is no repeating substring.
Example 2:

Input: "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
Example 3:

Input: "aabcaabdaab"
Output: 3
Explanation: The longest repeating substring is "aab", which occurs 3 times.
Example 4:

Input: "aaaaa"
Output: 4
Explanation: The longest repeating substring is "aaaa", which occurs twice.


Note:

The string S consists of only lowercase English letters from 'a' - 'z'.
1 <= S.length <= 1500

Solution:
You have a range of 0 to 16, and you want to find the longest value.
The problem is structured so that if there isn't a longest repeat subsequence that is of length
3, that means there CAN'T be a longest subsequence of 4. However, if there is a longest subsequence
of length 3, that means there can be a solution that is 4, so you use binary search, with a
different search function telling you if such a length is possible.

Runtime: O(n log n): Binary search

Space Complexity: O(n^2): The hashset is N^2

*/
class Solution {
    public int longestRepeatingSubstring(String S) {
        int lo = 0;
        int hi = S.length();
        while(lo < hi) {
            int mid = (lo + hi + 1)/2;
            if(!search(S, mid)) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
    public boolean search(String S, int l) {
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < S.length() - l + 1; i++) {
            String word = S.substring(i, i + l);
            if(seen.contains(word)) {
                return true;
            }
            seen.add(word);
        }
        return false;
    }
}
