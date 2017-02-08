class Solution {
public:
    bool canJump(vector<int>& nums) {
        int maxLength = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(i > maxLength) return false;
            maxLength = max(maxLength, nums[i]+i);
        }
        return true;
    }
};
