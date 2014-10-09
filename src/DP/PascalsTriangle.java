package DP;

import java.util.ArrayList;

public class PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        if (numRows < 0) return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> lastRow = new ArrayList<Integer>();
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> currentRow = new ArrayList<Integer>(i);
            if (i == 1) {
                currentRow.add(1);
                lastRow = currentRow;
            } else if (i == 2) {
            	currentRow.add(1);
            	currentRow.add(1);
            	lastRow = currentRow;
            } else {
            	currentRow.add(0, 1);
            	for(int index = 1; index < i - 1; index++) {
            		currentRow.add(index, lastRow.get(index - 1) + lastRow.get(index));
            	}
            	currentRow.add(i - 1, 1);
            	lastRow = currentRow;
            }
            res.add(currentRow);            	
        }
        return res;
    }
}
