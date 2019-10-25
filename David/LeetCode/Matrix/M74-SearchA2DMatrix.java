/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/search-a-2d-matrix/

Description:
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the
following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Solution:
Pretty much modified binary search for a 2D-matrix

Runtime: O(log(mn))

Space Complexity: O(1)

*/

public boolean searchMatrix(int[][] matrix, int target) {
  if(matrix.length == 0) {
    return false;
  }
  int lo = 0;
  int hi = (matrix.length * matrix[0].length) - 1;
  while(lo <= hi) {
    int mid = (lo + hi)/2;
    int row = (mid/matrix[0].length);
    int col = (mid % (matrix[0].length));
    if(matrix[row][col] == target) {
      return true;
    } else if(matrix[row][col] < target) {
      lo = mid + 1;
    } else {
      hi = mid - 1;
    }
  }
  return false;

}
