/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/subtree-of-another-tree/

Description:
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and
node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this
node's descendants. The tree s could also be considered as a subtree of itself.

Solution:
You need the equals function because if you try to do the traversal and equals check within the
same function recursively, in the example where the root is equal but the children are not, then
you return false without checking any of the other nodes, which doesn't work for trees with
duplicate values in the node.

Runtime:
Time Complexity: O(m * n): in the worst case scenario, you would have to go through every
node in both trees and compare them (think of it as a nested for loop).

Space Complexity: O(n): there are n recursive calls at most
*/

public boolean isSubtree(TreeNode s, TreeNode t) {
  return s != null && (equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
}

public boolean equals(TreeNode s, TreeNode t) {
  if(s == null && t == null) {
    return true;
  }
  if(s != null && t != null && s.val == t.val) {
    return equals(s.left, t.left) && equals(s.right, t.right);
  }
  return false;
}
