/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/word-ladder/

Description:

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest
transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

Solution: Instead of doing a DFS, which takes too long, you should preprocess each word
into the different forms it can take. For eg. cur goes to *ur, c*r, cu*. This is because it's a lot
more expensive to at every time, go through the entire word list one by one and compare to see
if the words are one off. Instead, you make all the forms it can take into a map, and put the words
into a list for that map, so that if a word searches that generic makeup of a string, then you
BFS into all the words there, because those are all one off.

Runtime: O(M * N^2), where n is the amount of words in the list and M is the length of the word

Space Complexity: O(n), where n is the amount of words in the list

*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      if(!wordList.contains(endWord)) {
        return 0;
      }
      int distance = 0;
      Map<String, List<String>> genericStr = new HashMap<>(); //eg. c*r maps to cur, cdr, etc.

      for(String word : wordList) {
        for(String generic : genGenerics(word)) {
          List<String> realWords = genericStr.getOrDefault(generic, new ArrayList<String>());
          realWords.add(word);
          genericStr.put(generic, realWords);
        }
      }

      Queue<String> bfsQ = new LinkedList<>();
      bfsQ.add(beginWord);
      Set<String> seen = new HashSet<>();
      while(bfsQ.size() > 0) {
        int size = bfsQ.size();
        for(int i = 0; i < size; i++) {
          String searchWord = bfsQ.poll();
          if(searchWord.equals(endWord)) {
            return distance + 1;
          }
          for(String intermediate : genGenerics(searchWord)) {
            if(!seen.contains(intermediate))
            {
              seen.add(intermediate);
              if(genericStr.get(intermediate) == null) {
                  continue;
              }
              for(String realWord : genericStr.get(intermediate)) {
                bfsQ.add(realWord);
              }
            }
          }
        }
        distance++;
      }
      return 0;
    }

  private List<String> genGenerics(String word) {
    List<String> res = new ArrayList<>();
    for(int i = 0; i < word.length(); i++) {
      String generic = "";
      if(i == word.length() - 1) {
        generic = word.substring(0, i) + "*";
      } else {
        generic = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
      }
      res.add(generic);
    }
    return res;
  }
}
