package Pointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
        if(S == null || T == null || S.length() == 0
           || T.length() == 0) return "";
        int tLen = T.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch : T.toCharArray()) {
            if(map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else 
                map.put(ch, 1);
        }
        int minNum = S.length() + 1; // must have  + 1 !!!  because "a", "a"
        int pre = 0;
        int counter = 0;
        String res = "";
        for(int i = 0; i < S.length(); i++) {
            char curCh = S.charAt(i);
            if(map.containsKey(curCh)) {
                map.put(curCh, map.get(curCh) - 1);
                if(map.get(curCh) >= 0) // no more occurance for this char
                    counter++;
            }
            
            while(counter == tLen) { //found all
                if(map.containsKey(S.charAt(pre))) {
                    map.put(S.charAt(pre), map.get(S.charAt(pre)) + 1);
                    
                    if(map.get(S.charAt(pre)) > 0) { // no extra occurance
                        counter--; // only here counter-- !!!
                        if (minNum > i - pre + 1) { // found new min
                            res = S.substring(pre, i + 1);
                            minNum = i - pre + 1;
                        }
                    }
                }
                pre++;// no matter what situation , pre move forward
            }
        }
        return res;
    }
}
