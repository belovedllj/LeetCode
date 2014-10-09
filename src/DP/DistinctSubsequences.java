package DP;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
        /*
        [1,0,0,0,0,0,0,0      // the first '1' is a buffer used in if (S.charAt(i - 1) == T.charAt(j - 1)) {
         1,0,0,0,0,0,0,0            table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
         1,0,0,0,0,0,0,0
         1,0,0,0,0,0,0,0]       
        */
        if(S == null || T == null || S.length() < T.length() || S.length() <= 0)
            return 0;
        int[] table = new int[T.length() + 1];
        table[0] = 1;
        for(int i = 1; i <= S.length(); i++) {
            for(int j = Math.min(T.length(), i); j >=1; j--) { // reuse array
                if(S.charAt(i - 1) == T.charAt(j - 1))
                    table[j] += table[j - 1];
            }
        }
        return table[T.length()];
    }
}
