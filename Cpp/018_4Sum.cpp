#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
	vector<vector<int>> fourSum(vector<int>& nums, int target) {
		
		vector<vector<int>> res;
		int len = nums.size();
		if (len < 4) return res;

		sort(nums.begin(), nums.end());
		int max = nums[len-1];

		if (4 * nums[0] > target || 4 * max < target)
			return res;

		int i, z;

		for (i = 0; i < len; i++) {
			z = nums[i];

			if (i > 0 && z == nums[i-1]) 
				continue;
			if (z + 3 * max < target)
				continue;
			if (z * 4 > target)
				break;
			if (z * 4 == target) {
				if(i + 3 < len && nums[i+3] == z) {
					vector<int> temp(4, z);
					res.push_back(temp);
				}
				break;
			}
			threeSum(nums, target-z, i+1, len-1, res, z);
		}
		return res;
	}

	void threeSum(vector<int> &nums, int target, int low, int high, vector<vector<int>>& res, int z1) {
		if (low + 1 >= high) {
			return;
		}

		int max = nums[high];
		if (3 * nums[low] > target || 3 * max < target)	{
			return;
		}

		int i, z;

		for (i = low; i < high-1; i++) {
			z = nums[i];
			if(i > low && z == nums[i-1]) 
				continue;
			if(z + 2 * max < target)
				continue;
			if(3 * z > target)
				break;
			if(3 * z == target) {
				if(i+1 < high && nums[i+2] == z) {
					vector<int> temp;
					temp.push_back(z1);
					temp.push_back(z);
					temp.push_back(z);
					temp.push_back(z);
					res.push_back(temp);
				}
				break;
			}
			twoSum(nums, target-z, i+1, high, res, z1, z);
		}
		return;
	}

	void twoSum(vector<int> &nums, int target, int low, int high, vector<vector<int>>& res, int z1, int z2) {
		if (low >= high) {
			return;
		}

		if (2 * nums[low] > target || 2 * nums[high] < target) {
			return;
		}

		int i = low, j = high, sum, x;
		while (i < j) {
			
			sum = nums[i] + nums[j];
			if (sum == target) {
				vector<int> temp;
				temp.push_back(z1);
				temp.push_back(z2);
				temp.push_back(nums[i]);
				temp.push_back(nums[j]);
				res.push_back(temp);
				x = nums[i];
				while (++i < j && x == nums[i]) ;
				x = nums[j];
				while (i < --j && x == nums[j]) ;	
			}
			if (sum < target) i++;
			if (sum > target) j--;
		}
		return;
	}
};
