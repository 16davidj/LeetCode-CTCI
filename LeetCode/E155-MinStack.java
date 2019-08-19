/*
Difficulty: Easy
Problem Link: https://leetcode.com/problems/min-stack/

Description:
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Solution:
Keep the min value of the stack (so far) at every node. For example, when you pop, the min-value
associated with that stack node is the min for all the elements below. When you push, you compare
the value with the min value of the top of the stack (peek), and then set the min to that value if
its less than that.

Runtime: self-explanatory in problem statement
*/
class MinStack {
    class MinStackNode {
      int val;
      int min;

      public MinStackNode(int v, int m) {
        val = v;
        min = m;
      }
    }
    Stack<MinStackNode> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<MinStackNode>();
    }

    public void push(int x) {
      MinStackNode node;
      if(stack.isEmpty() || x < this.getMin()) {
        node = new MinStackNode(x, x);
      } else {
        node = new MinStackNode(x, this.getMin());
      }
      stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
