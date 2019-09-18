/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/factorial-trailing-zeroes/

Description: Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.

Solution: The basis of the solution is that the amount of trailing zeroes you have are from
how many times you multiply that number by 10 in the factorial. 10 is factored into 5 * 2, and
because you are guaranteed to have more factors of 2 than 5, you're essentially counting how
many times you have a factor of 5 in you number. In factorial n, you will have n/5 factors of 5,
because 5 comes up every 5 values. However, you also have to count 25 twice, 625 three times, etc.
Thus, you divide the number you have by 5 and then count again, and then again, as long as n
remains greater than 4. This is because dividing twice in two iterations of the loop is the
equivalent of dividing by 25. The first iteration, you counted the first 5 of the 25. You count the
second 5 in the second iteration.

Runtime: O(log n)

Space Complexity: O(1)

*/

public int trailingZeroes(int n) {
    int count = 0;
    while(n > 4) {
        count += n/5;
        n /= 5;
    }
    return count;
}
