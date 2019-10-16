/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/bulls-and-cows/

Description: You are playing the following Bulls and Cows game with your friend: You write down a
number and ask your friend to guess what the number is. Each time your friend makes a guess, you
provide a hint that indicates how many digits in said guess match your secret number exactly in
both digit and position (called "bulls") and how many digits match the secret number but locate in
the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually
derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to
indicate the bulls and B to indicate the cows.

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their
lengths are always equal.

Solution:
Essentially, you want to separate the cows and bulls. Bulls are when two numbers are the same
in the same position. However, cows is different, so you keep a count of cow numbers in numsSecret
and numsGuess (you don't want to double count the cows). Then, you find the min between the counts
for each number, since that is the max that you can have in common for a single number.

Runtime: O(n)

Space Complexity: O(1), you create two arrays of size 10

*/

class Solution {
    public String getHint(String secret, String guess) {
        int[] numsSecret = new int[10];
        int[] numsGuess = new int[10];
        int ABull = 0;
        int BCow = 0;
        for(int i = 0; i < secret.length(); i++) {
            int x = secret.charAt(i) - '0';
            int y = guess.charAt(i) - '0';
            if(x == y) {
              ABull++;
            } else {
              numsSecret[x]++;
              numsGuess[y]++;
            }
        }
        for(int i = 0; i < numsGuess.length; i++) {
            BCow += Math.min(numsGuess[i], numsSecret[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ABull);
        sb.append('A');
        sb.append(BCow);
        sb.append('B');
        return sb.toString();
    }
}
