class Solution {
public:
	bool isMatch(string str, string pattern) {
		int s = 0, p = 0, starIdx = -1, match = 0;
		while (s < str.length()) {
			if (p < pattern.length() && (pattern[p] == '?' || pattern[p] == str[s])) {
				++s;
				++p;
			} else if (p < pattern.length() && pattern[p] == '*') {
				starIdx = p;
				match = s;
				++p;
			} else if (starIdx != -1) {
				p = starIdx + 1;
				++match;
				s = match;
			} else return false;
		}

		while (p < pattern.length() && pattern[p] == '*') {
			++p;
		}
		return p == pattern.length();
	}
};
