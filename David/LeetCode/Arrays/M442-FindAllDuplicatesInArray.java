/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/

Description: Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear
twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

Solution: The basis in the solution lies within the constraints, 1 ≤ a[i] ≤ n (n = size of array),
meaning that each value in the array can map to an index within the array. Since we want O(1)
space complexity, you want to be able to keep the original value, while also indicating if
a value has already been used. Since a[i] is between 1 and n, we use index i-1 to indicate if i
has been used. We set it to negative if the value of i has been already used. Of course, this
negative value shouldn't affect if the object at the index i-1 has been used, so you take
Math.abs when finding if the value at index - 1 has been used.

Runtime: O(n)

Space Complexity: O(1)

*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
      List<Integer> res = new ArrayList<Integer>();
      for(int i = 0; i < nums.length; i++) {
        int index = Math.abs(nums[i]) - 1;
        if(nums[index] < 0) {
          res.add(index + 1);
        } else {
          nums[index] = -1 * nums[index];
        }
      }
      return res;
    }
}
