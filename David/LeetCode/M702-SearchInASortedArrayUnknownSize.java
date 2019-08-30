/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Description:
Given an integer array sorted in ascending order, write a function to search target in nums.  If
target exists, then return its index, otherwise return -1. However, the array size is unknown to
you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns
the element of the array at index k (0-indexed).

You may assume all integers in the array are less than 10000, and if you access the array out of
bounds, ArrayReader.get will return 2147483647.

Solution:
Binary search takes O(log n). We want to leverage this fact to do some preprocessing in log n time.
We want to binary search, but we don't know the high value, so it's hard to find the mid. If you
use a slo and fast pointer, you would only find the mid in O(n/2) time, which makes it O(n). Thus,
we use the power function. We try to estimate size by squaring 2 repeatedly until you find the 
size value where it is out of bounds (-1). Then, this is the closest size we can find, and you
do binary search, but different, where if you hit -1, you treat it the same as if it is greater
than the mid (it is).

Runtime: O(log n)

Space Complexity: O(1)

*/

public int search(ArrayReader reader, int target) {
   int order = 0;
   int size = (int) Math.pow(2, order);
   while(reader.get(size) != -1 && reader.get(size) < target) {
     size = (int) Math.pow(2, order++);
   }
   if(reader.get(size) == target) {
     return size;
   } else {
     return binSearch(reader, 0, size, target);
   }
}

public int binSearch(ArrayReader reader, int lo, int hi, int target) {
  while(lo <= hi) {
    int mid = (lo + hi)/2;
    if(reader.get(mid) == target) {
        return mid;
    }
    if(reader.get(mid) > target || reader.get(mid) == -1) {
      hi = mid - 1;
    } else {
      lo = mid + 1;
    }
  }
    return -1;
}
