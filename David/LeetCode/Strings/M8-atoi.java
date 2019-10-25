/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/string-to-integer-atoi/

Description:

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-
whitespace character is found. Then, starting from this character, takes an optional initial plus
or minus sign followed by as many numerical digits as possible, and interprets them as a numerical
value.

The string can contain additional characters after those that form the integral number, which are
ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no
such sequence exists because either str is empty or it contains only whitespace characters, no
conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed
integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable
values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.

Solution:
Do everything in order. Trim the string so it has no whitespace beginning or ending. Then,
parse the negative sign and set the boolean. After that, get each number, and break if its not a
number. The way to get the numerical value from the char is to just subtract '0', as each
character that is a numeric character will be 0 to 9 away in the ascii table. Lastly, we want to
cover the case where the string is greater than INT min or max.

Runtime: O(n)

Space Complexity: O(1)

*/

public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        boolean negative = false;
        int index = 0;
        if(str.charAt(0) == '-' || str.charAt(0) == '+') {
            negative = str.charAt(0) == '-' ? true : false;
            index++;
        }

        int val = 0;
        while(index < str.length()) {
            int c = str.charAt(index) - '0';
            if(c >= 0 && c <= 9) {
                if(val > Integer.MAX_VALUE/10 || (val == Integer.MAX_VALUE/10 && c > Integer.MAX_VALUE%10)) {
                    if(negative) {
                        return Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE;
                }
                val = val * 10 + c;
                index++;
            } else {
                break;
            }
        }
        if(negative) {
            return 0 - val;
        }
        return val;
    }
