public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n != 0) {
        	circleIn(res, 0, n-1, 0, n-1, 1);
        }
        return res;
    }
	
	private void circleIn(int[][] res, int row_from, int row_to, int col_from, int col_to, int start) {
		if (row_to < row_from || col_to < col_from) {
			return;
		}
		for (int j = col_from; j <= col_to; ++j) 
			res[row_from][j] = start++;
		for (int i = row_from+1; i <= row_to; ++i)
			res[i][col_to] = start++;
		for (int j = col_to-1; j >= col_from; --j)
			res[row_to][j] = start++;
		for (int i = row_to-1; i >= row_from+1; --i)
			res[i][col_from] = start++;
		circleIn(res, row_from+1, row_to-1, col_from+1, col_to-1, start);
	}
}
