package DFS;

import java.util.Arrays;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;        
        if(s1.equals(s2)) return true;
        char[] charStr1 = s1.toCharArray();
        char[] charStr2 = s2.toCharArray();
        Arrays.sort(charStr1);
        Arrays.sort(charStr2);
        String str1Copy = new String(charStr1);
        String str2Copy = new String(charStr2);
        if(!str1Copy.equals(str2Copy)) return false;
        int len = s1.length();
        for(int i = 1; i < len; i++) {
        	if (isScramble(s1.substring(0, i), s2.substring(0, i)) 
                    && isScramble(s1.substring(i), s2.substring(i))
                    || isScramble(s1.substring(0, i), s2.substring(len - i))
                    && isScramble(s1.substring(i), s2.substring(0, len - i))) {
        		return true;
        	}
        }
        return false;
    }
}
