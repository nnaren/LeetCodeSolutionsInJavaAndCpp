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
