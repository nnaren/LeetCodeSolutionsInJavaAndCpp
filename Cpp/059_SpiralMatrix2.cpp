class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res(n, vector<int>(n, 0));
        if (n != 0) {
            circleIn(res, 0, n-1, 0, n-1, 1);
        }
        return res;
    }
    
    void circleIn(vector<vector<int>>& res, int row_from, int row_to, int col_from, int col_to, int start) {
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
};

// method 2
class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res(n, vector<int>(n, 0));
	    int left = 0,top = 0;
	    int right = n -1,down = n - 1;
	    int count = 1;
    	while (left <= right) {
		    for (int j = left; j <= right; j ++) {
			    res[top][j] = count++;
		    }
		    top ++;
		    for (int i = top; i <= down; i ++) {
			    res[i][right] = count ++;
		    }
		    right --;
		    for (int j = right; j >= left; j --) {
			    res[down][j] = count ++;
		    }
		    down --;
		    for (int i = down; i >= top; i --) {
		    	res[i][left] = count ++;
		    }
		    left ++;
	    }
	    return res;
    }
};
