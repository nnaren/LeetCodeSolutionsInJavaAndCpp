// bitMark
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int numOfSubsets = 1 << nums.size();
        vector<vector<int>> res(numOfSubsets, vector<int>());
        
        for (int i = 0; i < nums.size(); ++i) 
            for (int j = 0; j < numOfSubsets; ++j)
                if ((j >> i) & 1)
                    res[j].push_back(nums[i]);
        return res;
    }
};

// Iterative
This problem can also be solved iteratively. Take [1, 2, 3] in the problem statement as an example.
The process of generating all the subsets is like:

Initially: \[\[\]\]
Adding the first number to all the existed subsets: [[], [1]];
Adding the second number to all the existed subsets: [[], [1], [2], [1, 2]];
Adding the third number to all the existed subsets: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
Have you got the idea :-)

The code is as follows.

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> subs(1, vector<int>());
        for (int i = 0; i < nums.size(); i++) {
            int n = subs.size();
            for (int j = 0; j < n; j++) {
                subs.push_back(subs[j]); 
                subs.back().push_back(nums[i]);
            }
        }
        return subs;
    }
}; 
    


// backTrack
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> subs;
        vector<int> sub;  
        genSubsets(nums, 0, sub, subs);
        return subs; 
    }
    void genSubsets(vector<int>& nums, int start, vector<int>& sub, vector<vector<int>>& subs) {
        subs.push_back(sub);
        for (int i = start; i < nums.size(); i++) {
            sub.push_back(nums[i]);
            genSubsets(nums, i + 1, sub, subs);
            sub.pop_back();
        }
    }
};
