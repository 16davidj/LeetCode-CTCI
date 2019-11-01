/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/palindrome-permutation-ii/

Description: Given a string s, return all the palindromic permutations (without duplicates) of it.
Return an empty list if no palindromic permutation could be form.

Example 1:

Input: "aabb"
Output: ["abba", "baab"]
Example 2:

Input: "abc"
Output: []

Solution: take half of the string, and then generate all permutations for that half, and
reverse each generated permutation and append it. If there's an odd amount of a single character,
place it in the half if there is more than 1 occurrence, and if there's only one, place it in
the middle of the generated string and the reverse.


Runtime: O((n/2)! + n/4), or just O(n!) to generate all possible strings

Space Complexity: O(n), with the HashSet

*/

class Solution {
    Set<String> results = new HashSet<>();
    public List<String> generatePalindromes(String s) {
        int[] charMap = new int[128];
        for(char c : s.toCharArray()) {
            charMap[c] += 1;
        }
        int seenOdd = 0;

        for(int count : charMap) {
            if(count % 2 == 1) {
                seenOdd++;
                if(seenOdd > 1) {
                    return new ArrayList<>();
                }
            }
        }

        //take half of string
        Character odd = null;
        StringBuilder half = new StringBuilder();
        for(int i = 0; i < charMap.length; i++) {
            char c = (char) i;
            if(charMap[i] % 2 == 1) {
                odd = c;
            }
            for(int j = 0; j < charMap[i]/2; j++) {
                half.append(c);
            }
        }
        if(half.toString().length() > 0) {
            permute(half.toString().toCharArray(), 0, odd);
        } else {
            results.add(s);
        }
        return new ArrayList<String>(results);
    }

    public void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public void permute(char[] og, int i, Character odd) {
        if(i == og.length - 1) {
            StringBuilder sb = new StringBuilder(new String(og));
            StringBuffer revSb = new StringBuffer(sb.toString()).reverse();
            if(odd != null) {
                sb.append(odd);
            }
            sb.append(revSb);
            results.add(sb.toString());
        } else {
            for(int j = i; j < og.length; j++) {
                if(i == j) {
                    permute(og, i+1, odd);
                }
                else if(og[i] != og[j]) {
                    swap(og, i, j);
                    permute(og, i + 1, odd);
                    swap(og, i, j);
                }
            }
        }
    }
}
