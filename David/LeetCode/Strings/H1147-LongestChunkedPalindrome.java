/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/longest-chunked-palindrome-decomposition/

Description:
Return the largest possible k such that there exists a_1, a_2, ..., a_k such that:

Each a_i is a non-empty string;
Their concatenation a_1 + a_2 + ... + a_k is equal to text;
For all 1 <= i <= k,  a_i = a_{k+1 - i}.

Example 1:

Input: text = "ghiabcdefhelloadamhelloabcdefghi"
Output: 7
Explanation: We can split the string on "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)".
Example 2:

Input: text = "merchant"
Output: 1
Explanation: We can split the string on "(merchant)".
Example 3:

Input: text = "antaprezatepzapreanta"
Output: 11
Explanation: We can split the string on "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)".
Example 4:

Input: text = "aaa"
Output: 3
Explanation: We can split the string on "(a)(a)(a)".


Constraints:

text consists only of lowercase English characters.
1 <= text.length <= 1000

Solution: This is a greedy solution that relies on the fact that if there is a prefix and suffix
that equal each other, but also has a smaller set of prefix and suffix, then you should get the
smaller one, since the prefix and suffix will split into 3 different parts (draw it out with
the example of abcda X abcda).

Runtime: O(n^2)

Space Complexity: O(1)

*/

class Solution {
    public int longestDecomposition(String text) {
        int i = 0;
        int j = text.length() - 1;
        StringBuilder startString = new StringBuilder();
        StringBuilder endString = new StringBuilder();
        int count = 0;
        while(i < j) {
            startString.append(text.charAt(i));
            endString.insert(0, text.charAt(j));
            i++;
            j--;
            if(startString.toString().equals(endString.toString())) {
                count += 2;
                startString.setLength(0);
                endString.setLength(0);
            }
        }
        if((startString.length() > 0 || endString.length() > 0) || i == j) {
            return count + 1;
        }
        return count;
    }
}
