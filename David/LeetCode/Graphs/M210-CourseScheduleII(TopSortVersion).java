/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/course-schedule-ii/

Description: There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses
you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to
finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished
both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read
more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

Solution:

Runtime: O(n) for all nodes


Space Complexity: O(n) for al nodes

*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      Map<Integer, List<Integer>> graph = new HashMap<>();
      for(int[] edge : prerequisites) {
        if(graph.get(edge[1]) == null) {
          List<Integer> dependents = new LinkedList<Integer>();
          dependents.add(edge[0]);
          graph.put(edge[1], dependents);
        } else {
          graph.get(edge[1]).add(edge[0]);
        }
      }

      Stack<Integer> order = new Stack<>();
      boolean[] visited = new boolean[numCourses];
      for(int i = 0; i < numCourses; i++) {
        if(!visited[i]) {
          if(!topSortDFS(graph, order, visited, new boolean[numCourses], i)) {
            return new int[0];
          }
        }
      }
      int[] res = new int[numCourses];
      int index = 0;
      while(order.size() > 0) {
        res[index] = order.pop();
        index++;
      }
      return res;
    }

//currVisited is a temporary array that keeps track of what nodes you've visited in this current
//recursion call, so it checks for cycles
    private boolean topSortDFS(Map<Integer, List<Integer>> graph, Stack<Integer> order, boolean[] visited, boolean[] currVisited, int node) {
      visited[node] = true;
      if(graph.get(node) == null) {
        order.push(node);
        return true;
      } else {
        currVisited[node] = true;
        for(int dependent : graph.get(node)) {
          if(currVisited[dependent]) {
            return false;
          }
          if(!visited[dependent]) {
            if(!topSortDFS(graph, order, visited, currVisited, dependent)) {
              return false;
            }
          }
        }
        currVisited[node] = false;
        order.push(node);
      }
      return true;
    }
}
