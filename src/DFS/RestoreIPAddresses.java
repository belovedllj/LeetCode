package DFS;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        if(s == null || s.length() < 4) return list;
        helper(s, list, "", 0, 1);
        return list;
    }
    private void helper(String s, List<String> list, String curStr, 
    		int index, int spaceIndex) {
    	if(index >= s.length())
    		return;
    	if(spaceIndex == 4) {
    		String str = s.substring(index);
    		if(isValid(str)) {
    			list.add(curStr + "." + str);
    		}
    		return;
    	}
    	for(int i = 1; i < 4 && i + index <= s.length(); i++) {
    		String str = s.substring(index, index + i);
    		if(!isValid(str)) return;
    		else {
    			if(spaceIndex == 1)
    			    helper(s, list, str, index + i, spaceIndex + 1);
    			else
    				helper(s, list, curStr + "." + str, index + i, spaceIndex + 1);
    		}
    	}

        
    }
    private boolean isValid(String str)  {
    	if(str == null || str.length() < 1 || str.length() > 3) 
    		return false;
    	int num = Integer.parseInt(str);  
        if(str.charAt(0)=='0' && str.length()>1)  
            return false;  
        if(num>=0 && num<=255)  
            return true;  
        return false;
    }
}
