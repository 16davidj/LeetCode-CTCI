/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/majority-element/solution/

Description:
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

Solution: The logic behind this is that if an element is a majority element, it will persist to
the end and have a count that is greater than 1 at the end, since you do +1 for every element of it
and -1 for anything else. Of course, you could not have a majority and just end with a candidate
at the end with a count greater than 1, so you do a double check for count at the end.

https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
see correctness part

Runtime: O(n)

Space Complexity: O(1)

*/

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
          if(count == 0) {
            candidate = nums[i];
            count++;
          } else {
            if(candidate != nums[i]) {
              count--;
            } else {
              count++;
            }
          }
        }
        count = 0;
        for(int i = 0; i < nums.length; i++) {
          if(nums[i] == candidate) {
            count++;
          }
        }
        if(count >= (nums.length + 1)/2) {
          return candidate;
        }
        return -1;
    }
}
