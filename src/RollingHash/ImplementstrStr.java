package RollingHash;

public class ImplementstrStr {
	public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return null;
        if(needle.length() == 0) return haystack;
        if(haystack.length() < needle.length()) return null;
        // only lowercase char
        
        int base = 29;
        int needleLen = needle.length();
        long needHash = 0;
        long tempBase = 1;
        for(int i = 0; i < needleLen; i++) {
        	char ch = needle.charAt(i);
        	needHash += (ch - 'a' + 1) *  tempBase;
        	tempBase *= base;
        }
        
        long hayHash = 0;
        tempBase = 1;
        for(int i = 0; i < needleLen; i++) {
        	char ch = haystack.charAt(i);
        	hayHash += (ch - 'a' + 1) * tempBase;
        	tempBase *= base;
        }
        if(hayHash == needHash)
        	return haystack;
        tempBase /= base;
        for(int i = needleLen; i < haystack.length(); i++) {
        	char ch = haystack.charAt(i);
        	hayHash /= base;
        	hayHash += (ch - 'a' + 1) * tempBase;
        	if(hayHash == needHash)
        		return haystack.substring(i - needleLen + 1);
        }
        return null;
    }
}
