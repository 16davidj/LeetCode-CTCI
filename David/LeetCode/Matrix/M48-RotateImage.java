/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/rotate-image/

Description:
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Solution: See the notebook for the solution. The point of this is to rotate clockwise accordingly.
For the first row, you go left to right with [first][j]. For the left, first column that replaces
the first row, you go bottom to up to replace the first row left to right, which is
[end - offset][first] (you need offset because the start is not always index 0). Then you want
to replace the left column with the bottom row, which goes from right to left, making it
[end][end - offset], then you want to replace the bottom with the right column top to bottom, so
its the same order, so its, [j][end]. Moreover, you want to do j = first; j < end in the for loop
because the corners are technically part of both a row and column twice, so you don't want to
change it twice.

Solution II: (Updated 10.26): You want to think about layer as being the fixed part of the
rotate part, it only changes where you start or end. j is the one that's always changing.
j should start at layer and end matrix.length - 1 - layer because of the offset/layering

*/
class Solution {
    public void rotate(int[][] matrix) {
  if(matrix.length == 0) {
    return; //base case
  }

  int layers = matrix.length/2; //dimension of n
  for(int layer = 0; layer < layers; layer++) { //layer doesn't change
    for(int j = layer; j < matrix.length - 1 - layer; j++) {
      int temp = matrix[layer][j];
      matrix[layer][j] = matrix[matrix.length - 1 - j][layer];
      matrix[matrix.length - 1 - j][layer] = matrix[matrix.length - 1 - layer][matrix.length - 1 - j];
      matrix[matrix.length - 1 - layer][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - layer];
      matrix[j][matrix.length - 1 - layer] = temp;
    }
  }
}
}
