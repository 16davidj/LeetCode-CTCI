/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/trapping-rain-water/

Description: Given n non-negative integers representing an elevation map where the width of each
bar is 1, compute how much water it is able to trap after raining.

Solution:
This is the DP solution, not the most efficient, but it gets the tallest wall from the left
and from the right for each index, and then calculates how much water you can fit in that cell
given those heights.

Runtime: O(N)

Space Complexity: O(N) to keep the DP arrays

*/

public int trap(int[] height) {
  if(height.length == 0) {
    return 0;
  }
  int[] leftHeight = new int[height.length];
  int[] rightHeight = new int[height.length];
  int sum = 0;
  leftHeight[0] = height[0];
  rightHeight[height.length - 1]  = height[height.length - 1];
  for(int i = 1; i < leftHeight.length; i++) {
    leftHeight[i] = Math.max(leftHeight[i-1], height[i]);
  }
  for(int i = height.length - 2; i >= 0; i--) {
    rightHeight[i] = Math.max(rightHeight[i+1], height[i]);
  }
  for(int i = 0; i < height.length; i++) {
    sum += Math.min(leftHeight[i], rightHeight[i]) - height[i];
  }
  return sum;
}
