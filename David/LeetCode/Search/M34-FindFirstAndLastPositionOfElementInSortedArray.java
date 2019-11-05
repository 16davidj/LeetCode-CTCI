/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Description: Given an array of integers nums sorted in ascending order, find the starting and
ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Solution: Binary search for the left side and the right side

Runtime: O(log n)

Space Complexity: O(1)

*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = findLeft(nums, target);
        int rightIdx = findRight(nums, target);
        return leftIdx >= 0 && leftIdx < nums.length && rightIdx >= 0 && rightIdx < nums.length &&
        nums[leftIdx] == target && nums[rightIdx] == target ? new int[]{leftIdx, rightIdx} : new
        int[]{-1, -1};
    }

    public int findLeft(int[] nums, int target) {
      int lo = 0;
      int hi = nums.length - 1;
      while(lo < hi) {
        int mid = (lo + hi + 1)/2;
        if(nums[mid] < target) {
          lo = mid + 1;
        } else if(nums[mid] > target) {
          hi = mid - 1;
        } else {
          if(mid - 1 >= 0 && nums[mid - 1] == target) {
            hi = mid - 1;
          } else {
            return mid;
          }
        }
      }
      return lo;
    }

    public int findRight(int[] nums, int target) {
      int lo = 0;
      int hi = nums.length - 1;
      while(lo < hi) {
        int mid = (lo + hi + 1)/2;
        if(nums[mid] < target) {
          lo = mid + 1;
        } else if(nums[mid] > target) {
          hi = mid - 1;
        } else {
          if(mid + 1 < nums.length && nums[mid + 1] == target) {
            lo = mid + 1;
          } else {
            return mid;
          }
        }
      }
      return lo;
    }
}
