/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/missing-number/

Description: Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one
that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant
extra space complexity?

Solution: If one value is missing, that means nums.length replaced one of the numbers, so XOR the
index with the values, and start with nums.length for val, so that you'll be left with the missing
number.
Runtime: O(n)

Space Complexity: O(1)

*/

class Solution {
    public int missingNumber(int[] nums) {
        int val = nums.length;
        for(int i = 0; i < nums.length; i++) {
            val ^= nums[i] ^ i;
        }
        return val;
    }
}
