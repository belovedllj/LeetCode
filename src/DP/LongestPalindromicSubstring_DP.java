package DP;

public class LongestPalindromicSubstring_DP {
	public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        boolean[][] dpArray = new boolean[s.length()][s.length()];
        String result = "";
        int maxLen = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
               if(j - i <= 2) {
                   dpArray[i][j] = s.charAt(j) == s.charAt(i);
               }
               else {
                   dpArray[i][j] = s.charAt(j) == s.charAt(i) && dpArray[i + 1][j - 1];
               }
               if(dpArray[i][j]) {
                   if(j - i + 1 > maxLen) {
                       maxLen = j - i + 1;
                       result = s.substring(i, j + 1);
                   }
                }
            }
        }
        return result;
    }
}
