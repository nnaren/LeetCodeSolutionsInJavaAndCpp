#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


class Solution {
public:
	vector<vector<int>> threeSum(vector<int>& nums) {

		vector<vector<int>> result;
		sort(nums.begin(), nums.end());

		for (int i = 0; i < nums.size()-2; i++)	{
			if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
				int lo = i+1, hi = nums.size()-1, sum = 0-nums[i];
				while (lo < hi) {
					if(nums[lo] + nums[hi] == sum) {
						vector<int> oneRes;
						oneRes.push_back(nums[i]);
						oneRes.push_back(nums[lo]);
						oneRes.push_back(nums[hi]);
						result.push_back(oneRes);
						while (lo < hi && nums[lo] == nums[lo+1]) lo++;
						while (lo < hi && nums[hi] == nums[hi-1]) hi--;
						lo++;
						hi--;
					} else if(nums[lo] + nums[hi] < sum) {
						lo++;
					} else {
						hi--;
					}
				}
			}
		}
		return result;
	}
};

//[-1, 0, 1, 2, -1, -4],
void main() {
	Solution s;
	vector<int> v;
	v.push_back(-1);
	v.push_back(0);
	v.push_back(1);
	v.push_back(2);
	v.push_back(-1);
	v.push_back(-4);

	auto res = s.threeSum(v);

	

	auto ibegin = res.begin();
	auto iend = res.end();
	//sort(ibegin, iend);
	while (ibegin != iend) {

		auto jbegin = ibegin->begin();
		auto jend = ibegin->end();

		while (jbegin != jend) {
			cout << *jbegin << " ";
			jbegin++;
 		}
		cout << endl;
		ibegin++;
	}
	
	

	/*for (int i = 0; i < res.size(); i++) {
		
		for (int j = 0; j < 3; j++)	{
			cout << res[i][j] << " ";
		}

		cout << endl;
	}*/
}
