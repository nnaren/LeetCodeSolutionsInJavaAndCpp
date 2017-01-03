class Solution {
public:
	vector<string> letterCombinations(string digits) {
		vector<string> res;
		if (digits.length() == 0) {
			return res;
		}

		string charMap[10] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		res.push_back("");
		for (int i = 0; i < digits.length(); i++) {
			vector<string> temp;
			string chars = charMap[digits[i]-'0'];
			for (int c = 0; c < chars.size(); c++) {
				for (int j = 0; j < res.size(); j++) {
					temp.push_back(res[j]+chars[c]);
				}
			}
			res = temp;
		}
		return res;
	}
};
