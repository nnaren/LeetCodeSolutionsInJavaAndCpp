#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

class Solution {
public:
	/*int maxArea(vector<int>& height) {
		int maxWater = 0;
		auto first = height.begin();
		auto last = height.end();
		while (first <= last-2)	{
			int temp = *first > *(first+1) ? *(first+1) : *(first);
			maxWater = maxWater > temp ? maxWater : temp;
			first++;
		}
		return maxWater;
	}*/

	/*int maxArea(vector<int>& height) {
		int maxWater = 0;
		auto first = height.begin();
		auto last = height.end();

		for (auto first = height.begin(); first != height.end()-1; first++) {
			for (auto firstBack = first+1; firstBack != height.end(); firstBack++) {
				int high = *firstBack > *first ? *first : *firstBack;
				int tempArea = high * (firstBack-first);
				maxWater = maxWater > tempArea ? maxWater : tempArea;
			}
		}
		return maxWater;
	}*/

	int maxArea(vector<int>& height) {
		int water = 0;
		int i = 0, j = height.size()-1;
		
		while (i < j) {
			int h = min(height[i], height[j]);
			water = max(water, (j - i) * h);
			while (height[i] <= h && i < j) i++;
			while (height[j] <= h && i < j) j--;
		}
		return water;
	}
};

void main() {
	Solution s;

	vector<int> height;
	height.push_back(1);
	height.push_back(2);
	height.push_back(1);
	//height.push_back(1);
	//height.push_back(4);
	//height.push_back(1);

	cout << s.maxArea(height) << endl;


}
