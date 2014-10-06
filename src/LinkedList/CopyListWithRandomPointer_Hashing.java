package LinkedList;

import java.util.HashMap;

import structures.RandomListNode;
// using only one loop
public class CopyListWithRandomPointer_Hashing {
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)  
        return head;  
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();  
        RandomListNode newHead = new RandomListNode(head.label);  
        map.put(head,newHead);  
        RandomListNode pre = newHead;  
        RandomListNode node = head.next;  
        RandomListNode rand = head.random;  
        while(node != null || rand != null) {   // for rand != null just in case the last node has non-null random pointer 
    
        	RandomListNode newNode = null, newRand = null;
        	if (node != null) {
        		if(map.containsKey(node)) {
        			newNode = map.get(node);
        		} else {
        			newNode = new RandomListNode(node.label);
        			map.put(node, newNode);
        		}
        	}
        	
        	if (rand == null) {
        		newRand = null;
        	} else {
        		if(map.containsKey(rand)) {
        			newRand = map.get(rand);                
        		} else {
        			newRand = new RandomListNode(rand.label);
        			map.put(rand, newRand);
        		}
        	}
        	if (node == null) {
        		pre.random = newRand;
        		break;
            // reach the last node, connected the random and break the loop;
        	}
        	pre.next = newNode;  
        	pre.random = newRand;
        	pre = newNode;  
        	RandomListNode temp = node;
        	node = node.next;  
        	rand = temp.random;
        }  
      
        return newHead;
    }
}
