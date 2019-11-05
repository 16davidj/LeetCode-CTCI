/*
When people send messages on their phones they sometimes modify word spelling by adding extra
letters for emphasis. For example, if you want to emphasize hello you might write it hellloooooooo.
Let's call the ls and the os word extensions. Regular text contains 2 or fewer of the same
character in a row, while word extensions have 3 or more of the same character in a row. Given an
input string representing one word, write a method that returns the start and end indices of all
extensions in the word.
https://leetcode.com/problems/positions-of-large-groups

Example 1:

Input: "whaaaaatttsup"
Output: [[2, 6], [7, 9]]
Explanation:
"aaaaa" and "ttt" are twitching letters, so output their starting and ending points.
Example 2:

Input: "hellloooooooo"
Output: [[2, 4], [5, 12]]
Follow-up:
Now we want to spell-check extended words. You are given a dictionary of words. Implement method isExtendedDictionaryWord that will return:

true if it is a dictionary word.
true if you collapse the extensions in the word and it is a dictionary word.
false otherwise.
class SpellChecker {
	public SpellChecker(List<String> dict) {
	}

	public boolean isExtendedDictionaryWord(String s) {
	}
}
Example:

SpellChecker checker = new SpellChecker(["hello"]);
checker.isExtendedDictionaryWord("hello"); // true
checker.isExtendedDictionaryWord("heeello"); // true 
checker.isExtendedDictionaryWord("xyz"); // false
*/
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int j = i + 1;
        while(i < S.length() && j < S.length()) {
            if(S.charAt(j) == S.charAt(i)) {
                j++;
            } else if(j > i + 1) {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                index.add(j - 1);
                res.add(index);
                i = j;
                j++;
            } else {
                i++;
                j++;
            }
        }
        if(j > i + 1) {
            List<Integer> index = new ArrayList<>();
            index.add(i);
            index.add(j - 1);
            res.add(index);
        }
        return res;
    }
}
