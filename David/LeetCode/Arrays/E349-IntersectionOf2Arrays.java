/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/intersection-of-two-arrays/

Description: Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.

Solution:
Use a hashmap to keep track of repeated values.

However, if the constraint is that you want O(n) runtime and O(1) space, and the arrays are sorted,
treat this problem as a linked list problem (where you merge two linked lists). Keep two pointers,
and keep track of whether the pointers are equal to each other. If they are, add the value to the
list and increment both. If one is less than another, the lesser index.


Runtime: O(n + m)

Space Complexity: O(n): The HashMap will only be as big as all the elements in nums1

*/

public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums1) {
            if(map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }

        for(int y : nums2) {
            if(map.containsKey(y) && map.get(y) > 0) {
                list.add(y);
                map.put(y, map.get(y) - 1);
            } else if(map.containsKey(y) && map.get(y) == 0) {
                map.remove(y);
            }
        }
        int [] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
