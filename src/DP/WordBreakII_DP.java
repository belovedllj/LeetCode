package DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII_DP {
	public List<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();  
		if(s == null || s.length() == 0) return res;
		if(!isWordBreak(s, dict)) return res;
        List<List<String>> words = new ArrayList<List<String>>(s.length() + 1);
        for(int i = 0; i <= s.length(); i++) {
        	words.add(new ArrayList<String>());
        }
        words.get(0).add("");
        for(int i = 0; i < s.length(); i++) {
            StringBuffer strBuf = new StringBuffer(s.substring(0, i + 1));
            for(int j = 0; j <= i; j++) {
            	if(!words.get(j).isEmpty() && dict.contains(strBuf.toString())) {
            		for(String str : words.get(j)) {
            			if (str.equals("")) {
            				words.get(i + 1).add(strBuf.toString());
            			} else {
            				words.get(i + 1).add(str + " " + strBuf.toString());
            			}
            		}
            	} 
            	strBuf.deleteCharAt(0);
            }
        }
        return words.get(words.size() - 1); 
    }
    
    private boolean isWordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) return true;
        if(dict.size() < 1) return false;
        boolean dpArray[] = new boolean[s.length() + 1];
        dpArray[0] = true;
        for(int i = 0; i < s.length(); i++) {
            StringBuffer strBuf = new StringBuffer(s.substring(0, i + 1));
            for(int j = 0; j <= i; j++) {
            	if(dpArray[j] && dict.contains(strBuf.toString())) {
            		dpArray[i + 1] = true;
            		break;
            	} 
            	strBuf.deleteCharAt(0);
            }
        }
        return dpArray[s.length()];    
    }
}
