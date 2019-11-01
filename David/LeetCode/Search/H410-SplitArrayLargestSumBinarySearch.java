/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/split-array-largest-sum/

Description: Given an array which consists of non-negative integers and an integer m, you can split
the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum
among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

Solution: the smallest the max sum can be is the max value in the array, and the largest it can be
is the sum of the array. Thus, we know that there is a value within the bounds that is the maxSum,
so we do binary search, and for every value, we see if it validly creates an array with m subArrays

If we can't, that means the limit we set is too low. If it can, we try to lower the limit.

Runtime: O(n log (sum of array))

Space Complexity: O(1)

*/

class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        long lo = (long) max;
        long hi = (long) sum;

        while(lo < hi) {
            long mid = (lo + hi)/2;
            if(valid(nums, mid, m)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return (int) lo;
    }

    private boolean valid(int[] nums, long bound, int m) {
        int count = 1;
        long tempSum = 0;
        for(int num : nums) {
            tempSum += (long) num;
            if(tempSum > bound) {
                tempSum = (long) num;
                count++;
                if(count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
