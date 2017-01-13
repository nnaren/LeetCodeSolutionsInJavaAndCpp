//利用Set容器的插入特性
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<String>();
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		char num = board[i][j];
        		if(num != '.') 
        			if(!seen.add(num+" in row " + i) || 
        			   !seen.add(num+" in col " + j) ||
        			   !seen.add(num+" in block " + i/3 + "-" + j/3))
        				return false;
        	}
        }
        return true;
    }
}

//method 2
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];
        
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		if(board[i][j] != '.') {
        			int num = board[i][j] - '0' - 1;
        			int k = i / 3 * 3 + j / 3;
        			if(row[i][num] == 1 || col[j][num] == 1 || block[k][num] == 1)
        				return false;
        			row[i][num] = col[j][num] = block[k][num] = 1;
        		}
        	}
        }
        return true;
	}
}
