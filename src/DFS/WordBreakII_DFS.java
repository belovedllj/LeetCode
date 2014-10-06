package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII_DFS {
	// brute force
	public List<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();  
		if(s == null || s.length() == 0) return res;
        helper(s, dict, 0, "", res);  
		return res;
    }
    
    private void helper(String s, Set<String> dict, int start, String curStr, List<String> res) {
		if(start >= s.length()) {
		    res.add(curStr);
		    return;
		}
			
		StringBuffer strBuf = new StringBuffer();
		for(int i = start; i < s.length(); i++) {
			strBuf.append(s.charAt(i));
			if(dict.contains(strBuf.toString())) {
				String newStr = curStr.length() > 0 ? (curStr + " " + strBuf.toString()) :strBuf.toString();
				helper(s, dict, i + 1, newStr, res);
			}
		}
	}
}
