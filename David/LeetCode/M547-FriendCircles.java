/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/friend-circles/

Description: There are N students in a class. Some of them are friends, while some are not. Their
friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct
friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of
students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j]
= 1, then the ith and jth students are direct friends with each other, otherwise not. And you have
to output the total number of friend circles among all the students.

Example 1:
Input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.

Example 2:
Input:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1

Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct
friends, so the 0th and 2nd students are indirect friends. All of them are in the same friend
circle, so return 1.

Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.

Solution: This is basic DFS. You want to make a visited array for each person, but not each
visited connection. This is why the visited array is 1-d. You can imagine it as an adjacency
matrix, and you want to find how many groups there are of nodes. This means that the amount of
times you run dfs from the main function is how many groups there are, because that means there's
a disconnect starting from there. The visited array is not 2-d because you don't care about the
visited edges, rather, you care about visited each node.

Runtime: O(n^2), since you traverse the entire matrix

Space Complexity: O(n), for visited

*/

public int findCircleNum(int[][] M) {
  if(M.length == 0) {
    return 0;
  }
  int count = 0;
  int[] visited = new int[M.length];
  for(int i = 0; i < M.length; i++) {
    if(visited[i] == 0) {
      visited[i] = 1;
      dfs(M, visited, i);
      count++;
    }
  }
}

public void dfs(int[][] M, int[] visited, int curr) {
  for(int i = 0; i < M[curr].length; i++) {
    if(visited[i] == 0 && M[curr][i] == 1) {
      visited[i] = 1;
      dfs(M, visited, i);
    }
  }
}
