/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/median-of-two-sorted-arrays/

Description:
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

Solution:
See the youtube video for more context, and see below comments. Essentially, nums1 has to be the
shorter array, and nums2 is the longer array. partition is where you cut off the both arrays
at a certain place (partiton 2 means 2 elements to the left). It is like binary search because
you search for the right place to partition X such that it has a elements and nums2 has b elements
to the left, where the total elements to the left will give you the median.

Youtube Video: https://www.youtube.com/watch?v=LPFhl65R7ww

Runtime: O(log(min(m, n)))

Space Complexity: O(1)

*/

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
  if(nums2.length < nums1.length) {
    return findMedianSortedArrays(nums2, nums1);
  }

  int start = 0;
  int end = nums1.length;

  while(start <= end) {
    int partitionX = (start+end)/2;
    int partitionY = (nums1.length + nums2.length + 1)/2 - partitionX;
    int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
    int minRightX = partitionX == nums1.length ? Integer.MAX_VALUE : nums1[partitionX];
    int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
    int minRightY = partitionY == nums2.length ? Integer.MAX_VALUE : nums2[partitionY];

    if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
      if((nums1.length + nums2.length)%2 == 0) {
        return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0;
      } else {
        return (double) Math.max(maxLeftX, maxLeftY);
      }
    }

    if(maxLeftX > minRightY) {
       end = partitionX - 1;
     } else {
       start = partitionX + 1;
     }
    }
    return 0.0;
  }
