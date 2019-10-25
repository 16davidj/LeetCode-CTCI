/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/wiggle-sort/

Description: Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >=
nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]

Solution: This is essentially sorting every two elements. nums[0] <= nums[1], nums[1] >= nums[2],
and keep flipping. Essentially, you do this for every odd or every even part, and you just swap,
and because this solution is greedy, you'll eventually come to the solution.

Runtime: O(n)

Space Complexity: O(1)

*/
class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(i % 2 == 0) {
               if(nums[i] > nums[i + 1]) {
                   int temp = nums[i];
                   nums[i] = nums[i+1];
                   nums[i+1] = temp;
               }
            } else {
                if(nums[i] < nums[i + 1]) {
                   int temp = nums[i];
                   nums[i] = nums[i+1];
                   nums[i+1] = temp;
               }
            }
        }
    }
}
