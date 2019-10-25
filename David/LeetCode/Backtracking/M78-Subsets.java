/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/subsets/

Description: Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Solution: Backtracking problem, pretty intuitive, see theh comment about adding a clone of the
current tempList.


Runtime: O(2 ^ n), since we have 2 ^ n possibilities about the element, for every element we can
choose or not choose, thus it is 2 ^ n
Space complexity: O(n)

*/

public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(result, new ArrayList<Integer>(), nums, 0);
    return result;
}

public void helper(List<List<Integer>> result, List<Integer> tempResult, int[] nums, int start) {
    result.add(new ArrayList<Integer>(tempResult)); //make a clone because if you just add
    //tempResult, because you're adding the reference to it, the remove call will eventually
    //cause you to just have a list of empty lists
    for(int i = start; i < nums.length; i++) {
        tempResult.add(nums[i]);
        helper(result, tempResult, nums, i+1);
        tempResult.remove(tempResult.size() - 1); //backtracking for the next index in the array
    }
}
