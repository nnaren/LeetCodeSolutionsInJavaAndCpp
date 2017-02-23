// The idea is simple. G(i) = i ^ (i/2).
class Solution {
public:
    vector<int> grayCode(int n) {         
        vector<int> result;
        for (int i = 0; i < 1<<n; i++) result.push_back(i ^ i>>1);
        return result;
    }
};


// recursive
class Solution {
public:
    vector<int> grayCode(int n) {         
        vector<int> res(1, 0);
        for (int i = 0; i < n; i++) {
            int curSize = res.size();
            while (curSize--) {
                int numTemp = res[curSize] + (1 << i);
                res.push_back(numTemp);
            }
        }
        return res;
    }
};
