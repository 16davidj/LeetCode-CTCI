/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/implement-trie-prefix-tree/

Description:
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

Solution:


Runtime:

Space Complexity:

*/

class Trie {
    Map<Character, Trie> children;
    boolean isWord;
    /** Initialize your data structure here. */
    public Trie() {
        children = new HashMap<>();
        isWord = false;
    }
    public Trie(boolean isW) {
        children = new HashMap<>();
        isWord = isW;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      if(word.length() == 0) {
        this.isWord = true;
        return;
      }
      Character c = word.charAt(0);
      if(!this.children.containsKey(c)) {
        Trie tempTrie = new Trie(word.length() == 1);
        this.children.put(c, tempTrie);
      }
      this.children.get(c).insert(word.substring(1));
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.length() == 0) {
          return this.isWord;
        }
        Character c = word.charAt(0);
        if(!this.children.containsKey(c)) {
          return false;
        } else {
          return this.children.get(c).search(word.substring(1));
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.length() == 0) {
          return this.isWord || this.children.size() > 0;
        }
        Character c = prefix.charAt(0);
        if(!this.children.containsKey(c)) {
          return false;
        } else {
          return this.children.get(c).startsWith(prefix.substring(1));
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
