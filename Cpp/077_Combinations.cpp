// fast

class Solution {
public:
	vector<vector<int>> combine(int n, int k) {
		vector<vector<int>> res;
		vector<int> temp;
		dfs(res, temp, k, 1, n - k + 1);
		return res;
	}
	
	void dfs(vector<vector<int>>& res, vector<int>& temp, int kLeft, int from, int to) {
	    if (kLeft == 0) {
	        res.push_back(temp);
	        return;
	    }
	    for (int i = from; i <= to; ++i) {
	        temp.push_back(i);
	        dfs(res, temp, kLeft - 1, i + 1, to + 1);
	        temp.pop_back();
	    }
	}
};

// slow
class Solution {
public:
	vector<vector<int>> combine(int n, int k) {
		vector<vector<int>> res;
		int i = 0;
		vector<int> temp(k, 0);
		
		while (i >= 0) {
		    temp[i]++;
		    if (temp[i] > n) --i;
		    else if (i == k - 1) res.push_back(temp);
		    else {
		        ++i;
		        temp[i] = temp[i-1];
		    }
		}
	    return res;	
	}
};


