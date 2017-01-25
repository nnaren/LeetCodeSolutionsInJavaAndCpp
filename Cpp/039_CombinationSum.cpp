class Solution {
public:
	vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
		sort(candidates.begin(), candidates.end());
		vector<vector<int> > res;
		vector<int> combination;
		backTrack(candidates, target, res, combination, 0);
		return res;
	}
private:
	void backTrack(vector<int> &candidates, int target, vector<vector<int> > &res, vector<int> &combination, int begin) {
		if(target == 0) {
			res.push_back(combination);
			return;
		} else {
			for(int i = begin; i < candidates.size() && target >= candidates[i]; ++i) {
				combination.push_back(candidates[i]);
				backTrack(candidates, target-candidates[i], res, combination, i);
				combination.pop_back();
			}
		}
	}
};
