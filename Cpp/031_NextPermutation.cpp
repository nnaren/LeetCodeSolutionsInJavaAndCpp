/////method 1
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
    	if (nums.size() <= 1) return;
    	int i = nums.size()-2;
    	while (i >= 0 && nums[i] >= nums[i+1]) i--;
    	if (i >= 0) {
    	    int j = nums.size()-1;
    	    while (nums[j] <= nums[i]) j--;
    	    swap(nums[i], nums[j]);
    	}
    	reverse(nums.begin()+i+1, nums.end());
    }
}; 



/////method 2
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        if(nums.size() <= 1) return;
        if(nums.size() == 2) {
            swap(nums[0], nums[1]);
            return;
        }
        if(goDown(nums, 0, nums.size()-1)) {
            reverse(nums.begin(), nums.end());
            return;
        }
        nextPerWithIndex(nums, 0, nums.size()-1);
    }
    
    void nextPerWithIndex(vector<int>& nums, int from, int to) {
        if(from > nums.size()-1 || to <= from) return;
        if(goDown(nums, from+1, to)) {
            int i = to;
            for(; i >= from + 1; i--) {
                if(nums[i] > nums[from]) break;
            }
            swap(nums[from], nums[i]);
            reverse(nums.begin()+from+1, nums.end());
            return;
        }
        nextPerWithIndex(nums, from + 1, to);
    }
    
    bool goDown(vector<int>& nums, int from, int to) {
        for(int i = from; i < to; i++) {
			if(nums[i] < nums[i+1]) 
				return false;
		}
		return true;
    }
}; 

