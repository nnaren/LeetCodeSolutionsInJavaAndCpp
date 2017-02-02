public class Solution {
    private void rotateCircle(int[][] matrix, int index, int numOfMove, int len) {
		
		while(numOfMove-- >= 1) {
			
			int tempUpRight = matrix[index][len-index-1]; //5
			for(int i = index, j = len-index-1; j > index; j--) {
				matrix[i][j] = matrix[i][j-1];
			}
			
			//right
			int tempRightDown = matrix[len-index-1][len-index-1]; // 9
			for(int i = len-index-1, j = len-index-1; i > index; i--) {
				matrix[i][j] = matrix[i-1][j];
			}
			matrix[index+1][len-1-index] = tempUpRight;
			
			//down
			int tempDownLeft = matrix[len-index-1][index]; // 13
			for(int i = len-index-1, j = index; j < len-index-1; j++) {
				matrix[i][j] = matrix[i][j+1];
			}
			matrix[len-1-index][len-1-index-1] = tempRightDown;
			
			//left
			for(int i = index, j = index; i < len-index-1; i++) {
				matrix[i][j] = matrix[i+1][j];
			}
			matrix[len-index-1-1][index] = tempDownLeft;
		}
	}
	
	public void rotate(int[][] matrix) {
		int len = matrix.length;
		if(len <= 1) return;
		int circles = len / 2;
		int numOfMove = len-1;
		for(int index = 0; index < circles; index++) {
			rotateCircle(matrix, index, numOfMove, len);
			numOfMove -= 2;
		}
	}
}
