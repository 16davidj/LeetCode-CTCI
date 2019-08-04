/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/two-sum/

Description:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Solution:

The trick is for the map, the keys represent the numbers in the array, and the values represent
their respective indices. This is because a HashMap cannot find the key of a certain value (which
we need to find the key of the complement for the array. Thus, we check if the number from the
array exists by using a map.)

    Runtime:
      Time Complexity: O(N^2): Worst-case, you have to iterate through all the values in the array,
      which is O(N), and each insertion to the map is O(N), if you have a bunch of collisions, the
      map degenerates into a linked-list. However, on average, this would be O(N), as insertions
      will usually be O(1).
      Space Complexity: O(N): Must make a map for all the values you iterate through


*/

public int[] twoSum(int[] nums, int target) {
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  for(int i = 0; i < nums.length; i++) {
    if(map.containsKey(target - nums[i])) {
      return new int[] {map.get(target - nums[i]), i };
    }
    map.put(nums[i], i);
  }
  return new int[]{};
}
