package DFS;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
	public List<String[]> solveNQueens(int n) { 
	        List<String[]> listOfALlSol = new ArrayList<String[]>();
	        if (n <= 0) return listOfALlSol;
	        int[] dpLoc = new int[n]; // dp location 
	        dfsHelper(listOfALlSol, dpLoc, 0, n);
	        return listOfALlSol;
	    }
	    
	    private void dfsHelper(List<String[]> listOfALlSol, int[] dpLoc, int curRow, int n) {
	        if (curRow == n) addSolIntoList(listOfALlSol, dpLoc, n);
	        else {
	            for(int i = 0; i < n; i++) {
	                dpLoc[curRow] = i;
	                if (isValid(dpLoc, curRow)) 
	                    dfsHelper(listOfALlSol, dpLoc, curRow + 1, n);
	            }
	        }
	    }
	    
	    private boolean isValid(int dpLoc[], int curRow) {
	        for(int i = 0; i < curRow; i++) {
	            if (dpLoc[i] == dpLoc[curRow] || curRow - i == Math.abs(dpLoc[curRow] - dpLoc[i]))
	                return false;
	        }
	        return true;
	    }
	    
	    private void addSolIntoList(List<String[]> listOfALlSol, int[] dpLoc, int n) {
	        String[] oneSolution = new String[n];
	        for(int i = 0; i < n; i++) {
	            String rowOfSol = "";
	            for(int j = 0; j < n; j++) {
	                if (j == dpLoc[i]) rowOfSol += "Q";
	                else rowOfSol += ".";
	            }
	            oneSolution[i] = rowOfSol;
	        }
	        listOfALlSol.add(oneSolution);
	    }
}
