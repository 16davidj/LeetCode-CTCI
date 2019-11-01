/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/single-number-ii/

Description: Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra
memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

Solution: Essentially, count the number of times 1 appears in an index of a bit, and if it isn't
equal to 0, then you know the number contributing to the uneven amounts has a 1 in that bit, then
you shift and keep going. An uneven 0 doesn't change anything because the number is already 0
to begin with


Runtime: O(n)

Space Complexity: O(1)

*/

class Solution {
    public int singleNumber(int[] nums) {
        int val = 0;
        int mask = 1;
        int count1 = 0;
        for(int i = 0; i < 32; i++) {
            for(int num : nums) {
                if((mask & num) != 0) {
                    count1++;
                }
            }
            if(count1 % 3 != 0) {
                val += (1 << i);
            }
            mask = mask << 1;
            count1 = 0;
        }
        return val;
    }
}
