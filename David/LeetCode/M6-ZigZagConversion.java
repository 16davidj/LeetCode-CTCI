/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/zigzag-conversion/

Description: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows
like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

Solution: Go through the string character by character, but change the row accordingly every
iteration.

Runtime: O(n)

Space Complexity: O(n)

*/

public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        List<StringBuilder> arr = new ArrayList<>();
        int curr = 0;
        boolean reverse = false;
        for(int i = 0; i < numRows; i++) {
            arr.add(new StringBuilder());
        }
        for(char c : s.toCharArray()) {
            StringBuilder sb;
            arr.get(curr).append(c);
            if(!reverse) {
                curr++;
            } else {
                curr--;
            }
            if(curr == numRows - 1 || curr == 0) {
                reverse = !reverse;
            }
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder sb : arr) {
            result.append(sb.toString());
        }
        return result.toString();
    }
