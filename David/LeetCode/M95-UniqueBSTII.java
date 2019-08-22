/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/unique-binary-search-trees-ii/

Description:
Given an integer n, generate all structurally unique BST's (binary search trees) that store values
1 ... n.

Solution:


Runtime:
Space complexity:
Time Complexity:
*/

public List<TreeNode> generateTrees(int n) {
  if(n == 0) {
    return new ArrayList<TreeNode>();
  }
  return generateTrees(1, n);
}

public List<TreeNode> generateTrees(int start, int n) {
  List<TreeNode> res = new ArrayList<>();
  if(start > n) {
    res.add(null);
    return res;
  }

  for(int i = start; i <= n; i++) {
    List<TreeNode> leftTrees = generateTrees(start, i - 1);
    List<TreeNode> rightTrees = generateTrees(i + 1, n);
    for(TreeNode leftTree : leftTrees) {
      for(TreeNode rightTree : rightTrees) {
        TreeNode root = new TreeNode(i);
        root.left = leftTree;
        root.right = rightTree;
        res.add(root);
      }
    }
  }
  return res;
}
