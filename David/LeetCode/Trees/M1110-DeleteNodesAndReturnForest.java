/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/delete-nodes-and-return-forest/

Description:
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of
trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

Solution:
This solution is recursive, so you have to consider two things.
1) When do I add to the list? In one-pass, you add to the list when the parent is deleted/doesn't
exist.
2) How do I modify the tree at the same time? This would be through tree.left = some recursive call
that edits the tree, and tree.right. The function would have to return an edited tree as well. If
you're deleting the tree, return null, else, return the root.

Runtime: O(n), you have one pass through the entire tree

Space Complexity: O(n) for hashSet

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
    ArrayList<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        HashSet<Integer> toDel = new HashSet<>();
        for(int del : to_delete) {
            toDel.add(del);
        }
        dfs(root, toDel, false);
        return res;
    }

    public TreeNode dfs(TreeNode root, HashSet<Integer> toDel, boolean parentExists) {
        if(root == null) {
            return null;
        }
        boolean toDelete = toDel.contains(root.val);
        if(!parentExists && !toDelete) {
            res.add(root);
        }
        root.left = dfs(root.left, toDel, !toDelete);
        root.right = dfs(root.right, toDel, !toDelete);
        if(toDelete) {
            return null;
        }
        return root;
    }
}
