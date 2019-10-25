/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/serialize-and-des

Description:
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

Solution:
First, you can serialize the BST without having to put null in the string because null is implied
if a value can't fit from a preorder traversal, because the tree is traversed in a preorder manner,
so if the top value from the queue can't fit there, nothing can

Runtime: O(n), you have one pass through the entire tree

Space Complexity: O(n) for queue

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) {
            return "";
        }
        sb.append(root.val);
        sb.append(",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        String [] sArr = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for(String s : sArr) {
            Integer strInt = Integer.parseInt(s);
            queue.add(strInt);
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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
