package DP;

public class UniqueBinarySearchTrees_DP {
	public int numTrees(int n) {
		if (n == 0) return 0;  
	    int[] count = new int[n + 1];  
	    count[0] = 1; 
	    count[1] = 1;  
	   
	    for (int i = 2; i <= n; ++i) {  
	       for (int j = 0; j < i; ++j) {  
	         count[i] += (count[j] * count[i - 1 - j]);  
	       }  
	    }  	   
	    return count[n];  
	}
}
