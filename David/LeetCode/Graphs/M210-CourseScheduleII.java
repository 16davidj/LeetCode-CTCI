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
You want to find out the nodes with 0 dependencies on them and remove them from the graph and
keep finding nodes with 0 in-degree. However, it's not easy to find the nodes that have a node
with 0 dependencies, so you just reverse it. This way, when you remove a node with 0 dependencies
(keep track of this in an array), you can easily remove the depending nodes and remove them
from the dependency count array. Lastly, because you can't remove multiple nodes at once, store
the nodes with 0 dependencies in a queue.

Runtime: O(n), process every node, but subtracting from depenCount and adding to Queue are


Space Complexity: O(E + N), you have a map with E edges and a Queue to keep N nodes

*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> reverseGraph = new HashMap<>();
        int[] depenCount = new int[numCourses];
        Queue<Integer> zeroDependencies = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = 0;

        for(int[] edge : prerequisites) {
          if(reverseGraph.get(edge[1]) == null) {
            List<Integer> revDep = new LinkedList<>();
            revDep.add(edge[0]);
            reverseGraph.put(edge[1], revDep);
            depenCount[edge[0]]++;
          } else {
            reverseGraph.get(edge[1]).add(edge[0]);
            depenCount[edge[0]]++;
          }
        }

        for(int i = 0; i < depenCount.length; i++) {
          if(depenCount[i] == 0) {
            zeroDependencies.add(i);
          }
        }
        while(zeroDependencies.size() > 0) {
          int remove = zeroDependencies.poll();
          result[index] = remove;
          index++;
          if(reverseGraph.get(remove) == null) {
              continue;
          }
          for(int dependents : reverseGraph.get(remove)) {
            depenCount[dependents] -= 1;
            if(depenCount[dependents] == 0) {
              zeroDependencies.add(dependents);
            }
          }
        }
        if(index == numCourses) {
          return result;
        }
        return new int[0];
    }
}
