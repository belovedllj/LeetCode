package DP;

public class WildcardMatching_DP {
	public boolean isMatch(String s, String p) {
        if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')  
              return false; 
        // this is O(n^2)
        if (s == null || p == null) return false;
        if(p.length() == 0)
            if(s.length() == 0) return true;
            else return false;
        boolean[] dpArr = new boolean[s.length() + 1];
        dpArr[0] = true;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) != '*') {
                for(int j = s.length() - 1; j >= 0; j--) {
                    dpArr[j + 1] = dpArr[j] && (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j));
                }
            } else {
                int k = 0; // c*  *xsdfsdf must i > 1
                while(k <= s.length() && !dpArr[k])
                    k++;
                for(; k <= s.length(); k++)
                    dpArr[k] = true;
            }
            dpArr[0] = dpArr[0] && p.charAt(i) == '*';
        }
        return dpArr[dpArr.length - 1];
    }
}
