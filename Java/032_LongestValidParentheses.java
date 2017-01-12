public class Solution {
    public int longestValidParentheses(String s) {
		int n = s.length(), longest = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == '(')
				stack.push(i);
			else {
				if(!stack.isEmpty()) {
					if(s.charAt(stack.peek()) == '(')
						stack.pop();
					else 
						stack.push(i);
				} else {
				    stack.push(i);
				}
			}
		}
		if(stack.isEmpty()) longest = n;
		else {
			int a = n, b = 0;
			while(!stack.isEmpty()) {
				b = stack.peek();
				stack.pop();
				longest = Math.max(longest, a-b-1);
				a = b;
			}
			longest = Math.max(longest, a);
		}
		return longest;
    }
}
