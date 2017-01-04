package leetCode;

import java.util.Stack;

public class ValidParentheses {
	
	public boolean isValid(String s) {
        
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else {
				if(stack.isEmpty() || ((s.charAt(i)-stack.peek()) != 1 && (s.charAt(i)-stack.peek()) != 2)) {
					return false;
				} else  {
					stack.pop();
				}
			}
		}
		
		return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		ValidParentheses v = new ValidParentheses();
		String s = ")[]";
		System.out.println(v.isValid(s));
		//System.out.println('}'-'{');
	}
}
