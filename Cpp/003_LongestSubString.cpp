#include<iostream>
#include<string>
#include<unordered_map>
#include<algorithm>
using namespace std;


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
		if (s.length() == 0) {
			return 0;
		}
		int maxLength = 0;

		unordered_map<char, int> Hash;

		for (int i = 0, j = 0; i < s.length(); i++) {

			if (Hash.find(s[i]) != Hash.end()) {

				j = max(j, Hash.at(s[i])+1);
			
			}

			Hash[s[i]] = i;
			
			maxLength = max(maxLength, i-j+1);
		
		}
		
		return maxLength;
    
	}
};

void main() {
	Solution s;
	string str = "abcdddefghijk";
	cout << s.lengthOfLongestSubstring(str);
}
