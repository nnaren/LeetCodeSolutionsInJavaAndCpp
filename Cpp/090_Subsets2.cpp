// backTrack
class Solution {
public:
    vector<vector<int> > subsetsWithDup(vector<int> &nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        vector<int> temp;
        subsetsWithDup(res, nums, temp, 0);
        return res;
    }
    
    void subsetsWithDup(vector<vector<int>>& res, vector<int>& nums, vector<int>& temp, int begin) {
		res.push_back(temp);
		for (int i = begin; i < nums.size(); ++i) {
			if (i == begin || nums[i] != nums[i-1]) {
				temp.push_back(nums[i]);
				subsetsWithDup(res, nums, temp, i+1);
				temp.pop_back();
		    }	  
	    }
	}
};

// iterative
class Solution {
public:
    vector<vector<int> > subsetsWithDup(vector<int> &S) {
        sort(S.begin(), S.end());
        vector<vector<int>> ret = {{}};
        int size = 0, startIndex = 0;
        for (int i = 0; i < S.size(); i++) {
            startIndex = i >= 1 && S[i] == S[i - 1] ? size : 0;
            size = ret.size();
            for (int j = startIndex; j < size; j++) {
                vector<int> temp = ret[j];
                temp.push_back(S[i]);
                ret.push_back(temp);
            }
        }
        return ret;
    }
};
