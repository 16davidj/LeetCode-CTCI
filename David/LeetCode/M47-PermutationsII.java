/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/permutations-ii/

Description:
Given a collection of numbers that might contain duplicates, return all possible unique
permutations.

Solution: Very similar to M78-SubsetsII, where you have to skip a number if you've previously
skipped that same duplicate number. Note you have to sort the array first.

Runtime: O(2 ^ n), since we have 2 ^ n possibilities about the element, for every element we can
choose or not choose, thus it is 2 ^ n
Space complexity: O(n)

*/

public List<List<Integer>> permuteUnique(int[] nums) {
  List<List<Integer>> result = new ArrayList<List<Integer>>();
  Arrays.sort(nums);
  helper(result, new ArrayList<Integer>(), new boolean[nums.length], nums);
  return result;
}

public void helper(List<List<Integer>> result, List<Integer> tempList, boolean[] used, int[] nums) {
  if(tempList.size() == nums.length) {
    result.add(new ArrayList<Integer> (tempList));
  } else {
    for(int i = 0; i < nums.length; i++) {
      //if there is a duplicate number in front of you and you already skipped it, skip this one
      //as well. Otherwise, you can use it, unless you used it in a previous recursive call.
      //if you skip, skip all of the same ones
      //cannot start a list with the same number, especially if you skipped it
      //this if-statement looks different because you can go backwards and use values at smaller
      //indices, as you have to use all values
      if(used[i] || (i > 0 && !used[i-1] && nums[i] == nums[i-1])) {
        continue;
      }
      //choose
      used[i] = true;
      tempList.add(nums[i]);
      helper(result, tempList, used, nums);
      //unchoose
      used[i] = false;
      tempList.remove(tempList.size() - 1);
    }
  }
}
