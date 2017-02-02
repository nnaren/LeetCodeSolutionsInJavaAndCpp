class Solution {
public:
	vector<vector<int>> permute(vector<int>& nums) {
		vector<vector<int>> res;
		res.push_back(nums);
		vector<int> next(nums);
		nextPermutation(next);
		while(next != nums) {
			vector<int> tmp(next);
			res.push_back(tmp);
			nextPermutation(next);
		}
		return res;
	}

	void nextPermutation(vector<int>& nums) {
		if (nums.size() <= 1) return;
		int i = nums.size()-2;
		while (i >= 0 && nums[i] >= nums[i+1]) i--;
		if (i >= 0) {
			int j = nums.size()-1;
			while (nums[j] <= nums[i]) j--;
			swap(nums[i], nums[j]);
		}
		reverse(nums, i+1, nums.size()-1);
	}
	void reverse(vector<int> &nums, int from, int to) {
		while(from < to) swap(nums[from++], nums[to--]);
	}

};

//回溯法（速度慢）
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
		vector<vector<int>> res;
		vector<int> temp;
		backTrack(res, temp, nums);
		return res;
	}
	void backTrack(vector<vector<int>> &res, vector<int> &temp, vector<int> &nums) {
		if(temp.size() == nums.size()) {
			vector<int> list(temp);
			res.push_back(list);
		} else {
			for (int i = 0; i < nums.size(); i++) {
				if (find(temp.begin(), temp.end(), nums[i]) != temp.end())
					continue;
				temp.push_back(nums[i]);
				backTrack(res, temp, nums);
				temp.pop_back();
			}
		}
	}
};
