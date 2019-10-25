/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/search-a-2d-matrix-ii/

Description:
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the
following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Solution:
Start from either top right or bottom left. This is because at each iteration, it's kind of like
binary search, where you need to search either half if the target is greater or less than what
you are right now. With top-right or bottom-left, you can go either less or more (for bottom left,
going right will increase your value, going up with decrease it). You need it to be either or to
reduce the matrix because if you to bottom right, the problem is that you'll always be decreasing
and from the top left, you'll always be increasing.

Bottom-left: If target is less, then go up. If target is more, go right.

Runtime: O(m + n): worst case, you start from the bottom left, and you have to find the element
that is located top right.

Space Complexity: O(1)
*/

public boolean searchMatrix(int[][] matrix, int target) {
  int rows = matrix.length;
  if(rows == 0) {
    return false;
  }
  int cols = matrix[0].length;

  int i = rows - 1;
  int j = 0;

  while(i < rows && j < cols && i >= 0 && j >= 0) {
    if(matrix[i][j] == target) {
      return true;
    } else if(matrix[i][j] < target) {
      j++;
    } else {
      i--;
    }
  }
  return false;
}
