/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/search-insert-position/

Description:
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Solution:
Essentially, the solution is binary search, but if binary search can't find the target in the array,
but in the last case scenario, when lo == hi, you make one more check, since now you know the
target is not in the array, but you move the index to where it should be.

Runtime:
Average and worst case: log n
Best time: if the element is always in the middle, O(1)

*/

public int searchInsert(int[] nums, int target) {
      int hi = nums.length - 1;
      int lo = 0;
      while(lo <= hi) {
        int mid = (hi + lo)/2;
        if(target == nums[mid]) {
          return mid;
        } else if(target > nums[mid]) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
      return lo;
    }
