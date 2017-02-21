// dp
The DP solution proceeds row by row, starting from the first row. Let the maximal rectangle area at row i and column j 
be computed by [right(i,j) - left(i,j)]*height(i,j).

All the 3 variables left, right, and height can be determined by the information from previous row, and also information 
from the current row. So it can be regarded as a DP solution. The transition equations are:

left(i,j) = max(left(i-1,j), cur_left), cur_left can be determined from the current row
right(i,j) = min(right(i-1,j), cur_right), cur_right can be determined from the current row
height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
height(i,j) = 0, if matrix[i][j]=='0'

matrix
0 1 1 1 1 1 0
0 0 1 1 1 0 0
0 0 0 1 0 0 0

height
0 1 1 1 1 1 0
0 0 2 2 2 0 0
0 0 0 3 0 0 0

left
0 1 1 1 1 1 0
0 0 2 2 2 0 0
0 0 0 3 0 0 0

right
7 6 6 6 6 6 7
7 7 5 5 5 7 7
7 7 7 4 7 7 7

result
0 5 5 5 5 5 0
0 0 6 6 6 0 0
0 0 0 3 0 0 0

matrix
1 1 1 0 0 0 0 0
1 1 1 1 1 1 1 1
0 0 0 0 1 1 1 1
0 0 0 0 1 1 1 1

height
1 1 1 0 0 0 0 0
2 2 2 1 1 1 1 1
0 0 0 0 2 2 2 2
0 0 0 0 3 3 3 3

left
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 4 4 4 4
0 0 0 0 4 4 4 4

right
3 3 3 8 8 8 8 8
3 3 3 8 8 8 8 8
8 8 8 8 8 8 8 8
8 8 8 8 8 8 8 8

result
3 3 3 0 0 0 0 0
6 6 6 8 8 8 8 8
0 0 0 0 8 8 8 8
0 0 0 0 12 12 12 12
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
0  0  0  1  0  0  0

0  0  1  1  1  0  0

0  1  1  1  1  1  0

#the 1th row: calculate the are from left to right which enclosed by '*'
        ***
0  0  0 *1* 0  0  0
        ***
0  0  1  1  1  0  0

0  1  1  1  1  1  0

#the 2th row: calculate the are from left to right
1th area:                      2th area:
                                       ***
0  0  0  1  0  0  0            0  0  0 *1* 0  0  0
     *********                         * *      
0  0 *1  1  1* 0  0            0  0  1 *1* 1  0  0
     *********                         ***            
0  1  1  1  1  1  0            0  1  1  1  1  1  0

3th area: 
                                   
0  0  0  1  0  0  0            
     *********                               
0  0 *1  1  1* 0  0           
     ********* 
0  1  1  1  1  1  0   

#the 3th row: calculate the are from left to right
1th area:                      2th area:                

0  0  0  1  0  0  0            0  0  0  1  0  0  0   
                                    *********
0  0  1  1  1  0  0            0  0 *1  1  1* 0  0
  ***************                   *       *
0 *1  1  1  1  1* 0            0  1 *1  1  1* 1  0
  ***************                   *********
3th area:                      4th area:                
        ***
0  0  0 *1* 0  0  0            0  0  0  1  0  0  0   
        * *                         *********
0  0  1 *1* 1  0  0            0  0 *1  1  1* 0  0
        * *                         *       *
0  1  1 *1* 1  1  0            0  1 *1  1  1* 1  0
        ***                         *********
5th area:                                     

0  0  0  1  0  0  0          
                                   
0  0  1  1  1  0  0         
  ***************               
0 *1  1  1  1  1* 0          
  ***************           

///////////////////////////////////////////////////////////////////////////////////////////////////////	
// CODE	
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int max = 0;
        int[] left = new int[col];
        int[] right = new int[col];
        int[] height = new int[col];
        Arrays.fill(right, col);
        
        for (int i = 0; i < row; i++) {
        	int cur_left = 0, cur_right = col;
        	
        	for (int j = 0; j < col; j++) {
        		if (matrix[i][j] == '1') height[j]++;
        		else height[j] = 0;
        	}
        	
        	for (int j = 0; j < col; j++) {
        		if (matrix[i][j] == '1') 
        			left[j] = Math.max(left[j], cur_left);
        		else {
        			left[j] = 0;
        			cur_left = j + 1;
        		}
        	}
        	
        	for (int j = col - 1; j >= 0; j--) {
        		if (matrix[i][j] == '1') 
        			right[j] = Math.min(right[j], cur_right);
        		else {
        			right[j] = col;
        			cur_right = j;
        		}
        	}
        	
        	for (int j = 0; j < col; j++) 
        		max = Math.max(max, (right[j]-left[j])*height[j]);
        }
        return max;
    }
}

// method 2
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int[] height = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[0][i] == '1') height[i] = 1;
        }
        int result = largestInLine(height);
        for(int i = 1; i < matrix.length; i ++){
            resetHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }
        
        return result;
    }
    
    private void resetHeight(char[][] matrix, int[] height, int idx){
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }    
    
    public int largestInLine(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int max_area = 0;
		for (int i = 0; i <= height.length; ++i) {
			int height_bound = (i == height.length) ? 0 : height[i];
			while (!stack.isEmpty()) {
				int h = height[stack.peek()];
				if (h < height_bound) break;
				stack.pop();
				int index_bound = stack.isEmpty() ? -1 : stack.peek();
				max_area = Math.max(max_area, h * ((i - 1) - index_bound));
			}
			stack.push(i);
		}
		return max_area;
	}
}
