/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/set-matrix-zeroes/

Description:
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Solution:
0 out the matrix by using the first row and column as flags to see if the rows or columsn have 0.
First check if the first row or columns have zeros before you modify them. Then, search the Matrix
from the second row and second column for zeros and set the first row and column as 0's. Note that
we don't have to iterate to 0,0 when setting the elements to 0, 0 because if 0,0 was 0, then
firstRowZero or firstColZero would've detected it, and if firstRowzero or firstColZero was 0, it
would've been changed later when we set the first column or row to zero.

Runtime: O(N) in terms of matrix having N elements
Space: O(1), do it in place.


*/

public void setZeroes(int[][] matrix) {
  if(matrix.length == 0) {
    return;
  };

  boolean firstRowZero = false;
  for(int i = 0; i < matrix[0].length; i++) {
    if(matrix[0][i] == 0) {
      firstRowZero = true;
      break;
    }
  }

  boolean firstColZero = false;
  for(int j = 0; j < matrix.length; j++) {
    if(matrix[j][0] == 0) {
      firstColZero = true;
      break;
    }
  }

  for(int i = 1; i < matrix.length; i++) {
    for(int j = 1; j < matrix[0].length; j++) {
      if(matrix[i][j] == 0) {
        matrix[i][0] = 0;
        matrix[0][j] = 0;
      }
    }
  }

  for(int i = 1; i < matrix[0].length; i++) {
    if(matrix[0][i] == 0) {
      for(int j = 1; j < matrix.length; j++) {
        matrix[j][i] = 0;
      }
    }
  }

  for(int j = 1; j < matrix.length; j++) {
    if(matrix[j][0] == 0) {
      for(int i = 1; i < matrix[j].length; i++) {
        matrix[j][i] = 0;
      }
    }
  }

  if(firstRowZero) {
    for(int i = 0; i < matrix[0].length; i++) {
      matrix[0][i] = 0;
    }
  }

  if(firstColZero) {
    for(int j = 0; j < matrix.length; j++) {
      matrix[j][0] = 0;
    }
  }

}
