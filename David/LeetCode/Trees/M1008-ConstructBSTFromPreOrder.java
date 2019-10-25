/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

Description: Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of
node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also
recall that a preorder traversal displays the value of the node first, then traverses node.left,
then traverses node.right.)

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Note:

1 <= preorder.length <= 100
The values of preorder are distinct.

Solution:
since preorder is ordered by the order that you place the nodes in it, use a queue. In order to
see if you should put a null value or not, you need to keep a range of min and max to see
if the value does belong in that position, as because it is a BST, a value should only belong in
one available position in the tree

Runtime: O(n)

Space Complexity: O(n)

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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) {
            return null;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i : preorder) {
            queue.add(i);
        }
        return constructHelp(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode constructHelp(Queue<Integer> queue, Integer min, Integer max) {
        if(queue.isEmpty()) {
            return null;
        }
        int val = queue.peek();
        if(val < min || val > max) {
            return null;
        }
        TreeNode node = new TreeNode(queue.poll());
        node.left = constructHelp(queue, min, val);
        node.right = constructHelp(queue, val, max);
        return node;
    }
}
