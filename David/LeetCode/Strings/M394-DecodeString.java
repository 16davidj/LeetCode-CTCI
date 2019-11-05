/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/decode-string/

Description: Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is
being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are
well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are
only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

Solution:
Make two stacks. One is the count, which will keep track of the repeat counts.
One is the strStack, which will keep track of the strings that were constructed before nested [].
Keep track of these strings with res, and reset res whenever you encounter a new bracket.

Break the behavior in the loop into four things

1) if it's a digit, completely parse it
2) if its an open bracket, that means we're starting a new str, so push the res onto the stack and
then reset it to "" (the number before should've already been pushed)
3) if its a closed bracket, that mean's we're done w the current string, so start the string w
the top of the stack, the repeat res x amount of times, where x is the top of the stack
4) if it's just a regular character, then just include it and move on

Runtime:

Space Complexity:

*/

class Solution {
    public String decodeString(String s) {
        int index = 0;
        Stack<Integer> countStk = new Stack<>();
        Stack<String> strStk = new Stack<>();
        char[] charArr = s.toCharArray();
        String res = "";
        while(index < charArr.length) {
            char val = charArr[index];
            if(Character.isDigit(val)) {
                int lead = 0;
                while(Character.isDigit(val)) {
                    lead = lead * 10 + Character.getNumericValue(val);
                    val = charArr[++index];
                }
                countStk.push(lead);
            } else if(val == '[') {
                strStk.push(res);
                res = "";
                index++;
            } else if(val == ']') {
                StringBuilder temp = new StringBuilder(strStk.pop());
                int repeat = countStk.pop();
                int i = 0;
                while(i < repeat) {
                    temp.append(res);
                    i++;
                }
                index++;
                res = temp.toString();
            } else {
                res += val;
                index++;
            }
        }
        return res;
    }
}
