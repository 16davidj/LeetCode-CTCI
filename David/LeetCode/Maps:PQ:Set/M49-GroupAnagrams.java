/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/group-anagrams/

Description: Given an array of strings, group anagrams together.

Solution:
Note: Going through a string array and sorting all the strings, then sorting the entire array is
a O(n log n). Why? Imagine there are s strings in the array, and each string is m characters long.
In order to sort each string in the array, it is a O(s) * O(m log m) = O(s*m log m)
operation (string comparison is O(1), important to remember later.)

In order to sort the entire array of strings, it is a O(m) * O(s log s) = O(m*s log s). There are
O(s log s) comparisons that the sort makes, but each string needs O(m) characters to compare. This
is because strings take more than just constant time to compare.

= O(m*s (log s + log m))

So the trade off is sorting each string and sorting the entire array, which takes O(m*s (log s +
log m)) but O(1) space, or sorting each string and putting it into a hashMap, which is more
pertinent to what the problem asks, since it doesn't ask the strings in order, which takes
O(ms log s) and O(m) space. Choose the latter.

Sort each string, and put the strings in a map, then go through the key entries of the map and
convert it to a list.

*Where there are s strings in the array, and each string is m characters long.
Runtime: O(ms log s)

Space Complexity: O(m)
*/

public List<List<String>> groupAnagrams(String[] strs) {
  List<List<String>> res = new ArrayList<>();
  Map<String, List<String>> map = new HashMap<>();
  for(String s : strs) {
    String sortedS = sort(s);
    if(map.get(sortedS) == null) {
      List<String> list = new ArrayList<>();
      list.add(s);
      map.put(sortedS, list);
    } else {
      map.get(sortedS).add(s);
    }
  }
  for(String s : map.keySet()) {
    res.add(map.get(s));
  }
  return res;
}

private String sort(String s) {
  char[] charArr = s.toCharArray();
  Arrays.sort(charArr);
  return new String(charArr);
}
