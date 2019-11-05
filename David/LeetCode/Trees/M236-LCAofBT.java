/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Description:
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two
nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node
to be a descendant of itself).”

Solution:
Essentially a DFS for the nodes you want to find, but when you find them, populate them up.
At some point, the two populated nodes will meet as right and left at a root node, and then
you want to populate that root node up and eventually return it.

Note that the problem changes when you're not guaranteed that both values are in the tree, and
that you need to have to keep track of a count for all the nodes that you find.

Runtime:
Space complexity: O(log n): log n, height of the tree, recursive levels
Runtime complexity: O(n): worst case, you run through all the nodes
*/

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  if(root == null || root == p || root == q) {
    return root;
  } else {
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if((left == p && right == q) || (right == p && left == q)) {
      return root;
    } else if(left != null && right == null) {
      return left;
    }
    return right;
  }
}
