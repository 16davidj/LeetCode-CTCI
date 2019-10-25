/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/path-sum-iii/

Description:
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling
only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Solution:
Have a recursive helper that helps you count. If the root.val = sum, then you increment the count
by 1, but don't stop there, it is possible that there can still be a path that builds on the
current one, even if the sum = 0, which is why you recursively call the helper on left and right,
but subtract the root value.

For the main function, you want to do pathSumHelper on the root to find any routes that start
from the root, but also want to recursively call pathSum to find roots that start on subtrees.

Runtime:
Time Complexity: O(n^2): you have to traverse the tree at every node.

Space Complexity: O(n): At worse you have n recursive calls.
*/

public int pathSum(TreeNode root, int sum) {
  if(root == null) {
      return 0;
  }
  return pathSumHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
}

public int pathSumHelper(TreeNode root, int sum) {
  int res = 0;
  if(root == null) {
    return res;
  }
  if(root.val == sum) {
    res = 1;
  }
  return res + pathSumHelper(root.left, sum - root.val) + pathSumHelper(root.right, sum -
    root.val);
}
