package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || end == null || dict == null || start.length() != end.length())
        	return 0;
        if(start.equals(end)) return 1;
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        int level = 1;
        int lastNum = 1;
        int curNum = 0;
        if(dict.contains(start))
        	dict.remove(start);
        while(!queue.isEmpty()) {
        	String cur = queue.remove();
        	lastNum--;
        	for(int i = 0; i < cur.length(); i++) {
        	    char[] curArr = cur.toCharArray();
        		for(char ch = 'a'; ch <= 'z'; ch++) {
        			curArr[i] = ch;
        			String nextStr = new String(curArr);
        			if(nextStr.equals(end)) { // find last one
        				return level + 1;
        			}
        			if(dict.contains(nextStr)) {
        				dict.remove(nextStr);
        				queue.add(nextStr);
        				curNum++;
        			}
        		}
        	}
        	if(lastNum == 0) {
        		lastNum = curNum; // current level completed, move to next level
        		curNum = 0;
        		level++;
        	}
        }
        return 0;
    }
}
