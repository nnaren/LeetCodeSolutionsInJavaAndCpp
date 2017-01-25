class Solution {
public:
	vector<vector<int> > combinationSum2(vector<int> &candidates, int target) {
		sort(candidates.begin(), candidates.end());
		vector<vector<int> > res;
		vector<int> combination;
		backTrack2(candidates, target, res, combination, 0);
		return res;
	}
private:
	void backTrack2(vector<int> &candidates, int target, vector<vector<int> > &res, vector<int> &combination, int begin) {
		if(target == 0) {
			res.push_back(combination);
			return;
		} else {
			for(int i = begin; i < candidates.size() && target >= candidates[i]; ++i) {
				if(i == begin || candidates[i] != candidates[i-1]) {
				    combination.push_back(candidates[i]);
				    backTrack2(candidates, target-candidates[i], res, combination, i+1);
				    combination.pop_back();
				}
			}
		}
	}
};
