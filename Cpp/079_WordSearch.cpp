class Solution {
public:
	bool exist(vector<vector<char> > &board, string word) {
        int row = board.size();
    	int col = board[0].size();
    	
    	for (int i = 0; i < row; ++i)
    		for(int j = 0; j < col; ++j)
    			if (isFound(board, word.c_str(), i, j))
    				return true;
    	return false;
    }
private:
    bool isFound(vector<vector<char> > &board, const char* c, int row, int col) {
        if (row < 0 || col < 0 || row >= board.size() || col >= board[0].size() || *c != board[row][col]) {
    		return false;
    	}
    	if (*(c+1) == '\0')
    		return true;
    	char tmp = board[row][col];
    	board[row][col] = '\0';
    	if (isFound(board, c+1, row+1, col) || isFound(board, c+1, row-1, col) || 
    		isFound(board, c+1, row, col+1) || isFound(board, c+1, row, col-1)) 
    		return true;
    	board[row][col] = tmp;
    	return false;
    }
};
