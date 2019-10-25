/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/subsets-ii/

Description: Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Solution: Backtracking problem, pretty intuitive, see theh comment about adding a clone of the
current tempList. (However, see comment about how its different than subsets.java)

Runtime: O(2 ^ n), since we have 2 ^ n possibilities about the element, for every element we can
choose or not choose, thus it is 2 ^ n
Space complexity: O(n)

*/
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    helper(result, new ArrayList<Integer>(), nums, 0);
    return result;
}

public void helper(List<List<Integer>> result, List<Integer> tempResult, int[] nums, int start) {
    result.add(new ArrayList<Integer>(tempResult)); //make a clone because if you just add
    //tempResult, because you're adding the reference to it, the remove call will eventually
    //cause you to just have a list of empty lists
    for(int i = start; i < nums.length; i++) {
        //note that the array must be sorted in order for this check to work
        //A good way to think about why this check works:
        //imagine [1,2,2, ...]
        //In the backtracking solution, let's say you're at index 1. You either skip 2 or choose 2.
        //If you choose 2, then you keep going. However, if you skip 2, you want to skip all the
        //2's, because if you skip the first 2 and choose the second 2, that's the same as
        //if you had chose the first 2 and skipped the second one. You either choose all of them,
        //chose one and skip the rest, or skip all of them
        //if you skip, skip all of the same ones
        //cannot start a list with the same number, especially if you skipped it
        if(i > start && nums[i] == nums[i - 1]) {
          continue;
        }
        tempResult.add(nums[i]);
        helper(result, tempResult, nums, i+1);
        tempResult.remove(tempResult.size() - 1); //backtracking for the next index in the array
    }
}
