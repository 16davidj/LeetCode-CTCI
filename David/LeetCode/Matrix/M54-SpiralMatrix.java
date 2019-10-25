/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/spiral-matrix/

Description:
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in
spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Solution:
Keep track of the top, left-most cell, and the bottom, right-most cell. If the top, left-most
cell has coordinates that has the top < bottom or left to the right of the right-most cell, then
you have finished searching. Go in a spiral order, it's pretty intuitive.


Runtime: O(mn), you have to iterate through every value

Space Complexity: O(mn), the list will be mn long

*/

public List<Integer> spiralOrder(int[][] matrix) {
  List<Integer> spiral = new ArrayList<Integer>();
  int left = 0;
  int top = 0;
  if(matrix.length == 0) {
    return spiral;
  }
  int right = matrix[0].length - 1;
  int bottom = matrix.length - 1;

  while(left <= right && top <= bottom) {
    //do spiral, split it into 4 steps
    for(int i = left; i <= right; i++) {
      spiral.add(matrix[top][i]);
    }
    for(int i = top + 1; i <= bottom; i++) {
      spiral.add(matrix[i][right]);
    }
    if(top != bottom) { //if top = bottom, don't go back the same way, since it's the same nums
        for(int i = right - 1; i >= left; i--) {
            spiral.add(matrix[bottom][i]);
        }
    }
    if(left != right) { //same comment as above, but for left and right
        for(int i = bottom - 1; i > top; i--) {
            spiral.add(matrix[i][left]);
        }
    }
    left++;
    top++;
    right--;
    bottom--;
  }
  return spiral;
}
