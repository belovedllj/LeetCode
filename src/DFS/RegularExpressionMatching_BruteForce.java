package DFS;

public class RegularExpressionMatching_BruteForce {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        if(p.equals(".*")) return true;
        return helper(s, p, 0, 0);
    }
    private boolean helper(String s, String p, int i, int j) {
        if(j == p.length()) return i == s.length();
        if(j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if(i == s.length() || p.charAt(j) != s.charAt(i) && p.charAt(j) != '.')
                return false;
            else
                return helper(s, p, i + 1, j + 1);
        } else {
            while(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                if(helper(s, p, i, j + 2))
                    return true;
                else
                    i++;
            }
            return helper(s, p, i, j + 2);
        }
    }
}
