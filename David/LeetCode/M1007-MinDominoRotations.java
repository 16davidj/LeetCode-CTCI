/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

Description:
In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A
domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values
in B are the same.

If it cannot be done, return -1.

Solution: Originally solved with a hashSet and two iterations. However, you can just take
A[0] and B[0] and see how many of the A[i] and B[i] match these, then you can find how many
rotations you need.

Runtime: O(n)

Space Complexity: O(1)

*/

public int minDominoRotations(int[] A, int[] B) {
        int a = A[0];
        int b = B[0];
        int countA = 1;
        int countB = 1;
        for(int i = 1; i < A.length; i++) {
            if(A[i] == a || B[i] == a) {
                countA++;
            }
            if(A[i] == b || B[i] == b) {
                countB++;
            }
        }
        int val = -1;
        if(countA == A.length) {
            val = a;
        } else if(countB == B.length) {
            val = b;
        }
        if(val == -1) {
            return -1;
        }
        int flipsA = 0;
        int flipsB = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == val && B[i] != val) {
                flipsA++;
            }
            if(B[i] == val && A[i] != val) {
                flipsB++;
            }
        }
        return Math.min(Math.min(A.length - flipsA, flipsA), Math.min(A.length - flipsB, flipsB));
    }
