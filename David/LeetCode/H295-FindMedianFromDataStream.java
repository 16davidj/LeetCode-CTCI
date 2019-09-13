/*
Difficulty: Hard
Problem Link: https://leetcode.com/problems/find-median-from-data-stream/

Description:
Median is the middle value in an ordered integer list. If the size of the list is even, there is no
middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.

Solution: The two heap solution has two heaps that are balanced and the same size. There is the
minHeap that stores all the highest numbers (so the top is the smallest "high" number) and
the maxHeap stores all the small numbers (so the top is the largest "low" number).

Runtime: addNum takes O(log n) time, as poll and adding take log n, and there are only a max of
3 or 4 times it is run. findMedian takes O(1) time, since getting the top of the heap is
constant time

Space Complexity: O(n) in a heap
*/

class MedianFinder {
    //list needs to be sorted and needs to have size
    PriorityQueue<Integer> hiNums;
    PriorityQueue<Integer> loNums;
    /** initialize your data structure here. */
    public MedianFinder() {
      hiNums = new PriorityQueue<Integer>((a, b) -> a - b); //greatest elements at the back
      loNums = new PriorityQueue<Integer>((a, b) -> b - a);
    }

    public void addNum(int num) { //note you have to balance
      if(hiNums.size() == 0) {
          hiNums.add(num);
      } else {
           if(num > hiNums.peek()) {
            hiNums.add(num);
          } else {
            loNums.add(num);
          }
      }

      while(hiNums.size() - loNums.size() >= 2) {
        loNums.add(hiNums.poll());
      }
      while(loNums.size() - hiNums.size() >= 2) {
        hiNums.add(loNums.poll());
      }
    }

    public double findMedian() {
      if(hiNums.size() == loNums.size()) {
        return (hiNums.peek() + loNums.peek())/2.0;
      } else if(hiNums.size() > loNums.size()) {
        return hiNums.peek();
      } else {
        return loNums.peek();
      }
    }
}
