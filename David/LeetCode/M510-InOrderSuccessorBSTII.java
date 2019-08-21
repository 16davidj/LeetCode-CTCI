/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/inorder-successor-in-bst-ii/

Description:
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

The successor of a node p is the node with the smallest key greater than p.val.

You will have direct access to the node but not to the root of the tree. Each node will have a
reference to its parent node.

Solution:
The successor will always be the leftmost child of the right subtree. However, if a right subtree
doesn't exist, then we are done with the in-order traversal (left, current, right), and we go up
to the parent. If the node was the left-child, then we return the parent, as the next node you
view is the current, or parent. If the node was the right-child, then you keep moving up until the
node is no longer the right child of the parent.

Runtime:
Space Complexity: O(1)
Runtime Complexity: O(log n): you usually run through the height of the tree, which
worst case will be O(n).
*/

public Node inorderSuccessor(Node x) {
  //find leftmost of right subtree
  if(x.right != null) {
    Node right = x.right;
    Node leftmost = right.left;
    if(leftmost != null) {
        while(leftmost.left != null) {
            leftmost = leftmost.left;
        }
        return leftmost;
    } else {
        return right;
    }
  } else {
    //if right subtree doesn't exist, go up until you the node is no longer the right child,
    //so in in-order traversal, you have left the right subtree recursive path, then return the
    //parent
    {
      while(x.parent != null && x != x.parent.left) {
        x = x.parent;
      }
      return x.parent;
    }
  }
}
