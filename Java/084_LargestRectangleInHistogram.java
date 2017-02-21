// slow easy
public class Solution {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}

// fast hard
public class Solution {
	public int largestRectangleArea(int[] height) {
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
