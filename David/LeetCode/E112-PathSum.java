/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/path-sum/

Description:
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Solution:
if sum == root.val and it is a leaf node, then return true. Else, check to see if there is a path
with a recursive call, but include the root as already seen, so subtract the root's value from
sum.

Runtime:
Time Complexity: O(n): touches each node only once

Space Complexity: O(n): has as many recursive calls as the amount of nodes
*/

public boolean hasPathSum(TreeNode root, int sum) {
  if(root == null) {
    return false;
  }
  if(sum == root.val && root.right == null && root.left == null) {
    return true;
  }
  return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
}
