package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_BFS {
	public List<String> letterCombinations(String digits) {
        Map<Character, String> digitMap = buildMap();
        List<String> res = new ArrayList<String>();
        res.add("");
        if (digits == null)        
            return res;

        int index = 0;
        while(index < digits.length()) {
        	char ch = digits.charAt(index);
        	String curStr = digitMap.get(ch);
        	List<String> temp = new ArrayList<String>();
        	for(String str : res) {
        		for(int i = 0; i < curStr.length(); i++) 
        			temp.add(str + curStr.charAt(i));
        	}
        	res = temp;
        	index++;
        }
        return res;
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
