/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/moving-average-from-data-stream/

Description:
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

Solution: Use a PQ to keep the size under the window


Runtime: O(1) for both methods

Space Complexity: O(n) for the queue

*/

class MovingAverage {
    Queue<Integer> queue;
    int size;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        sum = 0;
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        sum += val;
        if(queue.size() > size) {
            int remove = queue.poll();
            sum -= remove;
        }
        return sum/(double)queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
