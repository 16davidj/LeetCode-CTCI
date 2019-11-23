/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/my-calendar-i/

Description:
Implement a MyCalendar class to store your events. A new event can be added if adding the event
will not cause a double booking.

Your class will have the method, book(int start, int end). Formally, this represents a booking on
the half open interval [start, end), the range of real numbers x such that start <= x < end.

A double booking happens when two events have some non-empty intersection (ie., there is some time
that is common to both events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar
successfully without causing a double booking. Otherwise, return false and do not add the event to
the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:

MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation:
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.


Note:

The number of calls to MyCalendar.book per test case will be at most 1000.
In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].

Solution: Keep a BST, which keeps the elements in order, and allows you to insert at constant time,
since a binary search on an array will be in log n, but will take O(n) to insert. 

Runtime: O(log n)

Space Complexity: O(N)

*/

class MyCalendar {
    class Node{
        int start;
        int end;
        Node left;
        Node right;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
        }
    }
    public Node calendarTree;

    public MyCalendar() {
        calendarTree = null;
    }

    public boolean book(int start, int end) {
        Node addVal = add(this.calendarTree, start, end);
        if(addVal == null) {
            return false;
        } else {
            this.calendarTree = addVal;
            return true;
        }
    }

    public Node add(Node root, int start, int end) {
        if(root == null) {
            return new Node(start, end);
        } else if(start < root.end && root.start < end) {
            return null;
        } else {
            if(start >= root.end) {
                Node addVal = add(root.right, start, end);
                if(addVal == null) {
                    return null;
                }
                root.right = addVal;
            } else {
                Node addVal = add(root.left, start, end);
                if(addVal == null) {
                    return null;
                }
                root.left = addVal;
            }
            return root;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
