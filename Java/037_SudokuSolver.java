//暴力回溯法
public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
        	return;
        solve(board);
    }
	
	public boolean solve(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == '.') {
					for(char c = '1'; c <= '9'; c++) {
						if(isValid(board, i, j, c)) {
							board[i][j] = c;
							if(solve(board))
								return true;
							else 
								board[i][j] = '.';
					
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isValid(char[][] board, int row, int col, char c) {
		for(int i = 0; i < 9; i++) {
			if(board[i][col] != '.' && board[i][col] == c) return false;
			if(board[row][i] != '.' && board[row][i] == c) return false;
			if(board[3*(row/3)+i/3][3*(col/3)+i%3] != '.' && board[3*(row/3)+i/3][3*(col/3)+i%3] == c) return false;
		}
		return true;
	}
}

//method 2
public class Solution {
    public void solveSudoku(char[][] board) {
        util(board, 0);
    }

	private boolean util(char[][] board, int pos) {
		if(pos >= 81)
			return true;
		int i = pos / 9;
		int j = pos % 9;
		if(board[i][j] != '.')
			return util(board, pos+1);
		else {
			for(char c = '1'; c <= '9'; c++) {
				if(!isInRow(board, i, c) && !isInCol(board, j, c) && !isInRec(board, i, j, c)) {
					board[i][j] = c;
					if(util(board, pos+1))
						return true;
					else 
						board[i][j] = '.';
				}
			}
			return false;
		}
	}
	
	private boolean isInRow(char[][] board, int i, char c) {
		for(int k = 0; k < 9; k++) {
			if(board[i][k] == c) return true;
		}
		return false;
	}
	
	private boolean isInCol(char[][] board, int j, char c) {
		for(int k = 0; k < 9; k++) {
			if(board[k][j] == c) return true;
		}
		return false;
	}
	
	private boolean isInRec(char[][] board, int i, int j, char c) {
		int bigRow = i / 3; 
		int bigCol = j / 3;
		for(int m = 3 * bigRow; m < 3 * (bigRow + 1); m++) {
			for(int n = 3 * bigCol; n < 3 * (bigCol + 1); n++) {
				if(board[m][n] == c) return true;
			}
		}
		return false;
	}
}
