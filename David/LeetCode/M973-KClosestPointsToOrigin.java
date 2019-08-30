/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/k-closest-points-to-origin/

Description:
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the
order that it is in.)

Solution:
very similar to M347, for the comparator, put the smallest at the end, to ensure that they
remain in the PQ when being popped from.

Runtime: O(n log k): The PQ is size k, so it will take n log k to add and poll

Space Complexity: O(k): the PQ is max size of k

*/
public class Point {
  int x;
  int y;
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public int[][] kClosest(int[][] points, int K) {
  int[][] results = new int[K][];
  PriorityQueue<Point> pq = new PriorityQueue<>(
    (a, b) -> a.x*a.x + a.y*a.y > b.x*b.x + b.y*b.y ? -1 : 1
  );
  for(int[] arr : points) {
    Point p = new Point(arr[0], arr[1]);
    pq.offer(p);
    if(pq.size() > K) {
      pq.poll();
    }
  }

  int index = 0;
  while(pq.size() > 0) {
    Point p = pq.poll();
    int[] point = new int[2];
    point[0] = p.x;
    point[1] = p.y;
    results[index] = point;
    index++;
  }
  return results;
}
