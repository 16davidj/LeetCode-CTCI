/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

Description: Let's define a function f(s) over a non-empty string s, which calculates the frequency
of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest
character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is
the number of words such that f(queries[i]) < f(W), where W is a word in words.



Example 1:

Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
Example 2:

Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and
f("aaaa") are both > f("cc").

Constraints:

1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] are English lowercase letters.

Solution:
Essentially, find the value for the count of smallest word for each word. Sort words so that you
can do a binary search on it to find the position where it belongs.

Runtime: O(m log n), where n is the length of words, and m is the length of queries

Space Complexity: O(max(m, n))

*/

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] query = new int[queries.length];
        int[] word = new int[words.length];
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            query[i] = smallestCount(queries[i]);
        }
        for(int i = 0; i < word.length; i++) {
            word[i] = smallestCount(words[i]);
        }
        Arrays.sort(word);
        for(int i = 0; i < query.length; i++) {
            int start = 0;
            int end = word.length - 1;
            int mid = -1;
            while(start <= end) { //this loop doesn't end until start > end, meaning that
            //start represents the rightmost place that the value BELONGS in, since you don't
            //care about matches, you care about how many words are greater than that value,
            //so you subtract from word.length.
                mid = (start + end)/2;
                if(word[mid] <= query[i]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            result[i] = word.length - start;
        }
        return result;
    }

    public int smallestCount(String query) {
        char min = 'z' + 1;
        int count = 0;
        char[] q = query.toCharArray();
        for(char x : q) {
            if(x == min) {
                count++;
            }
            if(x < min) {
                count = 1;
                min = x;
            }
        }
        return count;
    }
}
