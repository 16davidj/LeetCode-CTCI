/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/strobogrammatic-number/

Description: A strobogrammatic number is a number that looks the same when rotated 180 degrees
(looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:

Input:  "69"
Output: true
Example 2:

Input:  "88"
Output: true
Example 3:

Input:  "962"
Output: false

Solution: Just check for specific cases

Runtime: O(n)

Space Complexity: O(1)

*/

class Solution {
    public boolean isStrobogrammatic(String num) {
        char [] charArr = num.toCharArray();
        int i = 0;
        int revIdx = charArr.length - 1;
        while(i <= revIdx) {
            int fwd = charArr[i] - '0';
            int rev = charArr[revIdx] - '0';
            System.out.println(fwd);
            System.out.println(rev);
            if(fwd == rev) {
                if(fwd != 0 && fwd != 1 && fwd != 8) {
                    return false;
                }
            } else if(fwd == 6) {
                if(rev != 9) {
                    return false;
                }
            } else if(fwd == 9) {
                if(rev != 6) {
                    return false;
                }
            } else {
                return false;
            }
            i++;
            revIdx--;
        }
        return true;
    }
}
