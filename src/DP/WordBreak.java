package DP;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
        // http://blog.csdn.net/linhuanmars/article/details/22358863
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
