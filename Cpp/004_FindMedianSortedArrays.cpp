#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

class Solution {
public:
    double findMedianSortedArrays(int a[], int m, int b[], int n) {
   
		int l = (m+n+1) >> 1;
		int r = (m+n+2) >> 1;
		return (getKth(a, m, b, n, l) + getKth(a, m, b, n, r)) / 2.0;
	} 

	int getKth(int a[], int m, int b[], int n, int k) {
		//let m <= n
		if (m > n) {
			return getKth(b, n, a, m, k);
		}
		if (m == 0) {
			return b[k-1];
		}
		if (k == 1) {
			return min(a[0], b[0]);
		}

		int i = min(m, k/2);
		int j = min(n, k/2);

		if (a[i-1] < b[j-1]) {
			return getKth(a+i, m-i, b, n, k-i);
		} else {
			return getKth(a, m, b+j, n-j, k-j);
		}
	}
};


void main() {
	
	Solution s;

	/*vector<int> num1;
	vector<int> num2;

	num1.push_back(1);
	num1.push_back(2);
	num1.push_back(2);
	num1.push_back(2);


	num2.push_back(3);
	num2.push_back(4);
	num2.push_back(4);
	num2.push_back(4);
*/
	//a.push_back(15);

	int a[] = {1, 2};
	int b[] = {3, 4};

	auto result = s.findMedianSortedArrays(a, 2, b, 2);
	cout << result << endl;


}
