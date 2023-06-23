// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

// Implement the LRUCache class:

//     LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//     int get(int key) Return the value of the key if the key exists, otherwise return -1.
//     void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

// The functions get and put must each run in O(1) average time complexity.

 

// Example 1:

// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]

// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4




// https://leetcode.com/problems/lru-cache/description/

import java.util.Map;
import java.util.TreeMap;

public class LRU_Cache {
    int capacity;
    Map<Integer, Node> map;
    Node head, tail;

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        map = new TreeMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            remove(oldNode);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        add(newNode);
        if(map.size() > capacity) {
            Node node = head.next;
            remove(node);
            map.remove(node.key);
        }
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    private void add(Node newNode) {
        Node prevEnd = tail.prev;
        prevEnd.next = newNode;
        newNode.prev = prevEnd;
        newNode.next = tail;
        tail.prev = newNode;
    }


    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
class Node{
    int key, value;
    Node next, prev;
    Node(int key, int value){
        this.key = key;
        this.value = value;
//        next = prev = null;
    }   
}
class Mains{
    public static void main(String[] args) {
        System.out.println("LRU Cache");
        // TODO code application logic here
        //LRU_cache
        LRU_Cache cache = new LRU_Cache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println(cache.get(1)); // returns 1
        cache.put(4, 4); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(5, 5); // evicts key 3
        System.out.println(cache.get(1)); // returns 1 
        System.out.println(cache.get(3)); // returns -1 (not found)
        System.out.println(cache.get(4)); // returns 4
        System.out.println(cache.get(5)); // returns 5


    }
}

