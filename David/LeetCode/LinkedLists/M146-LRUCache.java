/*
Difficulty: Medium
Problem Link: https://leetcode.com/problems/lru-cache/

Description:
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached
its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache(2);

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

Solution:
Split the problem into two parts. You have keys and values for the LRU cache, which would obviously
imply a hashMap, which gives you O(1) runtime for get. Then, you have to figure out how to get
the least recently used and most recently used in constant time, and remove specific keys in
constant time. It's constant time to remove a key for a map, but not for an array or queue or
stack. This is where a doubly-linked list comes in, where it is constant time to remove a node.


Runtime: O(1) for put and get

Space Complexity: O(capacity)

*/
class LRUCache {
    public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int k, int v, Node p, Node n) {
      key = k;
      val = v;
      prev = p;
      next = n;
    }
  }
  public class DLL {
    Node head;
    Node tail;

    public void addToHead(int key, int val) {
      //adds before head
      Node newHead = new Node(key, val, null, head);
      if(head == null) {
          tail = newHead;
      } else {
          head.prev = newHead;
      }
      head = newHead;
  }

  public void remove(Node target) {
    if(target == head && target == tail) {
        head = null;
        tail = null;
    } else if(target == head) {
        head.next.prev = null;
        head = head.next;
    } else if(target == tail) {
        tail.prev.next = tail.next;
        tail = tail.prev;
    } else {
        target.prev.next = target.next;
        target.next.prev = target.prev;
    }

  }
}
    Map<Integer, Node> map;
    DLL list = new DLL();
    int capacity;
    public LRUCache(int capacity) {
      map = new HashMap<>();
      this.capacity = capacity;
    }

    public int get(int key) {
      if(!map.containsKey(key)) {
          return -1;
      }
      Node update = map.get(key);
      list.remove(update);
      list.addToHead(key, update.val);
      map.put(key, list.head);
      return update.val;
    }

    public void put(int key, int value) {
      if(map.containsKey(key)) {
        list.remove(map.get(key)); //don't remove the least recently used if it's at capacity, just
        //update it
      } else if(map.size() == capacity) {
        map.remove(list.tail.key); //this is why you need the key in the Node
        list.remove(list.tail);
      }
      list.addToHead(key, value);
      map.put(key, list.head);
    }
}
//list is list of keys, head is most recent

//map is key, Node (with val)

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
