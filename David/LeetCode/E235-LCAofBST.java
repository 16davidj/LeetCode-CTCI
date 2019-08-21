/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

Description:
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the
BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two
nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node
to be a descendant of itself).”

Solution:
If both p and q values are less that or greater than the root, then recursively run in on that
respective side of the tree. The only time you would return the root is when these are not
the case, meaning that they are on different sides of the tree (root is LCA), or p == root or
q == root and they are on the same side of the tree

Runtime: space: O(log n): you have to traverse the depth of the tree at worst case.
*/

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  if(p.val > root.val && q.val > root.val) {
    return lowestCommonAncestor(root.right, p, q);
  } else if (p.val < root.val && q.val < root.val) {
    return lowestCommonAncestor(root.left, p, q);
  }
  return root;
}
