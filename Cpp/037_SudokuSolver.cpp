//暴力回溯法
class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        if(board.size() == 0)
            return;
        solve(board);
    }
    
    bool solve(vector<vector<char>>& board) {
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board[0].size(); j++) {
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
    
    bool isValid(vector<vector<char>> board, int row, int col, char c) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] != '.' && board[row][i] == c) return false;
            if(board[i][col] != '.' && board[i][col] == c) return false;
            if(board[row/3*3+i/3][col/3*3+i%3] != '.' &&
               board[row/3*3+i/3][col/3*3+i%3] == c) return false;
        }
        return true;
    }
};



//
class Solution {
public:
	
	void solveSudoku(vector<vector<char> > &board) {
		solve(board, 0);
	}

	bool solve(vector<vector<char> >& board, int pos) {
		if(pos >= 81) return true;
		int i = pos / 9;
		int j = pos % 9;
		if(board[i][j] != '.')
			return solve(board, pos+1);
		else {
			for(char c = '1'; c <= '9'; c++) {
				if(isValid(board, i, j, c)) {
					board[i][j] = c;
					if(solve(board, pos+1))
						return true;
					else {
						board[i][j] = '.';
					}
				}
			}
			return false;
		}
	}

	bool isValid(vector<vector<char> >& board, int row, int col, char c) {
		for(int k = 0; k < 9; k++) {
			if(board[row][k] == c) return false;
			if(board[k][col] == c) return false;
			if(board[row/3*3+k/3][col/3*3+k%3] == c) return false;
		}
		return true;
	}
};
