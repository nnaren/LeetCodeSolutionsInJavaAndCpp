#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

class Solution {
public:
    	vector<int> twoSum(vector<int> &numbers, int target) {
		
		vector<int> result;
		unordered_map<int, int> hash;

		for (int i = 0; i < numbers.size(); i++) {
			//find another nums
			int anOther = target - numbers[i];
			
			//Searches the container for an element 
			//with k as key and returns an iterator 
			//to it if found, otherwise it returns 
			//an iterator to unordered_map::end
			if (hash.find(anOther) != hash.end()) {
			    result.push_back(hash[anOther]);
				result.push_back(i);
			}

			//number was not found. Put it in the map.
			hash[numbers[i]] = i;
		}
		return result;
	}
};
