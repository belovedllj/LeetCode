package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_DFS {
	public List<String> letterCombinations(String digits) {
        Map<Character, String> digitMap = buildMap();
        List<String> res = new ArrayList<String>();
        if (digits.length() < 1)        
            return res;

        helper(digits, digitMap, res, new StringBuffer(), 0);
        return res;
    }
    private void helper(String digits, Map<Character, String> digitMap, 
    		List<String> res, StringBuffer strBuff, int start) {
    	if (start == digits.length()) { // find all
    		res.add(strBuff.toString());
    	} else {
    		char curChar = digits.charAt(start);
			String curStr = digitMap.get(curChar);
			for (int j = 0; j < curStr.length(); j++) {
				char curCharInMap = curStr.charAt(j);
				strBuff.append(curCharInMap);
				helper(digits, digitMap, res, strBuff, start + 1);
				strBuff.deleteCharAt(strBuff.length() - 1); // romove last char
			}    		
    	}
    }
    private Map<Character, String> buildMap() {
    	Map<Character, String> digitMap = new HashMap<Character, String>();
    	digitMap.put('2', "abc");
    	digitMap.put('3', "def");
    	digitMap.put('4', "ghi");
    	digitMap.put('5', "jkl");
    	digitMap.put('6', "mno");
    	digitMap.put('7', "pqrs");
    	digitMap.put('8', "tuv");
    	digitMap.put('9', "wxyz");
    	return digitMap;
    }
}
