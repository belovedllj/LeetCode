package DFS;

public class N_QueensII {
	int totalNum = 0;
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        int[] dpLoc = new int[n]; // dp location 
        dfsHelper(dpLoc, 0, n);
        return totalNum;
    }
    
    private void dfsHelper(int[] dpLoc, int curRow, int n) {
        if (curRow == n) totalNum++;
        else {
            for(int i = 0; i < n; i++) {
                dpLoc[curRow] = i;
                if (isValid(dpLoc, curRow)) 
                    dfsHelper(dpLoc, curRow + 1, n);
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
}
