class Solution {
public:
    vector<int> maxSlidingWindow(vector<int> &nums, int k) {
        int len = nums.size();
        if (len == 0) return nums;
        vector<int> res(len - k + 1);
        deque<int> dq;
        
        for (int i = 0; i < len; ++i) {
            if (!dq.empty() && dq[0] < i - k + 1)
                dq.pop_front();
            
            while (!dq.empty() && nums[i] > nums[dq.back()])
                dq.pop_back();
            
            dq.push_back(i);
            
            if (i - k + 1 >= 0)
                res[i - k + 1] = nums[dq[0]];
        }
        return res;
    }
};
