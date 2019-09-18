/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

Description:
Serialization is the process of converting a data structure or object into a sequence of bits so
that it can be stored in a file or memory buffer, or transmitted across a network connection link
to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can
be serialized to a string and this string can be deserialized to the original tree structure.

Solution: This problem serializes and deserializes a tree using BFS. The serialization in BFS
allows us to traverse the tree level by level (unlike preorder or postorder), and we can
add each level of nodes to the string that represents the tree.

Because we serialized using BFS, we use a queue to deserialize. We want to populate both the left
and right children of the tree everytime we pop a current node, and then we add the children to
the queue and move on, until the queue becomes empty.

Runtime: O(n)

Space Complexity: O(n)

*/

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder serialize = new StringBuilder("");
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.add(root);
      while(!queue.isEmpty()) {
        TreeNode next = queue.poll();
        if(next == null) {
          serialize.append("null ");
        } else {
          serialize.append(next.val + " ");
          queue.add(next.left);
          queue.add(next.right);
        }
      }
      return serialize.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      data = data.trim();
      String[] tree = data.split(" ");
      TreeNode result = null;
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      int index = 0;
      if(tree[index].equals("null")) {
        return result;
      } else {
        TreeNode root = new TreeNode(Integer.parseInt(tree[index]));
        result = root;
        queue.add(root);
        index++;
      }
      while(index < tree.length - 1) {
        TreeNode current = queue.poll();
        if(!tree[index].equals("null")) {
          TreeNode left = new TreeNode(Integer.parseInt(tree[index]));
          queue.add(left);
          current.left = left;
        }
        if(!tree[index + 1].equals("null")) {
          TreeNode right = new TreeNode(Integer.parseInt(tree[index + 1]));
          queue.add(right);
          current.right = right;
        }
        index+=2;
      }
      return result;
    }
}
