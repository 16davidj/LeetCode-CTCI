/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/find-bottom-left-tree-value/

Description:
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.

Solution: Level order traversal, but the other way around, right to left


Runtime: O(n), has to traverse all nodes

Space Complexity: O(1)

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        TreeNode val = null;
        while(!q.isEmpty()) {
            val = q.poll();
            if(val.right != null) {
                q.add(val.right);
            }
            if(val.left != null) {
                q.add(val.left);
            }
        }
        return val.val;
    }
}
