package DP;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
    	int len = triangle.size();
    	if (len < 1) return 0;
        int[] minSumArray = new int[len]; // repitivtiely use
        int minPath = Integer.MAX_VALUE;
        for (List<Integer> curRow : triangle) {
        	int curRowLen = curRow.size() - 1;
        	
        	for (int i = curRowLen; i >= 0 ; i--) {
        		if (i == 0) {
        			minSumArray[0] += curRow.get(0);
        		} else if (i == curRowLen){
        			minSumArray[curRowLen] = 
        					minSumArray[curRowLen - 1] + curRow.get(curRowLen);
        		} else {
        			minSumArray[i] = Math.min(minSumArray[i - 1], 
        					minSumArray[i]) + curRow.get(i);
        		}
        		if (curRowLen == len - 1) { // reach the bottom line, find the min
        			minPath = Math.min(minPath, minSumArray[i]);
        		}
        	}
        }
        return minPath;        
    }
}
