package Implementation;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
    	if (board==null|| board.length!=9 || board[0].length!=9) {
            return false;
        }
    	    	
    	boolean[][] rowChecker = new boolean[9][9];
    	boolean[][] colChecker = new boolean[9][9];
    	boolean[][] blockChecker = new boolean[9][9];
                
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] == '.') continue;
        		int c = board[i][j] - '1';
        		if (rowChecker[i][c] == true
        				|| colChecker[j][c] == true
        				|| blockChecker[i / 3 * 3 + j / 3][c] == true) 
        			return false;
        		rowChecker[i][c] = true;
        		colChecker[j][c] = true;
        		blockChecker[i / 3 * 3 + j / 3][c] = true;
        	}
        }
        return true;
    }
}
