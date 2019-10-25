/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/rotated-digits/

Description:
X is a good number if after rotating each digit individually by 180 degrees, we get a valid number
that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2
and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate
to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation:
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
Note:

N  will be in range [1, 10000].

Solution:
This is a dp-solution. Essentially, you can break the number N down to it's rightmost digit and
the rest. If both are valid and same, then the entire number is valid and same after rotation.
However, if it's some combo of valid and same and valid and not same, then the number is just Valid
Lastly, if it's neither, then you just set it equal to 0.

Runtime: O(n) to create the DP Array

Space Complexity: O(n): you create a N-size DP-array

*/

class Solution {
    public int rotatedDigits(int N) {
      //0 is invalid, 1 is valid and same, 2 is valid and not same
      int[] dp = new int[N + 1];
      int count = 0;
      for(int i = 0; i <= N; i++) {
        if(i == 0 || i == 1 || i == 8) {
          dp[i] = 1;
        } else if(i == 2 || i == 5 || i == 6 || i == 9) {
          dp[i] = 2;
          count++;
        } else {
          int remain = i / 10;
          int rightmost = i % 10;
          if(dp[remain] == 1 && dp[rightmost] == 1) {
            dp[i] = 1;
          } else if(dp[remain] >= 1 && dp[rightmost] >= 1) {
            dp[i] = 2;
            count++;
          } else if(dp[remain] == 0 || dp[rightmost] == 0) {
            dp[i] = 0;
          }
        }
      }
      return count;
    }
}
