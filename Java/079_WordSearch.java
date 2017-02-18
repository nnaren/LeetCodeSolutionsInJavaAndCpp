// fast
public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(exist(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, int x, int y, String word, int start) {
        if(start >= word.length()) return true;
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (board[x][y] == word.charAt(start++)) {
            char c = board[x][y];
            board[x][y] = '#';
            boolean res = exist(board, x + 1, y, word, start) || exist(board, x - 1, y, word, start) ||
            exist(board, x, y + 1, word, start) || exist(board, x, y - 1, word, start);
            board[x][y] = c;
            return res;
        }
        return false;
    }
}

// edition 2
public class Solution {
    public boolean exist(char[][] board, String word) {
    	int row = board.length;
    	int col = board[0].length;
    	
    	for (int i = 0; i < row; ++i)
    		for(int j = 0; j < col; ++j)
    			if (isFound(board, word, i, j, 0))
    				return true;
    	return false;
    }
	
    private boolean isFound(char[][] board, String word, int row, int col, int charIdx) {
    	if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || word.charAt(charIdx) != board[row][col]) {
    		return false;
    	}
    	if (charIdx + 1 == word.length())
    		return true;
    	char tmp = board[row][col];
    	board[row][col] = '\0';
    	if (isFound(board, word, row+1, col, charIdx+1) || isFound(board, word, row-1, col, charIdx+1) || 
    		isFound(board, word, row, col+1, charIdx+1) || isFound(board, word, row, col-1, charIdx+1)) 
    		return true;
    	board[row][col] = tmp;
    	return false;
    }
}
