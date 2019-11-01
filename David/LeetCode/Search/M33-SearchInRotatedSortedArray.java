/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

Description:
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n)

Solution:
The basic solution is that every time you split the array in half, there will be at least one side
that is sorted. (There will only be a sequence of two numbers that are out of place, so both sides
can't be unsorted.) Check the sorted side to see if the target belongs there, if not, go to the
other side. (so it's modified binary search, and instead of just comparing the target to the middle,
you have to compare the target to both sides to see where it may lie.)

Runtime: O(log n)

Space Complexity: O(1)

*/

public int search(int[] nums, int target) {
  int lo = 0;
  int hi = nums.length - 1;

  while(lo <= hi) {
    int mid = (lo + hi)/2;
    if(nums[mid] == target) {
      return mid;
    } else if(target >= nums[lo] && target < nums[mid]) {
      hi = mid - 1; //if the target is in between the in order part, between lo and mid
    } else if(target > nums[mid] && target <= nums[hi]){
      lo = mid + 1; //if the target is in between the in order part, between mid and high
    } else if(nums[mid] > nums[hi]) {
        lo = mid + 1; //if the right side is unordered, go there
    } else {
        hi = mid - 1; //if the left side is unordered, go there
    }
  }
  return -1;
}
