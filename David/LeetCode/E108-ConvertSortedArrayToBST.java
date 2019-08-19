/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Description:
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
the two subtrees of every node never differ by more than 1.

Solution:
Get the middle as the root, and then run the function on the left and right side, with the resulting
trees being the left and right children. (Recursive)

Runtime:
space complexity: O(log n), since there are log n levels of recursion
Time Complexity: 2(O(N/2)) + O(1) = O(N)
O(1) is creation of the root, O(N/2) is the recursive process, and you have two of those.
*/

public TreeNode sortedArrayToBST(int[] nums) {
  if(nums.length == 0) {
    return null;
  } else {
    return helper(nums, 0, nums.length - 1);
  }
}

public TreeNode helper(int[] nums, int lo, int hi) {
  if(lo > hi) {
      return null;
  }
  if(hi == lo) {
    return new TreeNode(nums[hi]);
  } else {
    int mid = (hi + lo)/2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helper(nums, lo, mid - 1);
    root.right = helper(nums, mid + 1, hi);
    return root;
  }
}
