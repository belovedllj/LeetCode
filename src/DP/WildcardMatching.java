package DP;

public class WildcardMatching {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int i = 0, j = 0, star = -1,  mark = -1;
        while(i < s.length()) {
            if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++; j++;
            } else if(j < p.length() && p.charAt(j) == '*') {
                star = j++;
                mark = i;
            } else if(star != -1) {
                j = star + 1;
                i = ++mark;
            } else {
                return false;
            }
        }
        while(j < p.length() && p.charAt(j) == '*')
            j++;
        return j == p.length();
    }
}
