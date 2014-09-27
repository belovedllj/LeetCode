package DFS;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) { // include it self if isPalindrome
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> cur = new ArrayList<String>();
        if (s == null || s.length() <= 0)
        	return res;
        partitionHelper(res, cur, s);
        return res;
    }
    
    private void partitionHelper(List<List<String>> res,
    		List<String> cur, String str) {
    	if (str.length() == 0) { // empty string subString(5,5);
    		res.add(new ArrayList<String>(cur));
    		return;
    	}
    	for (int i = 1; i <= str.length(); i++) {
    		String subString = str.substring(0, i);
    		if (isPalindrome(subString)) {
    			cur.add(subString);
    			String nextSubString = str.substring(i);
    			partitionHelper(res, cur, nextSubString);
    			cur.remove(cur.size() - 1);
    		}
    	}    	
    }
    
    private boolean isPalindrome(String str) {
    	int length = str.length();
    	for (int i = 0; i <= length / 2; i++) {
    		if (str.charAt(i) != str.charAt(length - 1 - i))
    			return false;
    	}
    	return true;
    }
}
