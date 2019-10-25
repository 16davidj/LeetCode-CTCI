/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/implement-stack-using-queues/

Description:
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

Solution:
Different concept, pushing takes O(n), as you push the newest element to the front of the queue by
removing all the other elements and adding them to the back. Then, popping is O(1), as you just
take from the beginning.

*/

class MyStack {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
      queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
      int size = queue.size();
      queue.add(x);
      while(size > 0) {
        queue.add(queue.poll());
        size--;
      }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      return queue.poll();
    }

    /** Get the top element. */
    public int top() {
      return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
