package DisjointSet;

import java.util.LinkedList;

public class SurroundedRegions {
	public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        for(int i = 0; i < board.length; i++) {
            union(board, i , 0);
            union(board, i, board[0].length - 1);
        }
        for(int i = 1; i < board[0].length - 1; i++) {
            union(board, 0 , i);
            union(board, board.length - 1, i);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '#')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
    private void union(char[][] board, int i, int j) {
        if(board[i][j] != 'O') return;
        board[i][j] = '#';
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(i * board[0].length + j);
        while(!queue.isEmpty()) {
            int loc = queue.remove();
            int row = loc / board[0].length;
            int col = loc % board[0].length;
            if(row > 1 && board[row - 1][col] == 'O') {
                board[row - 1][col] = '#';
                queue.add((row - 1) * board[0].length + col);
            }
            if(row < board.length - 1 && board[row + 1][col] == 'O') {
                board[row + 1][col] = '#';
                queue.add((row + 1) * board[0].length + col);
            }
            if(col > 1 && board[row][col - 1] == 'O') {
                board[row][col - 1] = '#';
                queue.add(row * board[0].length + col - 1);
            }
            if(col < board[0].length - 1 && board[row][col + 1] == 'O') {
                board[row][col + 1] = '#';
                queue.add(row * board[0].length + col + 1);
            }
        }
    }
}
