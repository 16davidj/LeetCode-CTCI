/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/implement-stack-using-queues/

Description:
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

Solution: see E232, same solution, but using queue.


*/

class MyStack {
    Queue<Integer> queue;
    Queue<Integer> reverseQueue;
    int populated;
    /** Initialize your data structure here. */
    public MyStack() {
      queue = new Queue<Integer>();
      reverseQueue = new Queue<Integer>();
      populated = -1;
    }

    /** Push element x onto stack. */
    public void push(int x) {
      if(populated == 1) {
        while(!reverseQueue.isEmpty()) {
          queue.push(reverseQueue.pop());
        }
      }
      queue.push(x);
      populated = 0;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      if(populated == 0) {
        while(!queue.isEmpty()) {
          reverseQueue.push(queue.pop());
        }
      }
      populated = 1;
      return reverseQueue.pop();
    }

    /** Get the top element. */
    public int top() {
      if(populated == 0) {
        while(!queue.isEmpty()) {
          reverseQueue.push(queue.pop());
        }
      }
      populated = 1;
      return reverseQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return reverseQueue.isEmpty() && queue.isEmpty();
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
