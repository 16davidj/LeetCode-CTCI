/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/top-k-frequent-elements/

Description:
Given a non-empty array of integers, return the k most frequent elements.

Solution:
Create a map, which will contain the number of occurrences for each int. Then, create a
PriorityQueue, but override the compareTo function to compare the occurrences, with the most
occurrences going to the back of the queue. For each N of the values in the array,
offer them to the PriorityQueue, and keep the priority queue size under k. At the end,
the priority queue will have the top k elements, and move them to the array.

Runtime:
Space complexity: O(n): create hashMap and PriorityQueue whose size is scaled to N
Time Complexity: O(n log k): There are n elements you have to go through offer/poll to the heap,
but since you add the "greatest" (largest values to the end) to the end of the PQ, and since
the heap behind the PriorityQueue will at largest be size k, each poll/offer will be O(log k),
so it is valuable to keep the least significant ones at the end.

Essentially, the min heap sorts the values for you if you want k elements from that sorted values.
*/

public List<Integer> topKFrequent(int[] nums, int k) {
  List<Integer> result = new ArrayList<>();
  Map<Integer, Integer> map = new HashMap<>();
  for(int i : nums) {
    if(map.get(i) == null) {
      map.put(i, 1);
    } else {
      map.put(i, map.get(i) + 1);
    }
  }

  PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) ->
    a.getValue() > b.getValue() ? 1 : -1);

  for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    pq.offer(entry);
    if(pq.size() > k) {
      pq.poll();
    }
  }

  while(!pq.isEmpty()) {
    result.add(pq.poll().getKey());
  }
  return result;
}
