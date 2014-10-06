package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	if(start == null || start.length() == 0 || end == null || end.length() == 0)
    		return res;
    	if(start.equals(end)) {
    		List<String> st = new ArrayList<String>();
    		st.add(end);
    		res.add(st);
    		return res;
    	}
    	Set<String> unvisitedSet = new HashSet<String>(); 
    	unvisitedSet.addAll(dict);
    	unvisitedSet.add(start);
    	unvisitedSet.remove(end); // if included
    	Map<String, LinkedList<String>> pathMap = new HashMap<String, LinkedList<String>>();
    	LinkedList<String> levelQueue = new LinkedList<String>();
    	levelQueue.add(end); // backward
    	int lastNum = 1;
    	int curNum = 0;
    	int finalLevel = Integer.MAX_VALUE;
    	boolean isFound = false;
    	Set<String> curLevelSet = new HashSet<String>();
    	int level = 1;
    	while(!levelQueue.isEmpty()) {
    		String curStr = levelQueue.poll();
    		lastNum--;
    		if(isFound && level > finalLevel) { // cur level won't be the smallest
    			break;
    		}
    		char[] curStrCharArr = curStr.toCharArray();
    		for(int i = 0; i < curStrCharArr.length; i++) {
    			char originalChar = curStrCharArr[i];
    			boolean foundCurCircle = false;
    			for(char ch = 'a'; ch <= 'z'; ch++) {
    				curStrCharArr[i] = ch;
    				String newStr = new String(curStrCharArr);
    				if(ch != originalChar && unvisitedSet.contains(newStr)) {
    					if(pathMap.containsKey(newStr)) { // save space
    						pathMap.get(newStr).add(curStr);
    					} else {
    						LinkedList<String> list = new LinkedList<String>();
    						list.add(curStr);
    						pathMap.put(newStr, list);
    					}
    					if(newStr.equals(start)) {
    						finalLevel = level;
    						isFound = true;
    						foundCurCircle = true;
    						break;
    					} else if(!isFound){ // haven't found last in cur circle
    						// if we found one for other path that deeper we won't think about it
    						if(curLevelSet.add(newStr)) { // this string may already be added
    							levelQueue.add(newStr);
    							curNum++;    							
    						}
    					}
    				}    				
    			}
    			if(foundCurCircle)
					break; // break the word circle
    			curStrCharArr[i] = originalChar;
    		}
    		if(lastNum == 0) { //curLevel string completed
    			lastNum = curNum;
    			curNum = 0;
    			level++;
    			unvisitedSet.removeAll(curLevelSet); // move to next level;
    			curLevelSet.clear();
    		}
    	}
    	if(isFound) {
    		List<String> list = new LinkedList<String>();
    		list.add(start);
    		getPath(start, end, list, res, pathMap);
    	}
    	return res;
    }
    private void getPath(String cur, String end, List<String> list, List<List<String>> res,
    		Map<String, LinkedList<String>> pathMap) {
    	if(cur.equals(end)) 
    		res.add(new ArrayList<String>(list));
    	else {
    		for(String str : pathMap.get(cur)) {
    			list.add(str);
    			getPath(str, end, list, res, pathMap);
    			list.remove(list.size() - 1);
    		}
    		
    	}
    }
}
