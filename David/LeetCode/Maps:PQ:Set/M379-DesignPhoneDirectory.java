/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/design-phone-directory/

Description: Design a Phone Directory which supports the following operations:

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);

Solution: HashSet: to keep the list of used numbers, so check and release can operate in constant
time. You also want get to run in constant time. You can't always get the size() of the hashSet to
get a new number, since old numbers have been recycled. Thus, you also need to get a constant time 
operation to get an old number from the list, which is why you can use a linkedList.

Runtime: O(1) for all methods

Space Complexity: O(n)

*/

class PhoneDirectory {
    Set<Integer> usedList;
    LinkedList<Integer> recycled;
    int max;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        usedList = new HashSet<Integer>();
        recycled = new LinkedList<Integer>();
        max = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(usedList.size() == max) {
            return -1;
        }
        if(recycled.size() == 0) {
            int s = usedList.size();
            usedList.add(s);
            return s;
        } else {
            int x = recycled.remove();
            usedList.add(x);
            return x;
        }
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !usedList.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(usedList.remove(number)) {
            recycled.add(number);
        }
    }
}
