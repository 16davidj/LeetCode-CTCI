/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/kth-largest-element-in-a-stream/

Description: Design a class to find the kth largest element in a stream. Note that it is the kth
largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
which contains initial elements from the stream. For each call to the method KthLargest.add, return
the element representing the kth largest element in the stream.

Solution:
Very similar to top K frequent elements in M347

Runtime: O(n log k): the PQ is at largest k elements

Space Complexity: O(k): there are at most k elements in the PQ

*/

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
      pq = new PriorityQueue();
      this.k = k;

      for(int x : nums) {
        pq.offer(x);
        if(pq.size() > k) {
          pq.poll();
        }
      }
    }

    public int add(int val) {
      pq.offer(val);
      if(pq.size() > k) {
        pq.poll();
      }
      return pq.peek();
    }
}
