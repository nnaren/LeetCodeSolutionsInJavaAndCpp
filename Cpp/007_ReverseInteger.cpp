#include<iostream>
#include<stack>
#include <limits>
using namespace std;


class Solution {
public:
	int reverse(int x) {

		long long result = 0;

		while (x) {				
			result = result*10 + x%10;
			x /= 10;
		}
		return (result < INT_MIN || result > INT_MAX) ? 0 : result;
	}	
};

void main() {

	Solution s;
	int num = 1534236469;
	cout << INT_MAX << endl;
	cout << s.reverse(num) << endl;
}
