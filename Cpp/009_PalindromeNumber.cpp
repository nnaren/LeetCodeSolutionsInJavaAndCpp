#include <iostream>
using namespace std;

class Solution {
public:
	bool isPalindrome(int x) {
		if (x<0|| (x!=0 &&x%10==0))
			return false;

		
		int reverseHalf = 0;
		while (x > reverseHalf) {
			reverseHalf = reverseHalf * 10 + x % 10;
			x /= 10;
		}
		return (x == reverseHalf) || (x == reverseHalf/10);
	}

	/*bool isPalindrome(int x) {
		if(x<0|| (x!=0 &&x%10==0)) return false;
		int sum=0;
		while(x>sum)
		{
			sum = sum*10+x%10;
			x = x/10;
		}
		return (x==sum)||(x==sum/10);
	}*/
};

void main() {
	Solution s;

	int x = 1210;
	cout << s.isPalindrome(x)<< endl;
}
