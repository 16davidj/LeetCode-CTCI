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
    public int maxDepth = -1;
    public TreeNode res = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public int dfs(TreeNode node, int depth) {
        if(node == null) {
            return depth;
        }

        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);

        int maxD = Math.max(left, right);
        maxDepth = Math.max(maxD, maxDepth);
        if(left == maxDepth && right == maxDepth) {
            res = node;
        }

        return maxD;
    }
}
