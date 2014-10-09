package Implementation;

public class LongestPalindromicSubstring_BF {
	public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int maxLen = 0;
        String result = "";
        for(int i = 0; i <= 2 * (s.length() - 1); i++) {
            int l = i / 2;
            int r = i / 2;
            if(i % 2 == 1)
                r++;
            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            int curLen = r - l - 1;
            if(curLen > maxLen) {
                result = s.substring(l + 1, r);
                maxLen = curLen;
            }
                
        }
        return result;
    }
}
