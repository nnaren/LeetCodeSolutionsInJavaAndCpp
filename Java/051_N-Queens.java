// fast
The number of columns is n, the number of 45° diagonals is 2 * n - 1, the number of 135° diagonals is also 2 * n - 1. 
When reach [row, col], the column No. is col, the 45° diagonal No. is row + col and the 135° diagonal No. is n - 1 + col - row. 
We can use three arrays to indicate if the column or the diagonal had a queen before, if not, 
we can put a queen in this position and continue.

/**    | | |                / / /             \ \ \
  *    O O O               O O O               O O O
  *    | | |              / / / /             \ \ \ \
  *    O O O               O O O               O O O
  *    | | |              / / / /             \ \ \ \ 
  *    O O O               O O O               O O O
  *    | | |              / / /                 \ \ \
  *   3 columns        5 45° diagonals     5 135° diagonals    (when n is 3)
  */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		int[] flag_col = new int[n];
		int[] flag_45 = new int[2*n-1];
		int[] flag_135 = new int[2*n-1];
		char[][] nQueens = new char[n][n];
		for(char[] row : nQueens)
			for(int i = 0; i < row.length; i++)
				row[i] = '.';
		solveNQueens(res, nQueens, 0, n, flag_col, flag_45, flag_135);
		return res;
    }
	
	private void solveNQueens(List<List<String>> res, char[][] nQueens, int row, int n,
							  int[] flag_col, int[] flag_45, int[] flag_135) {
		if(row == n) {
			res.add(contrust(nQueens));
			return;
		}
		for(int col = 0; col != n; ++col) {
			if(flag_col[col] == 0 && flag_45[row+col] == 0 && flag_135[n-1+col-row] == 0) {
				nQueens[row][col] = 'Q';
				flag_col[col] = flag_45[row+col] = flag_135[n-1+col-row] = 1;
				solveNQueens(res, nQueens, row+1, n, flag_col, flag_45, flag_135);
				nQueens[row][col] = '.';
				flag_col[col] = flag_45[row+col] = flag_135[n-1+col-row] = 0;
			}
		}
	}
	
	private List<String> contrust(char[][] nQueens) {
		List<String> res = new ArrayList<>();
		for(char[] row : nQueens) {
			res.add(new String(row));
		}
		return res;
	}
}

// slow
public class Solution {
    public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] nQueens = new char[n][n];
		for(char[] row : nQueens)
			for(int i = 0; i < row.length; i++)
				row[i] = '.';
		solveNQueens(res, nQueens, 0, n);
		return res;
    }
	
	private void solveNQueens(List<List<String>> res, char[][] nQueens, int row, int n) {
		
		if(row == n) {
			res.add(contrust(nQueens));
			return;
		}
		for(int col = 0; col != n; ++col) {
			if(isValid(nQueens, row, col, n)) {
				nQueens[row][col] = 'Q';
				solveNQueens(res, nQueens, row+1, n);
				nQueens[row][col] = '.';
			}
		}
	}
	
	private boolean isValid(char[][] nQueens, int row, int col, int n) {
		//check if the column had a queen before.
		for(int i = 0; i != row; ++i) {
			if(nQueens[i][col] == 'Q')
				return false;
		}
		//check if the 45° diagonal had a queen before.
		for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
			if(nQueens[i][j] == 'Q')
				return false;
		}
		//check if the 135° diagonal had a queen before.
		for(int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
			if(nQueens[i][j] == 'Q')
				return false;
		}
		return true;
	}
	
	private List<String> contrust(char[][] nQueens) {
		List<String> res = new ArrayList<>();
		for(char[] row : nQueens) {
			res.add(new String(row));
		}
		return res;
	}
}
