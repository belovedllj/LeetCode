package DP;

public class EditDistance {
	public int minDistance(String word1, String word2) {        
        if(word1 == null || word2 == null) return 0;
        int word1Len = word1.length();
        int word2Len = word2.length();
        // init
        int[][] dpArrays = new int[word1Len + 1][word2Len + 1];
        for(int i = 0; i < word1Len + 1; i++) {
            dpArrays[i][0] = i;
        }
        for(int i = 0; i < word2Len + 1; i++) {
            dpArrays[0][i] = i;
        }
        
        for (int i = 1; i < word1Len + 1; i++) {
            for (int j = 1; j< word2Len + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dpArrays[i][j] = dpArrays[i - 1][j - 1];
                else {
                    dpArrays[i][j] = Math.min(dpArrays[i - 1][j - 1], dpArrays[i][j - 1]);
                    dpArrays[i][j] = Math.min(dpArrays[i - 1][j], dpArrays[i][j]);
                    dpArrays[i][j]++;
                }
            }
        }
        return dpArrays[word1Len][word2Len];
    }
}
