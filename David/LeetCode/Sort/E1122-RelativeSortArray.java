/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/relative-sort-array/

Description:
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are
also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in
arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

Solution:
Create an array that acts as a count for occurrences. Since theres only 1000 values, it only
needs to be size 1000, so it is O(1) when you loop through it. Add all of the values and their
occurrences into the map, then go through array 2 and populate array 1 with each occurrence,
setting the occurrences to 0 once you are done with them. Then, go through the map and populate
the array with anything that doesn't have an occurrence # of 0.

Runtime: O(n)
Space Complexity: O(1)

*/

public int[] relativeSortArray(int[] arr1, int[] arr2) {
  int[] map = new int[1001];
  for(int x : arr1) {
    map[x]++;
  }

  int index = 0;
  for(int x : arr2) {
    for(int i = 0; i < map[x]; i++) {
      arr1[index] = x;
      index++;
    }
    map[x] = 0;
  }

  for(int i = 0; i < map.length; i++) {
    for(int j = 0; j < map[i]; j++) {
      arr1[index] = i;
      index++;
    }
  }
  return arr1;
}
