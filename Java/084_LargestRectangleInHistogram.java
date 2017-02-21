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
