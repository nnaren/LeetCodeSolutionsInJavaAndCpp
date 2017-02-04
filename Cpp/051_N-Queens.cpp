// fast
class Solution {
public:
	vector<vector<string>> solveNQueens(int n) {
		vector<vector<string>> res;
		vector<string> nQueens(n, string(n, '.'));
		vector<int> flag_col(n, 1), flag_45(2*n-1, 1), flag_135(2*n-1, 1); 
		solveNQueens(res, nQueens, 0, n, flag_col, flag_45, flag_135);
		return res;
	}
private:
	void solveNQueens(vector<vector<string>> &res, vector<string> &nQueens, int row, int n, 
					  vector<int> &flag_col, vector<int> &flag_45, vector<int> &flag_135) {
		if(row == n) {
			res.push_back(nQueens);
			return;
		}

		for (int col = 0; col != n; ++col) {
			if(flag_col[col] && flag_45[row+col] && flag_135[n-1+col-row]) {
				nQueens[row][col] = 'Q';
				flag_col[col] = flag_45[row+col] = flag_135[n-1+col-row] = 0;
				solveNQueens(res, nQueens, row+1, n, flag_col, flag_45, flag_135);
				nQueens[row][col] = '.';
				flag_col[col] = flag_45[row+col] = flag_135[n-1+col-row] = 1;
			}
		}
	}
};

// slow
class Solution {
public:
	vector<vector<string>> solveNQueens(int n) {
		vector<vector<string>> res;
		vector<string> nQueens(n, string(n, '.'));
		solveNQueens(res, nQueens, 0, n);
		return res;
	}
private:
	void solveNQueens(vector<vector<string>> &res, vector<string> &nQueens, int row, int n) {
		if(row == n) {
			res.push_back(nQueens);
			return;
		}

		for (int col = 0; col != n; ++col) {
			if(isValid(nQueens, row, col, n)) {
				nQueens[row][col] = 'Q';
				solveNQueens(res, nQueens, row+1, n);
				nQueens[row][col] = '.';
			}
		}
	}

	bool isValid(vector<string> &nQueens, int row, int col, int n) {
		for (int i = 0; i != row; ++i) {
			if(nQueens[i][col] == 'Q')
				return false;
		}
		for (int i = row-1, j = col-1; i >= 0 && j >= 0; --i, --j) {
			if(nQueens[i][j] == 'Q')
				return false;
		}
		for (int i = row-1, j = col+1; i >= 0 && j < n; --i, ++j) {
			if(nQueens[i][j] == 'Q')
				return false;
		}
		return true;
	}
};
