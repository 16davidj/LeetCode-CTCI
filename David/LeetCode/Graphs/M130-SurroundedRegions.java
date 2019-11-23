/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/surrounded-regions/

Description:
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board
are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the
border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected
horizontally or vertically.

Solution:
Union Find

Runtime: O(n), where n is the amount of objects.

Space Complexity: O(m*n)

*/

class Solution {
    public void solve(char[][] board) {
        if(board.length == 0) {
            return;
        }
        int[] roots = new int[board.length*board[0].length + 1];
        for(int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        int out = board.length*board[0].length;
        for(int i = 0; i < board[0].length; i++) {
            if(board[0][i] == 'O') {
                union(roots, i, out);
            }
            if(board[board.length - 1][i] == 'O') {
                union(roots, (board.length-1) * board[0].length + i, out);
            }
        }
        for(int j = 0; j < board.length; j++) {
            if(board[j][0] == 'O') {
                union(roots, j*board[0].length, out);
            }
            if(board[j][board[0].length - 1] == 'O') {
                union(roots, j*board[0].length + board[0].length - 1, out);
            }
        }

        for(int i = 1; i < board.length - 1; i++) {
            for(int j = 1; j < board[0].length - 1; j++) {
                int index = i*board[0].length + j;
                if(board[i][j] == 'O') {
                    if(board[i][j-1] == 'O') {
                        union(roots, index, i*board[0].length + j-1);
                    }
                    if(board[i-1][j] == 'O') {
                        union(roots, index, (i-1)*board[0].length + j);
                    }
                    if(board[i+1][j] == 'O') {
                        union(roots, index, (i+1)*board[0].length + j);
                    }
                    if(board[i][j+1] == 'O') {
                        union(roots, index, i*board[0].length + j+1);
                    }
                }
            }
        }

        for(int i = 1; i < board.length - 1; i++) {
            for(int j = 1; j < board[0].length - 1; j++) {
                int index = i*board[0].length + j;
                if(board[i][j] == 'O' && !connected(roots, index, out)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public boolean connected(int[] roots, int valX, int valY) {
        return find(roots, valX) == find(roots, valY);
    }

    public void union(int[] roots, int valX, int valY) {
        int rootX = find(roots, valX);
        int rootY = find(roots, valY);
        if(rootX != rootY) {
            roots[rootX] = roots[rootY];
        }
    }

    public int find(int[] roots, int val) {
        while(roots[val] != val) {
            int temp = roots[val];
            roots[val] = roots[temp];
            val = temp;
        }
        return val;
    }
}
