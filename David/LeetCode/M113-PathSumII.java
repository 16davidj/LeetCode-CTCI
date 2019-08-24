/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/path-sum-ii/

Description:
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given
sum.

Note: A leaf is a node with no children.

Solution:
Note: this is a backtracking solution.

The reason we pass the results in as a parameter is because before (see PathSumIII), adding ints is
not expensive. However, if we wanted to keep track of a List<List<>> results within the method,
we would have to do List.AddAll(right and left), which takes O(n) time, and we would want to
avoid that. The rest of solution mirrors PathSumIII, except for a list, and also keep in mind
that the question is only looking for paths from the actual root to a leaf node.

see comment at the bottom about backtracking

Runtime:
Time Complexity: O(n): touches each node once

Space Complexity: O(n): possibly call n recursive calls
*/


public List<List<Integer>> pathSum(TreeNode root, int sum) {
  if(root == null) {
    return new ArrayList<List<Integer>>();
  }
  List<List<Integer>> res = new ArrayList<List<Integer>>();
  pathSumHelper(root, sum, new ArrayList<Integer>(), res);
  return res;
}

public void pathSumHelper(TreeNode root, int sum, List<Integer> currList, List<List<Integer>> res) {
  if(root == null) {
    return;
  }
  currList.add(root.val);
  if(root.val == sum && root.left == null && root.right == null) {
    res.add(new ArrayList<Integer>(currList));
  }
  pathSumHelper(root.left, sum - root.val, currList, res);
  pathSumHelper(root.right, sum - root.val, currList, res);

  //you want to remove because of backtracking. You want the recursive level above you to use
  //their current list, not the list that you created with the recursive call.
  currList.remove(currList.size() - 1);
}
