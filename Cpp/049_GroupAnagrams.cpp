class Solution {
public:
	vector<vector<string>> groupAnagrams(vector<string>& strs) {
		vector<vector<string>> res;
		if (strs.size() == 0) {
			return res;
		}
		unordered_map<string, vector<string>> map;
		for (string s : strs) {
			string ca(s);
			sort(ca.begin(), ca.end());
			if (map.find(ca) != map.end()) {
				vector<string> s_arr;
				pair<string, vector<string>> pair(ca, s_arr);
				map.insert(pair);
			}
			map[ca].push_back(s);
		}
		for (auto e : map) {
			res.push_back(e.second);
		}
		return res;
	}
};
