/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/combination-sum/

Description: Given a set of candidate numbers (candidates) (without duplicates) and a target number
(target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Solution: Similar to M78-Subsets and M46-Permutations, except that you want to hit a certain
target, so when you recurse down with the helper, you want to subtract that value from target.
Also, keep in mind that it is the solution set, so [2, 2, 3] = 7 is the same as the answer
[3, 2, 2]. The way you avoid this is sorting the array and then keeping the start index on
the current one, not restarting from the front. You also don't want to do i+1 because you're
allowed to use the same element twice.

Runtime: O(2 ^ n), since we have 2 ^ n possibilities about the element, for every element we can
choose or not choose, thus it is 2 ^ n
Space complexity: O(n)

*/

public List<List<Integer>> combinationSum(int[] candidates, int target) {
  List<List<Integer>> result = new ArrayList<List<Integer>>();
  Arrays.sort(candidates);
  helper(result, new ArrayList<Integer>(), candidates, target, 0);
  return result;
}

public void helper(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int start) {
  if(target == 0) {
    result.add(new ArrayList<Integer>(tempList));
  } else if(target < 0) {
    return;
  } else {
    for(int i = start; i < candidates.length; i++) {
      tempList.add(candidates[i]);
      target -= candidates[i];
      helper(result, tempList, candidates, target, i);
      target += candidates[i];
      tempList.remove(tempList.size() - 1);
    }
  }
}
