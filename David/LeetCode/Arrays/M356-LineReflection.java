/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/line-reflection/

Description: Given n points on a 2D plane, find if there is such a line parallel to y-axis that
reflect the given points.

Example 1:

Input: [[1,1],[-1,1]]
Output: true
Example 2:

Input: [[1,1],[-1,-1]]
Output: false
Follow up:
Could you do better than O(n2) ?

Solution: The basis of this solution is that for a line to exist, the line must be at the position
of (minX + maxX)/2. Then, you just check the existence of certain points by using a hashSet. The
second solution is more efficient because you don't need to take the reflection with double, you
can just subtract fromt he sum and search for it.

Runtime: O(n)

Space Complexity: O(n)

*/

class Solution {
    public boolean isReflected(int[][] points) {
        if(points.length == 0) {
            return true;
        }
        Set<String> pts = new HashSet<>();
        Integer minX = null;
        Integer maxX = null;
        Double mid = null;
        for(int[] point : points) {
            if(minX == null && maxX == null) {
                minX = point[0];
                maxX = point[0];
            } else {
                minX = Math.min(minX, point[0]);
                maxX = Math.max(maxX, point[0]);
            }
            String strPt = (double) point[0] + "," + (double) point[1];
            pts.add(strPt);
        }
        mid = (minX + maxX)/2.0;
        for(int[] point : points) {
            double reflX = 0.0;
            if(point[0] >= mid) {
                reflX = mid - (point[0] - mid);
            } else {
                reflX = mid + (mid - point[0]);
            }
            String reflPt = reflX + "," + (double) point[1];
            if(!pts.contains(reflPt)) {
                return false;
            }
        }
        return true;
    }
}

//cleaner version

class Solution {
    public boolean isReflected(int[][] points) {
        if(points.length == 0) {
            return true;
        }
        Set<String> pts = new HashSet<>();
        Integer minX = null;
        Integer maxX = null;
        Integer sum = null;
        for(int[] point : points) {
            if(minX == null && maxX == null) {
                minX = point[0];
                maxX = point[0];
            } else {
                minX = Math.min(minX, point[0]);
                maxX = Math.max(maxX, point[0]);
            }
            String strPt = point[0] + "," + point[1];
            pts.add(strPt);
        }
        sum = minX + maxX;
        for(int[] point : points) {
            String reflPt = (sum - point[0]) + "," + point[1];
            if(!pts.contains(reflPt)) {
                return false;
            }
        }
        return true;
    }
}
