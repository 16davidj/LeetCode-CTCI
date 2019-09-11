/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/combination-sum-ii/

Description: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Solution: Backtracking problem, pretty intuitive, see theh comment about adding a clone of the
current tempList. (See comments to why it's different from the rest)

Runtime: O(2 ^ n), since we have 2 ^ n possibilities about the element, for every element we can
choose or not choose, thus it is 2 ^ n
Space complexity: O(n)

*/

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
      //if you skip a number, skip all the same ones, you can't go backwards to smaller indices,
      //as you don't need to use all the numbers
      if(i > start && candidates[i] == candidates[i - 1]) {
        continue;
      }
      tempList.add(candidates[i]);
      target -= candidates[i];
      helper(result, tempList, candidates, used, target, i + 1); //i+1 bc each number can only be
      //used once
      target += candidates[i];
      tempList.remove(tempList.size() - 1);
    }
  }
}
