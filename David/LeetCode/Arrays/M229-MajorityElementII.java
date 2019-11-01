/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/majority-element-ii/

Description:
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

Solution: Generalize the solution to the MajorityElement problem

https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
see correctness part

Runtime: O(n)

Space Complexity: O(1)

*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;

        int candidate1 = 0;
        int candidate2 = 0;

        List<Integer> res = new ArrayList<>();
        int i = 0;
        while(i < nums.length) {
          if(nums[i] == candidate1) {
            count1++;
          } else if(nums[i] == candidate2) {
            count2++;
          } else if(count1 == 0) {
            candidate1 = nums[i];
            count1++;
          } else if(count2 == 0) {
            candidate2 = nums[i];
            count2++;
          } else {
            count1--;
            count2--;
          }
          i++;
        }

        count1 = 0;
        count2 = 0;
        for(int j = 0; j < nums.length; j++) {
          if(nums[j] == candidate1) {
            count1++;
          } else if(nums[j] == candidate2) {
            count2++;
          }
        }
        if(count1 > nums.length/3) {
          res.add(candidate1);
        }
        if(count2 > nums.length/3) {
          res.add(candidate2); 
        }

        return res;
    }
}
