/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/inorder-successor-in-bst/

Description: Given a binary search tree and a node in it, find the in-order successor of that node
in the BST.

The successor of a node p is the node with the smallest key greater than p.val.

Solution:
Breakdown: if root is equal to p, then you find the leftmost of the right subtree, as that is
the successor. if p's val is greater than the root's val, so then we call the function recursively
on the right side. if p's val is less than the root's val, then two things happen. We call
the leftmost on the right subtree, and if it is not equal to null, that means we know a successor
exists, and we return that. However, if it is null, then we populate that up to the root where
it is the highest root where we started the left side of the in order traversal, and return that.

Runtime:
Space Complexity: O(log n), you have log n recursive calls
Runtime Complexity: O(log n): worst case, you go through the height of the tree
*/

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
  if(root == p) {
    return leftmostRightTree(root);
  } else if(p.val > root.val) {
    return inorderSuccessor(root.right, p);
  } else {
    TreeNode leftmost = inorderSuccessor(root.left, p);
    if(leftmost == null) {
      return root;
    } else {
      return leftmost;
    }
  }
}

public TreeNode leftmostRightTree(TreeNode root) {
  TreeNode right = root.right;
  if(right != null) {
    TreeNode leftmost = right;
    while(leftmost.left != null) {
      leftmost = leftmost.left;
    }
    return leftmost;
  }
  return right;
}
