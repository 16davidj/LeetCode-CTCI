/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/goat-latin/

Description:
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and
uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.

If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".

Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end
and so on.
Return the final sentence representing the conversion from S to Goat Latin.

Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
Solution:


Runtime:

Space Complexity:

*/

class Solution {
    public String toGoatLatin(String S) {
        StringBuilder res = new StringBuilder("");
        StringBuilder aa = new StringBuilder("");
        String[] split = S.split(" ");
        for(String word : split) {
            aa.append('a');
            StringBuilder w = new StringBuilder(word);
            if(!isVowel(word.charAt(0))) {
                w.deleteCharAt(0);
                w.append(word.charAt(0));
            }
            w.append("ma");
            w.append(aa.toString());
            res.append(w);
            res.append(" ");
        }
        return res.toString().trim();
    }

    private boolean isVowel(char c) {
        char x = Character.toLowerCase(c);
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }
}
