package Design;

import java.util.HashMap;

public class LRUCache {
    int capacity;
    int num;
    HashMap<Integer, Node> map;  
    Node first, last;  
    class Node {
        int key, val;
        Node pre, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.num = 0;
        this.map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        	return -1;
        Node node = map.get(key);
        if(node != first) {
            if(node == last) last = last.pre;
        	node.pre.next = node.next;
        	if(node.next != null)
        		node.next.pre = node.pre;
        	node.next = first;
        	first.pre = node;
        	node.pre = null;
        	first = node;
        }
        return node.val;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
        	Node node = map.get(key);
        	node.val = value;
        	if(node != first) {
        	    if(node == last) last = last.pre;
            	node.pre.next = node.next;
            	if(node.next != null)
            		node.next.pre = node.pre;
            	node.next = first;
            	first.pre = node;
            	node.pre = null;
            	first = node;
            }
        } else {
        	Node node = new Node(key, value);
        	// assume capacity at least 1
        	if(num >= capacity) {
        		map.remove(last.key);
        		last = last.pre;
        		if(last == null) {
        		    first = null;
        		} else {
        		    last.next = null;
        		}
        		num--;
        	}
        	if(first == null && last == null) {
        		first = node;
        		last = node;
        	} else {
        		node.next = first;
        		first.pre = node;
        		first = node;
        	}
        	map.put(key, node);
        	num++;
        }
    }
}
