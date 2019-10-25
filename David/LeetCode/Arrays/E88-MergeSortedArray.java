/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/merge-sorted-array/

Description:
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
additional elements from nums2.

Solution:
Work for the back, and insert the elements from each end of both arrays. This is because the back
is empty, so inserting an element in the back won't change anything. Also keep indices to keep
track of which index you are at for each array. If you insert in the front, you would have to
shift everything back.

Runtime: O(n)

Space Complexity: O(1)

*/

public void merge(int[] nums1, int m, int[] nums2, int n) {
    int bckIdx = m + n - 1;
    int n1Idx = m - 1;
    int n2Idx = n - 1;
    while(n1Idx >= 0 && n2Idx >= 0) {
      if(nums1[n1Idx] > nums2[n2Idx]) {
        nums1[bckIdx] = nums1[n1Idx];
        n1Idx--;
      } else {
        nums1[bckIdx] = nums2[n2Idx];
        n2Idx--;
      }
      bckIdx--;
    }
    while(n1Idx >= 0) {
      nums1[bckIdx] = nums1[n1Idx];
      bckIdx--;
      n1Idx--;
    }
    while(n2Idx >= 0) {
      nums1[bckIdx] = nums2[n2Idx];
      bckIdx--;
      n2Idx--;
    }
}
