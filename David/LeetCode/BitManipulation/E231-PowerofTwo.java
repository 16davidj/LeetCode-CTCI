/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/power-of-two/

Description: Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false

Solution: power of 2 will have a leftmost bit of 1 and all the rest 0's. If you and that with
it subtracted by 1, it will equal 0.

Runtime: O(1)

Space Complexity: O(1)

*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) {
            return false;
        }
        if(n < 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
