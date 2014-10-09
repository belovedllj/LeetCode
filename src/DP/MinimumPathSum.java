package DP;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m < 1 || n < 1) return 0;
        int[] sum = new int[n];
        
        for(int ro = 0; ro < m; ro++) {
        	for(int co = 0; co < n; co++) {
        		if (co == 0) 
        			sum[co] += grid[ro][co];
        		else if (ro == 0){
        			sum[co] = grid[ro][co] + sum[co - 1];
        		} else {
        		    sum[co] = grid[ro][co] + Math.min(sum[co], sum[co - 1]);
        		}
        	}
        }
        return sum[n - 1];
    }
}
