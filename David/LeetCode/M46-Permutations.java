/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/permutations/

Description: Given a collection of distinct integers, return all possible permutations.

Solution: Similar to Subsets solution , except you don't keep track of the index you're currently
on, because you want to start over, because in permutations, you want to include all the numbers.
Thus, you use a hashSet to keep track of what has been put in the list, and skip those if they
already are in there (the values are distinct)

Runtime: O(2 ^ n), since we have 2 ^ n possibilities about the element, for every element we can
choose or not choose, thus it is 2 ^ n
Space complexity: O(n)

*/

public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(result, new ArrayList<Integer>(), new HashSet<Integer>(), nums);
    return result;
}

public void helper(List<List<Integer>> result, List<Integer> tempList, Set<Integer> set, int[] nums)
{
  if(tempList.size() == nums.length) {
    result.add(new ArrayList<Integer>(tempList));
  } else {
    for(int i = 0; i < nums.length; i++) {
      if(!set.contains(nums[i])) {
        tempList.add(nums[i]);
        set.add(nums[i]);
        helper(result, tempList, set, nums);
        tempList.remove(tempList.size() - 1);
        set.remove(nums[i]);
      }
    }
  }
}
