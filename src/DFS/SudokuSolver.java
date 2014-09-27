package DFS;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) 
        	return;
        helper(board, 0, 0);
    }
    private boolean helper(char[][] board, int m, int n) {
    	if(m == 9) return true;
    	if(board[m][n] != '.') {
    		if(n == 8) 
    			return helper(board, m + 1, 0);
    		else
    			return helper(board, m, n + 1);    		
    	} else {
    		for(int k = 1; k <= 9; k++) {
        		board[m][n] = (char)('0' + k);
        		if(isValid(board, m, n)) {
        			if(n == 8) {
        				if(helper(board, m + 1, 0))
        			    	return true;
        			} else {
        				if(helper(board, m, n + 1))
        			    	return true;
        			}       			
        		}
        	}
        	board[m][n] = '.';
    	}
    	return false;    	
    }
    private boolean isValid(char[][] board, int i, int j)  {
    	for(int k = 0; k < 9; k++) {
    		if(k != j && board[i][k] == board[i][j])
    			return false;
    	}
    	for(int k = 0; k < 9; k++) {
    		if(k != i && board[k][j] == board[i][j])
    			return false;
    	}
    	for(int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
    		for(int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
    			// must be '||' 
    			if((row != i || col != j) && board[row][col] == board[i][j])
    				return false;
    		}
    	}
    	return true;
    }
}
