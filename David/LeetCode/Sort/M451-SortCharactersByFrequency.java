/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/sort-characters-by-frequency/

Description:
Given a string, sort it in decreasing order based on the frequency of characters.

Solution:
very very similar to M347 solution

Runtime:
Space complexity: O(n)
Time Complexity: O(n log(m)), m being the amount of unique characters.
*/


public String frequencySort(String s) {
  Map<Character, Integer> map = new HashMap<>();
  for(Character c : s.toCharArray()) {
    if(map.get(c) == null) {
      map.put(c, 1);
    } else {
      map.put(c, map.get(c) + 1);
    }
  }

  PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) ->
    a.getValue() > b.getValue() ? -1 : 1);

  for(Map.Entry<Character, Integer> entry : map.entrySet()) {
    pq.offer(entry);
  }

  StringBuilder sb = new StringBuilder();

  //this loop is O(n) because it will run amount of times == to # of characters
  while(!pq.isEmpty()) {
    Map.Entry<Character, Integer> entry = pq.poll();
    int times = entry.getValue();
    while(times > 0) {
      sb.append(entry.getKey());
      times--;
    }
  }
  return sb.toString();
}
