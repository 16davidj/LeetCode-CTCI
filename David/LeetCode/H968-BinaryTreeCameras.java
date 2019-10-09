/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/binary-tree-cameras/

Description: Given a binary tree, we install cameras on the nodes of the tree.

Each camera at a node can monitor its parent, itself, and its immediate children.

Calculate the minimum number of cameras needed to monitor all nodes of the tree.
(see link for example)

Solution:
This is the greedy solution. There are essentially three states. -1 is if the node is requesting
cover, and then you populate that up to the parent. If the node populates 0, then it's covered, but
there's no camera. If the node populates 1, then the parent is covered. If the node populates -1,
then the parent must put a camera there.

Runtime: O(N)

Space Complexity: O(H): levels of recursive depth

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
    int count = 0;

    public int minCameraCover(TreeNode root) {
      if(helper(root) == -1) {
        return count + 1;
      }
      return count;
    }

    public int helper(TreeNode root) {
      if(root == null) {
        return 0;
      }
      int left = helper(root.left);
      int right = helper(root.right);
      if(left == -1 || right == -1) {
        count += 1;
        return 1;
      }
      if(left == 1 || right == 1) {
        return 0;
      }
      if(left == 0 && right == 0) { //you know it has to be left == 0 and right == 0
        return -1;
      }
      return -1; //unreachable code
    }
}
