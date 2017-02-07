class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        int row = matrix.size();
        int col = 0;
        if(row != 0) {
            col = matrix[0].size();
            circleIn(matrix, res, 0, row-1, 0, col-1);
        }
        return res;
    }
    
    void circleIn(vector<vector<int>>& matrix, vector<int>& res, int row_from, int row_to, int col_from, int col_to) {
        if(row_to < row_from || col_to < col_from)
			return;
		
		for(int j = col_from; j <= col_to; j++) {
			res.push_back(matrix[row_from][j]);
		}
		for(int i = row_from+1; i <= row_to; i++) {
			res.push_back(matrix[i][col_to]);
		}
		for(int j = col_to-1; j >= col_from && row_from != row_to; j--) {
			res.push_back(matrix[row_to][j]);
		}
		for(int i = row_to-1; i >= row_from+1 && col_from != col_to; i--) {
			res.push_back(matrix[i][col_from]);
		}
		circleIn(matrix, res, row_from+1, row_to-1, col_from+1, col_to-1);
    }
};
