/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/top-k-frequent-words/

Description:
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same
frequency, then the word with the lower alphabetical order comes first.

Solution:
very very similar to M347

Runtime:
Space complexity: O(n), created a map and a pq that has n entries
Time Complexity: O(n log k), see M347 for details
*/

public List<String> topKFrequent(String[] words, int k) {
  List<String> result = new ArrayList<>();
  Map<String, Integer> map = new HashMap<>();
  for(String s : words) {
    if(map.get(s) == null) {
      map.put(s, 1);
    } else {
      map.put(s, map.get(s) + 1);
    }
  }

  PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) ->
    a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

  for(Map.Entry<String, Integer> entry : map.entrySet()) {
    pq.offer(entry);
    if(pq.size() > k) {
      pq.poll();
    }
  }

  while(!pq.isEmpty()) {
    result.add(0, pq.poll().getKey());
  }
  return result;
}
