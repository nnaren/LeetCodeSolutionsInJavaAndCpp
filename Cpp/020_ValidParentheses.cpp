class Solution {
public:
	bool isValid(string s) {
		stack<char> stack;
		for (int i = 0; i < s.length(); i++) {
			if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
				stack.push(s[i]);
			} else {
				if (stack.empty() || ((s[i]-stack.top()) != 1 && (s[i]-stack.top()) != 2)) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.empty();
	}
};
