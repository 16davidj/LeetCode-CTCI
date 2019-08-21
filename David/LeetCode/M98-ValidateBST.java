/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/validate-binary-search-tree/

Description:
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Solution:
Use recursion: it is not sufficient to check that root.left.val < current < root.right.val for
each node (draw an example, head root = 4, sub root = 3, but root.right.val = 100000000). Thus, we 
need to make a upper and lower bound for each node, and update those bounds everytime you
traverse a new level. The bounds are set by the parent node, since the everything on the left
of a parent node must be less, and everything on the right of the node must be greater.

Runtime:
Space complexity: O(log n): log n recursive levels, height of the tree
Time Complexity: O(N): we visit each node once
*/

public boolean isValidBST(TreeNode root) {
  if(root == null) {
    return true;
  }
  return isValidBSTHelper(root.left, null, root.val) &&
    isValidBSTHelper(root.right, root.val, null);
}

public boolean isValidBSTHelper(TreeNode root, Integer low, Integer high) {
  if(root == null) {
    return true;
  }
  if((low != null && root.val <= low) || (high != null && root.val >= high)) {
    return false;
  } else {
    return isValidBSTHelper(root.left, low, root.val) && isValidBSTHelper(root.right, root.val, high);
  }
}
