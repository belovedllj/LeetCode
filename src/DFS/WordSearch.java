package DFS;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        // http://blog.csdn.net/linhuanmars/article/details/24336987
        if(word == null || word.length() == 0) return true;
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(helper(board, word, 0, i, j, new boolean[board.length][board[0].length]))
        			return true;
        	}
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int index, int i, int j, boolean[][] used) {
    	if(index == word.length())
    		return true;
    		// used[i][j] must in the last
    	if(i < 0 || j < 0 || i >= board.length || j >= board[0].length
    			 || used[i][j] ||board[i][j] != word.charAt(index))
    		return false;
    	used[i][j] = true;
    	boolean res = helper(board, word, index + 1, i - 1, j, used) ||
    			      helper(board, word, index + 1, i + 1, j, used) ||
    			      helper(board, word, index + 1, i, j - 1, used) ||
    			      helper(board, word, index + 1, i, j + 1, used);
    	used[i][j] = false;
    	return res;    	
    }
}
