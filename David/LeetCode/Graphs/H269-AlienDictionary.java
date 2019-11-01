/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/alien-dictionary/submissions/

Description: There is a new alien language which uses the latin alphabet. However, the order among
letters are unknown to you. You receive a list of non-empty words from the dictionary, where words
are sorted lexicographically by the rules of this new language. Derive the order of letters in this
language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
]

Output: ""

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.

Solution: Top-Sort, but this answer is in BFS. Essentially it's top sort, but the way you want to
add to the graph and see which letters depend on what is not compare letters within each word,
but compare letters (the first instance where there's a difference) between words, because that
gives you the order. The rest of the letters should be added to a hashSet and the graph beforehand,
because even though they aren't compared, they are still part of the order.

Runtime: O(c), you have to process every node, where c is the amount of characters you ahve in
total.


Space Complexity: O(c), worst case, you have c nodes and a bunch of edges that connects all of them 

*/

class Solution {
    public String alienOrder(String[] words) {
        if(words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        Queue<Character> zeroDep = new LinkedList<>();
        Set<Character> definedChars = new HashSet<>();
        StringBuilder order = new StringBuilder();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                indegrees.put(c, 0);
                definedChars.add(c);
            }
        }

        for(int j = 1; j < words.length; j++) {
            String word1 = words[j-1];
            String word2 = words[j];
            for(int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
                if(word1.charAt(i) != word2.charAt(i)) {
                    //add edge
                    char charBefore = word1.charAt(i);
                    char charAfter = word2.charAt(i);
                    if(graph.get(charBefore) == null) {
                        Set<Character> dependents = new HashSet<>();
                        dependents.add(charAfter);
                        graph.put(charBefore, dependents);
                        indegrees.put(charAfter, indegrees.get(charAfter) + 1);
                    } else {
                        if(!graph.get(charBefore).contains(charAfter)) {
                            indegrees.put(charAfter, indegrees.get(charAfter) + 1);
                            graph.get(charBefore).add(charAfter);
                        }
                    }
                    break;
                }
            }
        }

        for(char key : indegrees.keySet()) {
            if(indegrees.get(key) == 0 && definedChars.contains(key)) {
                zeroDep.add(key);
            }
        }
        while(zeroDep.size() > 0) {
            char nextRemove = zeroDep.poll();
            order.append(nextRemove);
            if(graph.get(nextRemove) == null) {
              continue;
            }
            for(char remove : graph.get(nextRemove)) {
                indegrees.put(remove, indegrees.get(remove) - 1);
                if(indegrees.get(remove) == 0) {
                    zeroDep.add(remove);
                }
            }
        }
        String result = order.toString();
        if(result.length() == definedChars.size()) {
            return result;
        }
        return "";
    }
}
