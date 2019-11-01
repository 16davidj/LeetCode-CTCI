/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/palindrome-permutation/

Description: Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true

Solution: Count the character occurrences using a charMap of 128 (the size of ascii table, so that
the space complexity is O(1))

Runtime: O(n)

Space Complexity: O(1)

*/


class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] charMap = new int[128];
        for(char c : s.toCharArray()) {
            charMap[c] += 1;
        }
        int seenOdd = 0;

        for(int count : charMap) {
            if(count % 2 == 1) {
                seenOdd++;
                if(seenOdd > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
