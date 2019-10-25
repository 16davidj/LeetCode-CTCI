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


*/
public void rotate(int[][] matrix) {
  if(matrix.length == 0) {
    return; //base case
  }

  int layers = matrix[0].length/2; //dimension of n
  for(int layer = 0; layer < layers; layer++) {
    int first = layer;
    int end = matrix[0].length - 1 - layer;
    for(int j = first; j < end; j++) {
      int offset = j - first;
      int temp = matrix[first][j];
      matrix[first][j] = matrix[end - offset][first];
      matrix[end - offset][first] = matrix[end][end - offset];
      matrix[end][end - offset] = matrix[j][end];
      matrix[j][end] = temp;
    }
  }
}
