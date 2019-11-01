/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

Description:
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?

Solution:
An extension off of M33, but the difference is that if nums[mid] == nums[hi] == nums[lo], then
you don't know which side to go, because either side could be unsorted. Then you just do lo++ and
hi-- to continue the search (this is equivalent to using a while loop to skip all the duplicates).

Runtime: O(log n), O(n) worst time if almost every value is a duplicate.

Space Complexity: O(1)

*/

class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi) {
          int mid = (lo + hi)/2;
          if(nums[mid] != target && lo == hi) {
              return false;
          }
          if(nums[mid] == target) {
            return true;
          } else if(target >= nums[lo] && target < nums[mid]) {
            hi = mid - 1;
          } else if(target > nums[mid] && target <= nums[hi]){
            lo = mid + 1;
          } else if(nums[lo] > nums[mid]) {
              hi = mid - 1;
          } else if(nums[hi] < nums[mid]) {
              lo = mid + 1;
          } else {
              lo++;
              hi--;
          }
      }
      return false;
    }
}
