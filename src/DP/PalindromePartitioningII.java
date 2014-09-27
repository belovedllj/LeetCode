package DP;

public class PalindromePartitioningII {
	public int minCut(String s) { // http://blog.csdn.net/ljphhj/article/details/22573983
        if (s == null || s.length() == 0) 
        	return 0;
        int len = s.length();
        int[] cuts = new int[len];
        boolean[][] dpMatrix = new boolean[len][len];
       
        for (int i = 0; i < len; i++) {
        	cuts[i] = len - 1 - i;
        }
        // j >= i
        for (int i = len - 1; i >= 0; i--) {
        	for (int j = i; j < len; j++) {
        		if ((j - i < 2 || dpMatrix[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
        			dpMatrix[i][j] = true;
        			if (j == len - 1) cuts[i] = 0;
        			else cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
        			// [i , j] --cut here-- [j + 1, endl]
        		}
        	}
        }
        return cuts[0];
    }
}
