package Pointer;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            String curStr = strs[i];
            int j = 0;
            for (; j < Math.min(curStr.length(), prefix.length()); j++) {
                if (curStr.charAt(j) != prefix.charAt(j)) break;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}
