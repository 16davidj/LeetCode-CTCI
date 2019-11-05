/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/expressive-words/

Description: Sometimes people repeat letters to represent extra feeling, such as "hello" ->
"heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent
letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number
of applications of the following extension operation: choose a group consisting of characters c,
and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but
we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another
extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word
"hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -
> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy.

Example:
Input:
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation:
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.


Notes:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters

Solution: Use two pointers to check if it is stretchy. If the diff between i and j is > 2, then
it is stretchy. If it's not, you have to check that the regular one has the same difference, b/c
you can't stretch it

Runtime: O(w * N), where N is the length of each word, and w is the length of the words array

Space Complexity: O(1)

*/

class Solution {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for(String word : words) {
            if(isStretchy(S, word)) {
                count++;
            }
        }
        return count;
    }

    public boolean isStretchy(String stretch, String reg) {
        if(reg.length() > stretch.length()) {
            return false;
        }
        int i = 0;
        int j = i;
        int i2 = 0;
        int j2 = i2;

        while(i < stretch.length() && i2 < reg.length()) {
            if(stretch.charAt(i) == reg.charAt(i2)) {
                while(j < stretch.length() - 1 && stretch.charAt(i) == stretch.charAt(j + 1)) {
                    j++;
                }
                while(j2 < reg.length() - 1 && reg.charAt(i2) == reg.charAt(j2 + 1)) {
                    j2++;
                }
                if(j - i >= 2 || j2 - i2 == j - i) {
                    j++;
                    i = j;
                    j2++;
                    i2 = j2;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if(i == stretch.length() && i2 == reg.length()) {
            return true;
        }
        return false;
    }
}
