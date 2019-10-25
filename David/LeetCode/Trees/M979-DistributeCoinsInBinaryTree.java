/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/distribute-coins-in-binary-tree/

Description: Given the root of a binary tree with N nodes, each node in the tree has node.val
coins, and there are N coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The
move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.

Solution: This solution walks down all the nodes in a subtree, on the left and right, and determines
how many moves it would take to balance them, by incrementing moves. You want to find the
difference between the number of nodes and the number of coins, since that's the amount of coins
you have to populate up or need passed down. Each coin that is needed is one move. Two coins is
two moves. Then, you return the amount of nodes in the left and right, and the amount of coins
in the left and right, and then you do it for the parent.

Runtime: O(n): You have to visit every node

Space Complexity: O(1): The array has only two values

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
    int moves = 0;
    public int distributeCoins(TreeNode root) {
      getCoins(root);
      return moves;
    }

    public int[] getCoins(TreeNode root) {
      if(root == null) {
        return new int[]{0,0};
      }
      int[] left = getCoins(root.left);
      int[] right = getCoins(root.right);
      moves += Math.abs(left[0] - left[1]) + Math.abs(right[0] - right[1]);

      return new int[]{left[0] + right[0] + 1, left[1] + right[1] + root.val};
    }
}
