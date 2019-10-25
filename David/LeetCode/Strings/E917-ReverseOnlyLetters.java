/*
Difficulty: Easy
Problem Link:https://leetcode.com/problems/reverse-only-letters/

Description:
Given a string S, return the "reversed" string where all characters that are not a letter stay in
the same place, and all letters reverse their positions.



Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122
S doesn't contain \ or "

Solution: Use pointers from begin and end to check for if it is a valid letter, then swap them.


Runtime: O(n)

Space Complexity: O(1)

*/

public String reverseOnlyLetters(String S) {
        int begin = 0;
        int end = S.length() - 1;

        char [] chArr = S.toCharArray();

        while(begin < end) {
            if(!Character.isLetter(chArr[begin])) {
                begin++;
            } if(!Character.isLetter(chArr[end])) {
                end--;
            }
            if(Character.isLetter(chArr[begin]) && Character.isLetter(chArr[end])) {
                char temp = chArr[begin];
                chArr[begin] = chArr[end];
                chArr[end] = temp;
                begin++;
                end--;
            }
        }
        return new String(chArr);
    }
