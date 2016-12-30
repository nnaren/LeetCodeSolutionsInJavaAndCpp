class Solution {
public:
	string longestCommonPrefix(vector<string>& strs) {

		if (strs.size() == 0) {
			return "";
		}

		string pre = strs[0];
		int i = 1;
		while (i < strs.size()) {
			while (strs[i].find(pre) != 0) {
				pre = pre.substr(0, pre.length()-1);
			}
			i++;
		}
		return pre;
	}
};
