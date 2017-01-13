class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int i = 0, j = nums.size()-1;
        vector<int> res(2, -1);
        if (nums.size() == 0) return res;
        while (i < j) {
            int mid = (i + j) / 2;
            if(nums[mid] < target) i = mid + 1;
            else j = mid;
        }
        if (nums[i] != target) return res;
        else res[0] = i;
        
        j = nums.size()-1;
        while (i < j) {
            int mid = (i + j) / 2 + 1;
            if (target < nums[mid]) j = mid - 1;
            else i = mid;
        }
        res[1] = j;
        return res;
    }
};


//method 2
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> res(2, -1);
        if(nums.size() == 0 || (nums.size() == 1 && nums[0] != target))
            return res;
        if(nums.size() == 1 && nums[0] == target) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        return searchRangeWithIndex(nums, target, 0, nums.size()-1);
    }
    
    vector<int> searchRangeWithIndex(vector<int>& nums, int target, int from, int to) {
        vector<int> res(2, -1);
        if(from > to || (from == to && nums[from] != target) || to < 0) {
            return res;
        }
        
        if(from == to && nums[from] == target) {
            res[0] = from;
            res[1] = to;
            return res;
        }
        
        int mid = bSearch(nums, from, to, target);
        if(mid == -1) return res;
        else {
            vector<int> left = searchRangeWithIndex(nums, target, from, mid-1);
            vector<int> right = searchRangeWithIndex(nums, target, mid+1, to);
            int leftIndex = -1, rightIndex = -1;
			if(left[0] == -1) leftIndex = mid;
			else leftIndex = left[0];
			if(right[1] == -1) rightIndex = mid;
			else rightIndex = right[1];
			res[0] = leftIndex;
			res[1] = rightIndex;
			return res;
        }
    }
    
    int bSearch(vector<int>& nums, int lo, int hi, int key) {
    	if(lo <= hi) {
			int mid = (lo + hi) / 2;
			if(nums[mid] == key) return mid;
			else if(nums[mid] < key) return bSearch(nums, mid+1, hi, key);
			else return bSearch(nums, lo, mid-1, key);
		} else return -1;
    }
};
