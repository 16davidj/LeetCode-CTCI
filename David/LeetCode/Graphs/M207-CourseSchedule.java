/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/course-schedule/

Description:
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to
finish all courses?

Solution: It's a DFS. Essentially, you create a HashMap<Integer, List<Integer>> that represents
the prereqs. Then, you have to go through each course and make sure that it can be taken
given the prereqs. You want to track whether or not you can take the course given the prereqs
by seeing if there is a cycle within the prereqs, and this is done using the visited array.
If one of the courses in the prereqs has already been visited, then the course can't be taken,
b/c that course that has been visited is already a pre-requisite. (Draw it out)

Runtime: O(n^2): see recursive call and for loop within the recursive call.

Space Complexity:
O(n): you're recreating hte prerequisites 2-d array with a hashMap.

*/

public boolean canFinish(int numCourses, int[][] prerequisites) {
  Map<Integer, List<Integer>> prereqs = new HashMap<>();
  for(int[] arr : prerequisites) {
    if(prereqs.get(arr[0]) == null) {
      List<Integer> list = new ArrayList<Integer>();
      list.add(arr[1]);
      prereqs.put(arr[0], list);
    } else {
      prereqs.get(arr[0]).add(arr[1]);
    }
  }
  for(int course : prereqs.keySet()) {
    int[] visited = new int[numCourses];
    if(!helper(prereqs, visited, course)) {
      return false;
    }
  }
  return true;
}

public boolean helper(Map<Integer, List<Integer>> prereqs, int[] visited, int course) {
  List<Integer> reqs = prereqs.get(course);
  if(reqs == null) {
    return true;
  }
  if(visited[course] == 1) {
    return false;
  } else {
    visited[course] = 1;
    for(int reqCourse : reqs) {
      if(!helper(prereqs, visited, reqCourse)) {
        return false;
      }
    }
    visited[course] = 0; //backtracking, you don't want the first case you visit a course
    //recursively to be set to 1 and stay there, since the array visited will be updated at
    //each recursive level.
  }
  return true;
}
