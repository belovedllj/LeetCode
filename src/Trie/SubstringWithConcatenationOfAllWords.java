package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();  
	    if(S == null || S.length() == 0 || L == null || L.length == 0 || L[0].length() == 0)
			return res;  
	    Map<String,Integer> finalMap = new HashMap<String,Integer>();
	    for(String str : L) {
	        if(finalMap.containsKey(str))
	            finalMap.put(str, finalMap.get(str) + 1);
	        else
	            finalMap.put(str, 1);
	    }
	    for(int i = 0; i < L[0].length(); i++) { 
	        Map<String,Integer> curMap = new HashMap<String,Integer>();
	        int left = i;
	        int counter = 0;
	        for(int j = i; j <= S.length() - L[0].length(); j += L[0].length()) { // must include '='!!!!!
	            String sub = S.substring(j, j + L[0].length());
	            if(!finalMap.containsKey(sub)) {
	                curMap.clear();
	                left = j + L[0].length();
	                counter = 0;
	                continue;
	            } else { 
	                // original map contains
	                counter++;
	                if(curMap.containsKey(sub))
	                    curMap.put(sub, curMap.get(sub) + 1);
	                else 
	                    curMap.put(sub, 1);
	                while(curMap.get(sub) > finalMap.get(sub)) { // repitation
	                    String possiRepStr = S.substring(left, left + L[0].length());
	                    left += L[0].length();
	                    curMap.put(possiRepStr, curMap.get(possiRepStr) - 1);
	                    counter--; //move one step minise one in curMap
	                }
	                if(counter == L.length) { // find one
	                    res.add(left);
	                    String str = S.substring(left, left + L[0].length());
	                    curMap.put(str, curMap.get(str) - 1);
	                    left += L[0].length();
	                    counter--;
	                }
	            }
	        }
	    }
	    return res;
    }
}
