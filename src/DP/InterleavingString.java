package DP;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null || 
		           s3.length() != s1.length() + s2.length() || s3.length() < 0) return false;
		String minWord = s1.length() > s2.length() ? s2 : s1;  
		String maxWord = s1.length() > s2.length() ? s1 : s2;
		boolean[] dpArray = new boolean[minWord.length() + 1];
		        
		for(int i = 0; i <= maxWord.length(); i++) {
			for(int j = 0; j <= minWord.length(); j++) {
		        if(i == 0 && j == 0) {
		            dpArray[0] = true;
		        } else if(i == 0) {
		            dpArray[j] = dpArray[j - 1] && minWord.charAt(j - 1) == s3.charAt(j - 1);
		            if(dpArray[j] == false) break;
		        } else if(j == 0) {
		            dpArray[j] = dpArray[j] && maxWord.charAt(i - 1) == s3.charAt(i - 1);
		        } else {
		            dpArray[j] = (dpArray[j] && maxWord.charAt(i - 1) == s3.charAt(i + j - 1)) ||
		                         (dpArray[j - 1] && minWord.charAt(j - 1) == s3.charAt(i + j - 1));
		        }
		    }
		}
		return dpArray[dpArray.length - 1];
    }
}
