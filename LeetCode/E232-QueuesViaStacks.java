/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/implement-queue-using-stacks/

Description:
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

Solution:
Have two stacks. One stack is your basic stack, where the elements are arranged from oldest on
the bottom, and the newest on the top. This is for enqueuing items onto the stack. A second stack,
call it oldestStack, will have the oldest items on top and newest items on the bottom, which helps
for dequeuing items. Both stacks will have an isEmpty() function. If we pop twice, then we don't
want to move from newestStack to oldestStack, we just want to pop twice from oldestStack. If we
push twice, we just push onto newestStack. Essentially, oldest stack is a stack, and newest stack
is the reverse order.
*/

class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> reverseStack;
    int populated; //-1 for uninitialized, 0 for stack, 1 for reverse stack (where the elements are)
    /** Initialize your data structure here. */
    public MyQueue() {
      stack = new Stack<Integer>();
      reverseStack = new Stack<Integer>();
      populated = -1;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
      if(populated == -1 || populated == 0) {
        stack.push(x);
      } else {
        while(!reverseStack.isEmpty()) {
          stack.push(reverseStack.pop());
        }
      }
      populated = 0;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      if(populated == 0) {
        while(!stack.isEmpty()) {
          reverseStack.push(stack.pop());
        }
      }
      return reverseStack.pop();
      populated = 1;
    }

    /** Get the front element. */
    public int peek() {
      if(populated == 0) {
        while(!stack.isEmpty()) {
          reverseStack.push(stack.pop());
        }
      }
      return reverseStack.peek();
      populated = 1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return (reverseStack.isEmpty() && stack.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
