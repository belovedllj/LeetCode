package BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import structures.UndirectedGraphNode;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = 
            new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode rootClone = new UndirectedGraphNode(node.label);
        map.put(node, rootClone);
        queue.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode curClone = map.get(cur);
            for(UndirectedGraphNode child : cur.neighbors) {
                if(map.containsKey(child)) { // already visited
                    curClone.neighbors.add(map.get(child));
                } else {
                    UndirectedGraphNode childClone = new UndirectedGraphNode(child.label);
                    curClone.neighbors.add(childClone);
                    map.put(child, childClone);
                    queue.offer(child);
                }
            }
        }
        return rootClone;
    }
}
