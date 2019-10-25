/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/balanced-binary-tree/

Description:
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Solution: use a helper function to not only explore the tree, but also pass up a value that
is either the height of the tree, or is -1 (meaning that the tree is not balanced). If -1 is
returned, you pop that -1 up to the original root and return that. If not, keep passing up the
heights, which will allow each level to compare the heights of the left or right child.

Runtime:
space complexity: O(log n): since the recursive stack goes down log n levels
runtime: O(N) time, touches all of the nodes
*/

public boolean isBalanced(TreeNode root) {
  return dfsSearch(root) != -1;
}

public int dfsSearch(TreeNode root) {
  if(root == null) {
    return 0;
  } else if(root.left == null && root.right == null) {
    return 1;
  } else {
    int rightHeight = dfsSearch(root.right);
    int leftHeight = dfsSearch(root.left);
    if(leftHeight == -1 || rightHeight == -1) {
      return -1;
    }
    int diff = Math.max(rightHeight, leftHeight) - Math.min(rightHeight, leftHeight);
    return diff <= 1 ? (Math.max(rightHeight, leftHeight) + 1) : -1;
  }
}
