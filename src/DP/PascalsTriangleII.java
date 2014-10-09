package DP;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        rowIndex += 1;
        List <Integer> rowList = new ArrayList<Integer>(rowIndex);
        for (int i = 1; i <= rowIndex; i++) {
            if (i == 1) {
                rowList.add(1);
            } else if (i == 2) {
            	rowList.add(1);
            } else {
            	rowList.add(i - 1, 1);
            	for(int index = i - 2; index >= 1; index--) {
            		rowList.set(index, rowList.get(index - 1) + rowList.get(index));
            	}
            	// rowList.set(0, 1); first element always be 1
            }
  	    }
  	    return rowList;
    }
}
