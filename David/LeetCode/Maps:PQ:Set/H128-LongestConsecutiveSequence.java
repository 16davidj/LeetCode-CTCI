/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/

Description:
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Solution:
You can do this three ways. This solution is the first way
1) map: The solution below. You have three scenarios. When you add a number, the surrounding two
could have already been added, so you add to the ends of the chain, since adding to the middle of
the chain doesn't affect how long it is.

If only one chain in one direction exists, do the same thing

If there is no chain, just add the number and 1

2) Set: place everything in a set, and only start from counting the chain from the beginning of the
set, meaning if you have placed in 1, 2, 3, 4, you only start the count when !set.contains(n-1),
meaning you start at 1 only, and go from there.

3) union-find: use union-find, with the indices being the nodes, and then go through the indices
and find the root with the most indices

Runtime: O(n)

Space Complexity: O(n)

*/

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> seqCount = new HashMap<>(); //map from value to longest sequence
        int longest = 0;
        for(int num : nums) {
          if(seqCount.containsKey(num)) {
              continue;
          }
          int total = 1;
          Integer lowSeq = seqCount.get(num - 1);
          Integer hiSeq = seqCount.get(num + 1);
          if(lowSeq != null && hiSeq != null) {
            total += lowSeq + hiSeq;
            seqCount.put(num - lowSeq, total);
            seqCount.put(num + hiSeq, total);
          } else if(lowSeq != null) {
            total += lowSeq;
            seqCount.put(num - lowSeq, total);
          } else if(hiSeq != null) {
            total += hiSeq;
            seqCount.put(num + hiSeq, total);
          }
          longest = Math.max(longest, total);
          seqCount.put(num, total);
        }
        return longest;
    }
}
